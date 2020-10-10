package com.itry.controller;

import com.itry.daomain.User;
import com.itry.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
   private UserService userService;

    /**
     * 进行用户登录验证，
     * 1.登陆成功，防止表单重复提交，可以重定向到主页
     * 2.登录失败将map中的信息传回前端
     * @param
     * @return
     */
    @PostMapping(value ="user/login")
    public String login(User user, Map<String,Object> map, HttpSession session)
    {
        if (userService.login(user))
        {
            System.out.println("登陆成功");
            session.setAttribute("loginUser",user.getUsername());
//            回到主页面
            return "main";
         //   return  "redirect:/main.html";
        }
        else
        {
//         登录失败，将信息传到前端
            map.put("msg","用户名密码错误。请重新登录");
            return "login";
        }
    }



    @PostMapping(value = "user/register")
    public String register(User user,Map<String,Object> map)
    {
        System.out.println("怎么回事");
        if (user.getUsername()==null || userService.login(user))
        {
            System.out.println("注册失败");
            map.put("msg","请重新输入用户");
            return "register";
    }
        else
        {
            System.out.println("登录成功");
            userService.save(user);
            return "login";
        }

    }



    @RequestMapping("/findAll")
    public String findAll(Model model)
    {
        System.out.println("视图层，查询所有");
        List<User> all = userService.findAll();
        model.addAttribute("list", all);
        System.out.println(all);
        return "success";
    }
}
