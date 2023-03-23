package com.springboot.bootstrap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String loginPage(){
        return "auth-login";
    }

    @RequestMapping("/home")
    public String loginSubmit(){
        return "/pages/landing_page";
    }

    @RequestMapping("/table")
    public String string(){
        return "/pages/table";
    }

    @RequestMapping("/table-datatable")
    public String table(){
        return "/pages/table-datatable";
    }

    @RequestMapping("/form")
    public String form(){
        return "/pages/form";
    }

    @RequestMapping("/register")
    public String register(){
        return "/pages/register";
    }



}
