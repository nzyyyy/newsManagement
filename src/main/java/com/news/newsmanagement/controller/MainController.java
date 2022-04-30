package com.news.newsmanagement.controller;

import com.news.newsmanagement.exception.SystemException;
import com.news.newsmanagement.service.impl.NewInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    public NewInfoServiceImpl newInfoService;
    @GetMapping
    public String showMain(Model model,@RequestParam(value = "page",required = false) Integer page){
        if (page==null){
            model.addAttribute("list", newInfoService.getListByPage(1));
            model.addAttribute("pageNum", 1);
        }else {
            model.addAttribute("list", newInfoService.getListByPage(page));
            model.addAttribute("pageNum", page);
        }
        model.addAttribute("page", newInfoService.getPageCount());
        return "index";
    }
    @GetMapping("/deny")
    public String showDeny(Model model){
        return "deny";
    }
    @GetMapping("/register")
    public String showRegister(Model model){
        return "signup";
    }
    @GetMapping("/login")
    public String showLoginPage(Model model){
        return "login";
    }
}
