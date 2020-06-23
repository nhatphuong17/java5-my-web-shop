package com.nhatpoly.NhatAssignment5.controller;



import com.nhatpoly.NhatAssignment5.model.Product;
import com.nhatpoly.NhatAssignment5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller

public class ProductController {
@Autowired
ProductService productService;
    @RequestMapping({"/", "/list-product"})
    public String index(Model model){
        List<Product> products = productService.findAllProduct();
        model.addAttribute("products",products);
        return "admin/product/listProduct";
    }


    @RequestMapping(value = "/add")
    public String addProducts(Model model){
        Product product = new Product();
        model.addAttribute("products", product);
        return "admin/product/addProduct";
    }

    @RequestMapping("edit/{id}")
    public ModelAndView edit(@PathVariable(name="id") Integer id) {
        ModelAndView mav = new ModelAndView("admin/product/editProduct") ;
        Product productEdit = productService.findProductById(id);
        System.out.print(productEdit.getName());
        mav.addObject("product" ,productEdit );
        return mav;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/";
    }

    @RequestMapping(value = "delete/{id}",method=RequestMethod.GET)
    public String deleteProduct(@PathVariable(name = "id")  Integer productid) {
        productService.deleteProduct(productid);
        return"redirect:/";
    }

}
