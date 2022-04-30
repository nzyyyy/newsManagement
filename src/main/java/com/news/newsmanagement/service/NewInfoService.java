package com.news.newsmanagement.service;

import com.news.newsmanagement.controller.dto.NewDto;
import com.news.newsmanagement.entity.NewInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 宁致远
 * @since 2022-04-28
 */
public interface NewInfoService extends IService<NewInfo> {
    List<NewInfo> getListByPage(int page);

    List<NewInfo> getUnpublishedList(int page);
    int getUnpublishedCount();


    boolean publishNew(int id);
    NewInfo getOneById(int id);
    int getPageCount();
    boolean addNew(NewDto newDto);
    boolean modifyNew(NewDto newDto);
    boolean deleteNew(int id);
}
