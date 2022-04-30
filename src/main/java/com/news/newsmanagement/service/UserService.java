package com.news.newsmanagement.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.news.newsmanagement.controller.dto.AccountDto;
import com.news.newsmanagement.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 宁致远
 * @since 2022-04-28
 */
public interface UserService extends IService<User>, UserDetailsService {
    boolean register(AccountDto accountDto);


}
