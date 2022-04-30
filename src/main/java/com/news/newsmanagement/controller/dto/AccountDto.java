package com.news.newsmanagement.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountDto {

    @NotEmpty
    @Email
    public String email;
    @NotEmpty
    public String password;
}
