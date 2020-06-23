package com.nhatpoly.NhatAssignment5.controller;

import com.nhatpoly.NhatAssignment5.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginWeb {

    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @RequestMapping("/login")
    public String Index( @CookieValue(value = "setUser", defaultValue = "") String setUser, Model model) {
    Cookie cookie = new Cookie("setUser",setUser);
//        User user = new User();
        model.addAttribute("cookieValue",cookie);
        return "web/login";
    }

    @PostMapping("/login")
    public String doLogin(@ModelAttribute("user") User user,
                          Model model,
                          @CookieValue(value = "setUser", defaultValue = "") String setUser,

                          HttpServletResponse response,
                          HttpServletRequest request) {
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        if (user.getName().equals("nhatntp") && user.getPassword().equals("12345")) {
            System.out.println("d");
            if (user.getName() != null)
                setUser = user.getName();
            Cookie cookie = new Cookie("setUser", setUser);

            response.addCookie(cookie);
            Cookie[] cookies = request.getCookies();
            for (Cookie ck : cookies) {
                if (ck.getName().equals("setUser")) {
                    model.addAttribute("cookieValue", ck);
                    break;
                } else {
                    ck.setValue("");
                    model.addAttribute("cookieValue", ck);
                    break;
                }
            }
            model.addAttribute("message", "Login success. Welcome ");
            return "redirect:/home";
        } else {
            user.setName("");
            Cookie cookie = new Cookie("setUser", setUser);
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("message", "Login failed. Try again.");
            return "redirect:/login";
        }

    }

}
