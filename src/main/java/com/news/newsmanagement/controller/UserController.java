package com.news.newsmanagement.controller;


import com.news.newsmanagement.controller.dto.AccountDto;
import com.news.newsmanagement.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 宁致远
 * @since 2022-04-28
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;
//    @PostMapping("/login")
//    public String login(Model model, @Valid AccountDto accountDto){
//        System.out.println(accountDto);
//        if (userService.login(accountDto)){
//            System.out.println("success");
//            return "redirect:/";
//        }else {
//            return "login";
//        }
//
//    }


    @PostMapping("/register")
    public String register(Model model,@Valid AccountDto accountDto){
        System.out.println(accountDto);
        if (userService.register(accountDto)){
            return "login";
        }
        model.addAttribute("exist", true);
        return "signup";
    }
}
