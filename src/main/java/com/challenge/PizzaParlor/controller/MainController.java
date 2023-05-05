package com.challenge.PizzaParlor.controller;

import com.challenge.PizzaParlor.model.orderdetails.OrderDetails;
import com.challenge.PizzaParlor.model.Pizza;
import com.challenge.PizzaParlor.model.PizzaType;
import com.challenge.PizzaParlor.model.order.Order;
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
    private OrderService service;
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
               CsvToBean<Order> csvToBean = null;
               Object objClass = null;
               if(multipartFile.getOriginalFilename().equals("orders.csv")) {
                   objClass = Order.class;
               }else if(multipartFile.getOriginalFilename().equals("order_details.csv")){
                   objClass = OrderDetails.class;
               }else if(multipartFile.getOriginalFilename().equals("pizza.csv")){
                   objClass = Pizza.class;
               }else if(multipartFile.getOriginalFilename().equals("pizza_type.csv")){
                   objClass = PizzaType.class;
               }else{
                   return "upload-failed";
               }
               csvToBean = new CsvToBeanBuilder(reader)
                       .withType((Class) objClass)
                       .withIgnoreLeadingWhiteSpace(true)
                       .build();

                List<Order> orderList = csvToBean.parse();
                orderList.stream().forEach(order -> service.submitNewOrder(order));
               return "upload-success";
            } catch (Exception ex) {
                return "upload-failed";
            }

        } else {
            return "upload-failed";
        }

    }
}
