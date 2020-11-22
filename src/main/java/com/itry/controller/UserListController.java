package com.itry.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itry.dao.UserDao;
import com.itry.daomain.User;
import com.itry.service.UserService;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*

 注：
 这里很奇怪，刚开始我的PUT和delete请求识别不了
 之后查询后才知道，springboot
 新的springboot版本 默认不开启 restful 分割api
   需要在配置文件中开启 启用hiddenMethod过滤器 即在application.properties中设置 spring.mvc.hiddenmethod.filter.enabled=true。


 使用restful 风格对请求做判断
 |      | 普通CRUD（uri来区分操作） | RestfulCRUD              |
| ---- | ------------------------- | -----------------       |
| 查询 | getEmp                    | user_curd---GET         |
| 添加 | addEmp?xxx                | user_curd---POST        |
| 修改 | updateEmp?id=xxx&xxx=xx   | user_curd/{id}---PUT    |
| 删除 | deleteEmp?id=1            | user_curd/{id}---DELETE |

 */

@Controller
public class UserListController {

    @Autowired
    UserService userService;

    /**
     * 员工管理,实现分页。
     * pageNum 当前页
     * pageSize: 每页的记录条数
     */
    @GetMapping("/users")
    public String manageMember(@RequestParam(defaultValue = "1") int pageNum,
                               @RequestParam(defaultValue = "8") int pageSize,
                               Model model){
        PageHelper.startPage(pageNum,pageSize);
        PageInfo pageInfo=new PageInfo(userService.findAll());
        model.addAttribute("pageInfo",pageInfo);
        return "user/list";
    }

    //跳转到用户添加页面。
    @GetMapping("/user_curd")
    public String toAddPage() {
        return "user/add";
    }

    //用户的添加采用Post请求,添加完毕后返回，user/list，用户信息展示页面
    //这里SpringMVc自动封装，通过name,封装成user对象。
    @PostMapping("/user_curd")
    public String addUser(User user) {
        //将用户添加到数据库
        userService.save(user);
        //重定向到用户展示页面
        return "redirect:/users";
    }


    //   a标签的默认提交方式师 get请求
    //   获得前端传过来的id ，跳转到修改用户信息的界面,并在页面回显用户信息
    @GetMapping("/user_curd/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id, Model model) {
        User byId = userService.findById(id);
        System.out.println("改变的用户" + byId);
        model.addAttribute("user", byId);
        return "user/add";
    }


    //对用户信息进行修改后跳转到展示页面
    @PutMapping("/user_curd")
    public String updateUser(User user) {
        //看一下输出
        System.out.println(user);
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/user_curd/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        System.out.println("删除成功");
        return "redirect:/users";

    }


}
