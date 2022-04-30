package com.news.newsmanagement;


import com.news.newsmanagement.controller.dto.AccountDto;
import com.news.newsmanagement.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;
    @Test
    public void register(){
        System.out.println(userService.register(new AccountDto("123456@163.com", "123456")));
    }

}
