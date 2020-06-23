package com.nhatpoly.NhatAssignment5.controller;

import javax.servlet.http.HttpSession;

import com.nhatpoly.NhatAssignment5.cart.model.Cart;
import com.nhatpoly.NhatAssignment5.cart.model.CartManager;
import com.nhatpoly.NhatAssignment5.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/cart")
public class ShoppingCart {
	@Autowired
    private CartManager cartManager;
    @RequestMapping("/add")
    public String add(HttpSession session,Model modal, @RequestParam("id") Product product,
                             @RequestParam(value = "quantity", required = false, defaultValue = "1") int quantity){
        Cart cart = cartManager.getCart(session);
        cart.addItem(product, quantity);

        double tong = cart.getTotal();

        modal.addAttribute("tongtien", tong);

        return "web/cart";
    }

    @RequestMapping("/remove")
    public String remove(HttpSession session, Model model,@RequestParam("id") Product product){
        Cart cart = cartManager.getCart(session);
        cart.removeItem(product);
        double tong = cart.getTotal();
        model.addAttribute("tongtien", tong);
        return "web/cart";
    }

    @RequestMapping("/update")
    public String update(HttpSession session,Model model, @RequestParam("id") Product product, @RequestParam("quantity") int quantity){
        Cart cart = cartManager.getCart(session);
        cart.updateItem(product, quantity);
        double tong = cart.getTotal();
        model.addAttribute("tongtien", tong);
        return "web/cart";
    }

}
