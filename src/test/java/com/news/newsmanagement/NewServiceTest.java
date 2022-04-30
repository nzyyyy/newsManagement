package com.news.newsmanagement;


import com.news.newsmanagement.controller.dto.NewDto;
import com.news.newsmanagement.entity.NewInfo;
import com.news.newsmanagement.service.impl.NewInfoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NewServiceTest {

    @Autowired
    NewInfoServiceImpl newInfoService;
    @Test
    public void getList(){
        for (NewInfo newInfo : newInfoService.getListByPage(1)) {
            System.out.println(newInfo);
        }
    }
    @Test
    public void getOne(){
        System.out.println(newInfoService.getOneById(1));
    }
    @Test
    public void getPageCount(){
        System.out.println(newInfoService.getPageCount());
    }
    @Test
    public void addNew(){
        NewDto newInfo = new NewDto();
        newInfo.setTitle("测试标题");
        newInfo.setDescription("测试描述");
        newInfo.setContent("测试内容");
        System.out.println(newInfoService.addNew(newInfo));
    }
    @Test
    public void deleteNew(){
        System.out.println(newInfoService.deleteNew(4));
    }
    @Test
    public void modifyNew(){
        System.out.println(newInfoService.modifyNew(new NewDto(1,"修改标题","修改描述","修改内容")));
    }
    @Test
    public void publishNew(){
        System.out.println(newInfoService.publishNew(1));
    }
}
