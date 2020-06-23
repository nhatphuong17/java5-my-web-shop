package com.nhatpoly.NhatAssignment5.controller;

import com.nhatpoly.NhatAssignment5.model.Product;
import com.nhatpoly.NhatAssignment5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class Homepage {

    @GetMapping("/chaythu")
    public String home(){
        return "web/homepage";
    }
    @GetMapping("/sanpham")
    public String sanpham(){
        return "web/product";
    }

    @GetMapping("/login")
    public String dangnhap(){
        return "web/login";
    }

    @GetMapping("/register")
    public String dangky(){
        return "web/register";
    }
    @GetMapping("/cart")
    public String cart(){
        return "web/cart";
    }
}
