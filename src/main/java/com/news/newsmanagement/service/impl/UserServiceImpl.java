package com.news.newsmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.news.newsmanagement.controller.dto.AccountDto;
import com.news.newsmanagement.entity.User;
import com.news.newsmanagement.mapper.UserMapper;
import com.news.newsmanagement.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 宁致远
 * @since 2022-04-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    public boolean register(AccountDto accountDto){
        User user = getOne(new QueryWrapper<User>().eq("email", accountDto.getEmail()));
        if (user!=null){
            return false;
        }
        User user1 = new User();
        user1.setEmail(accountDto.email);
        user1.setPassword(passwordEncoder.encode(accountDto.password));
        return save(user1);

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = getOne(new QueryWrapper<User>().eq("email", email));
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList(user.getAuthority()));
    }
}
