package com.news.newsmanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.news.newsmanagement.controller.dto.NewDto;
import com.news.newsmanagement.entity.NewInfo;
import com.news.newsmanagement.mapper.NewInfoMapper;
import com.news.newsmanagement.service.NewInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 宁致远
 * @since 2022-04-28
 */
@Service
public class NewInfoServiceImpl extends ServiceImpl<NewInfoMapper, NewInfo> implements NewInfoService {


    public List<NewInfo> getListByPage(int page){
        Page<NewInfo> newInfoPage = new Page<>(page, 5);
        IPage<NewInfo> iPage = page(newInfoPage, new QueryWrapper<NewInfo>().select("newId","title","description").eq("published",1));
        return iPage.getRecords();
    }

    @Override
    public List<NewInfo> getUnpublishedList(int page) {
        Page<NewInfo> newInfoPage = new Page<>(page, 5);
        IPage<NewInfo> iPage = page(newInfoPage, new QueryWrapper<NewInfo>().select("newId","title","description").eq("published",0));
        return iPage.getRecords();
    }

    @Override
    public int getUnpublishedCount() {
        int count = count(new QueryWrapper<NewInfo>().eq("published", 0));
        return count%5==0?count/5:count/5+1;
    }

    @Override
    public boolean publishNew(int id) {
        return update(new UpdateWrapper<NewInfo>().set("published", 1).eq("newId",id));
    }

    public NewInfo getOneById(int id){
        return getById(id);
    }
    public int getPageCount(){
        int count = count(new QueryWrapper<NewInfo>().eq("published", 1));
        System.out.println(count);
        return count%5==0?count/5:count/5+1;
    }
    public boolean addNew(NewDto newDto){
        NewInfo newInfo = new NewInfo();
        newInfo.setTitle(newDto.getTitle());
        newInfo.setDescription(newDto.getDescription());
        newInfo.setContent(newDto.getContent());
        return save(newInfo);
    }

    @Override
    public boolean modifyNew(NewDto newDto) {
        NewInfo newInfo = new NewInfo();
        newInfo.setNewId(newDto.getNewId());
        newInfo.setTitle(newDto.getTitle());
        newInfo.setDescription(newDto.getDescription());
        newInfo.setContent(newDto.getContent());
        newInfo.setPublished(1);
        return updateById(newInfo);
    }

    public boolean deleteNew(int id){
        return removeById(id);
    }


}
