package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @GetMapping()
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String redirect() {
        return "login";
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", authentication.getName());
        return "hello";
    }
}

