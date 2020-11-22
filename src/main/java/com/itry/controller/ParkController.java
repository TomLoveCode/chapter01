package com.itry.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itry.daomain.Park;
import com.itry.daomain.User;
import com.itry.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ParkController {

    @Autowired
    ParkService parkService;

    @GetMapping("/stopMsg")
    public String toStop(@RequestParam(defaultValue = "1") int pageNum,
                         @RequestParam(defaultValue = "8") int pageSize,
                         Model model) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo pageInfo=new PageInfo(parkService.findAll());
        model.addAttribute("parkInfo",pageInfo);
        return "stop";
    }

    //跳转到停车点添加页面。
    @GetMapping("/park_crud")
    public String toAdd()
    {
        System.out.println("到停车点添加");
        return "user/park";
    }


    @PostMapping("/park_curd")
    public String addUser(Park park) {
        //将用户添加到数据库
        parkService.addParking(park);
        //重定向到用户展示页面
        return "redirect:/stopMsg";
    }

    //对要修改停车点信息的信息进行查询在页面中回显
    @GetMapping("/park_curd/{position}")
    public String toUpdatePage(@PathVariable("position") String position, Model model) {
        Park byId1 = parkService.findById(position);
        System.out.println("改变的用户" + byId1);
        model.addAttribute("park", byId1);
        return "user/park";
    }

    @DeleteMapping("/park_curd/{position}")
    public String deleteUser(@PathVariable("position") String position) {
        parkService.deleteById(position);
        System.out.println("删除成功");
        return "redirect:/stopMsg";
    }

    //对用户信息进行修改后跳转到展示页面
    @PutMapping("/park_curd")
    public String updateUser(Park park) {
        //看一下输出
        System.out.println(park);
        parkService.updateAddress(park);
        return "redirect:/stopMsg";
    }


}
