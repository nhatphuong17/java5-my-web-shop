package com.nhatpoly.NhatAssignment5.controller;


import com.nhatpoly.NhatAssignment5.model.User;
import com.nhatpoly.NhatAssignment5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("home/")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public String index(Model model){
        List<User> users = userService.findAllUsers();
        model.addAttribute("user",users);
        System.out.println(users.size());
        return "admin/user/index";
    }
    @RequestMapping(value = "/add")
    public String addUser(Model model){
        User user = new User();
       model.addAttribute("user",user);
        return "admin/user/addUser";
    }

   @RequestMapping("/edit{id}")
   public ModelAndView edit(@PathVariable(name="id") long id) {
    ModelAndView mav = new ModelAndView("admin/user/editUser");
    User userEdit = userService.findUserById(id);
    mav.addObject("user" ,userEdit );
    return mav;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/home/";
    }

    @RequestMapping(value = "/delete{id}",method=RequestMethod.GET)
    public String deleteUser(@PathVariable(name = "id")long id) {
        userService.deleteUser(id);
        return"redirect:/home/";
    }
}
