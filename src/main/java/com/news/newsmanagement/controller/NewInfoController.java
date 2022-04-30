package com.news.newsmanagement.controller;


import com.news.newsmanagement.controller.dto.NewDto;
import com.news.newsmanagement.entity.NewInfo;
import com.news.newsmanagement.exception.SystemException;
import com.news.newsmanagement.service.impl.NewInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 宁致远
 * @since 2022-04-28
 */
@Controller
@RequestMapping("/new")
public class NewInfoController {

    @Autowired
    NewInfoServiceImpl newInfoService;


    @GetMapping("/getById/{id}")
    public String showNew(Model model, @PathVariable int id) throws SystemException {
        NewInfo item = newInfoService.getOneById(id);
        if (item==null){
            throw new SystemException("获取失败,请重试或服务器正在维护");
        }
        System.out.println(item);
        model.addAttribute("item", item);
        return "news";
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/delete/{id}")
    public String deleteNew(Model model, @PathVariable int id) throws SystemException {
        if (!newInfoService.deleteNew(id)) {
            throw new SystemException("删除失败,请重试或服务器正在维护");
        }
        model.addAttribute("list", newInfoService.getListByPage(1));
        model.addAttribute("pageNum", 1);
        model.addAttribute("page", newInfoService.getPageCount());
        return "management";
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/management")
    public String showManagement(Model model, @RequestParam(value = "page", required = false) Integer page) {
        if (page == null) {
            model.addAttribute("list", newInfoService.getListByPage(1));
            model.addAttribute("pageNum", 1);
        } else {
            model.addAttribute("list", newInfoService.getListByPage(page));
            model.addAttribute("pageNum", page);
        }
        model.addAttribute("page", newInfoService.getPageCount());
        return "management";
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/showApproval")
    public String showApproval(Model model,@RequestParam(value = "page", required = false) Integer page){
        if (page == null) {
            model.addAttribute("list", newInfoService.getUnpublishedList(1));
            model.addAttribute("pageNum", 1);
        } else {
            model.addAttribute("list", newInfoService.getListByPage(page));
            model.addAttribute("pageNum", page);
        }
        model.addAttribute("page", newInfoService.getUnpublishedCount());
        return "approval";
    }
    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/approval/{id}")
    public String approvalNew(Model model, @PathVariable int id) throws SystemException {
        if (!newInfoService.publishNew(id)) {
            throw new SystemException("审批失败,请重试或服务器正在维护");
        }
        model.addAttribute("list", newInfoService.getUnpublishedList(1));
        model.addAttribute("pageNum", 1);
        model.addAttribute("page", newInfoService.getUnpublishedCount());
        return "approval";
    }


    @GetMapping("/showCreate")
    public String showCreate(Model model) {
        return "create";
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/showModify/{id}")
    public String showModify(Model model, @PathVariable Integer id) {
        NewInfo info = newInfoService.getOneById(id);
        System.out.println(info);
        model.addAttribute("item", info);
        return "modify";
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/create")
    public String create(Model model, @Valid NewDto newDto) throws SystemException {
        if (!newInfoService.addNew(newDto)) {
            throw new SystemException("创建失败,请重试或服务器正在维护");
        }
        model.addAttribute("list", newInfoService.getListByPage(1));
        model.addAttribute("pageNum", 1);
        model.addAttribute("page", newInfoService.getPageCount());
        return "management";
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/modify")
    public String modify(Model model, @Valid NewDto newDto) throws SystemException {

        if (!newInfoService.modifyNew(newDto)) {
            throw new SystemException("修改失败,请重试或服务器正在维护");
        }
        model.addAttribute("list", newInfoService.getListByPage(1));
        model.addAttribute("pageNum", 1);
        model.addAttribute("page", newInfoService.getPageCount());
        return "management";
    }
}
