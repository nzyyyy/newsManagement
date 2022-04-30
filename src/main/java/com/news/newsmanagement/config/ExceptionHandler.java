package com.news.newsmanagement.config;

import com.news.newsmanagement.exception.SystemException;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class ExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        SystemException systemException;
        if (e instanceof SystemException){
            systemException = (SystemException) e;
        }else {
            systemException = new SystemException("系统正在维护");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", systemException.getMessage());
        modelAndView.setViewName("error");
        return null;
    }
}
