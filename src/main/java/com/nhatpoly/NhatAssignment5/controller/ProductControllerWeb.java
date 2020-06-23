package com.nhatpoly.NhatAssignment5.controller;

import com.nhatpoly.NhatAssignment5.model.Product;
import com.nhatpoly.NhatAssignment5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
public class ProductControllerWeb {
    @Autowired
    ProductService productService;
    @RequestMapping( "/home")
    public String home(Model model){
        List<Product> products = productService.findAllProduct();
        model.addAttribute("products",products);
        return "web/product";
    }
}
