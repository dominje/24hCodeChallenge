package com.challenge.PizzaParlor.controller;

import com.challenge.PizzaParlor.model.orderdetails.OrderDetails;
import com.challenge.PizzaParlor.model.pizza.Pizza;
import com.challenge.PizzaParlor.model.pizzatype.PizzaType;
import com.challenge.PizzaParlor.model.order.Order;
import com.challenge.PizzaParlor.service.OrderDetailsService;
import com.challenge.PizzaParlor.service.OrderService;
import com.challenge.PizzaParlor.utils.UtilsClass;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailsService orderDetailsService;
    private UtilsClass utils;

    @RequestMapping(method = RequestMethod.GET)
    ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", "Upload CSV file");
        return mav;
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile multipartFile) {

        if(utils.hasCSVFormat(multipartFile)) {
           try (Reader reader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()))) {
               CsvToBean<?> csvToBean = null;
               List<Order> orderList = null;
               List<OrderDetails> orderDetailsList = null;
               List<Pizza> pizzaList = null;
               List<PizzaType> pizzaTypeList = null;
               if(multipartFile.getOriginalFilename().equals("orders.csv")) {
                   csvToBean = (CsvToBean<Order>) convertToBean(reader, Order.class);
                   orderList = (List<Order>) csvToBean.parse();
                   orderList.stream().forEach(order -> orderService.submitNewOrder(order));
               }else if(multipartFile.getOriginalFilename().equals("order_details.csv")){
                   csvToBean = convertToBean(reader, OrderDetails.class);
                   orderDetailsList = (List<OrderDetails>) csvToBean.parse();
                   orderDetailsList.stream().forEach(orderDetails -> orderDetailsService.addOrderDetails(orderDetails));
               }else if(multipartFile.getOriginalFilename().equals("pizza.csv")){
                   csvToBean = convertToBean(reader, Pizza.class);
                   pizzaList = (List<Pizza>) csvToBean.parse();
               }else if(multipartFile.getOriginalFilename().equals("pizza_type.csv")){
                   csvToBean = convertToBean(reader, PizzaType.class);
                   pizzaTypeList = (List<PizzaType>) csvToBean.parse();
               }else{
                   return "upload-failed";
               }
               return "upload-success";
            } catch (Exception ex) {
                return "upload-failed";
            }

        } else {
            return "upload-failed";
        }

    }

    public CsvToBean<?> convertToBean(Reader reader, Class objClass) {
        CsvToBean<?> csvToBean;
        csvToBean = new CsvToBeanBuilder(reader)
                .withType(objClass)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        return csvToBean;
    }
}
