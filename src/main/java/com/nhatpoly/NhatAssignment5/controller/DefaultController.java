package com.nhatpoly.NhatAssignment5.controller;

import com.nhatpoly.NhatAssignment5.model.Product;
import com.nhatpoly.NhatAssignment5.reponseitory.ProductReponseitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {
    @Autowired
    private ProductReponseitory productReponseitory;
    @RequestMapping("/product/{id}")
    public String product(@PathVariable("id") Product product, Model model) {
        model.addAttribute("product", product);
        return "listProduct";

    }
}
