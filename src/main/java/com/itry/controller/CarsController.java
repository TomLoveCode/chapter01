package com.itry.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itry.daomain.Cars;
import com.itry.daomain.Park;
import com.itry.service.CarsService;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 处理车辆服务管理业务
 */

@Controller
public class CarsController {

    @Autowired
    CarsService carsService;

    /**
     * 跳转到车辆信息页面
     *
     * @return
     */
    @GetMapping("/cars")
    public String toCarList(@RequestParam(defaultValue = "1") int pageNum,
                            @RequestParam(defaultValue = "8") int pageSize,
                            Model model) {

        PageHelper.startPage(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(carsService.findAll());
        model.addAttribute("carsInfo", pageInfo);
        PageHelper.startPage(pageNum, pageSize);
        return "carlist";

    }

    //跳转到停车点添加页面。
    @GetMapping("/cars_crud")
    public String toAdd() {
        System.out.println("到停车点添加");
        return "user/cars";
    }


    @PostMapping("/cars_curd")
    public String addUser(Cars cars) {
        //将用户添加到数据库
        carsService.addCars(cars);
        //重定向到用户展示页面
        return "redirect:/cars";
    }

    //对要修改的车辆信息的信息进行查询在页面中回显
    @GetMapping("/cars_curd/{cno}")
    public String toUpdatePage(@PathVariable("cno") String cno, Model model) {
        Cars byId = carsService.findById(cno);
        System.out.println("改变的用户" + byId);
        model.addAttribute("cars", byId);
        return "user/cars";
    }

    @DeleteMapping("/cars_curd/{cno}")
    public String deleteUser(@PathVariable("cno") String cno) {
        carsService.deleteById(cno);
        System.out.println("删除成功");
        return "redirect:/cars";
    }

    //对用户信息进行修改后跳转到展示页面
    @PutMapping("/cars_curd")
    public String updateUser(Cars cars) {
        //看一下输出
        System.out.println(cars);
        carsService.updateCar(cars);
        return "redirect:/cars";
    }


    /**
     * 跳转到租车页面
     *
     * @return
     */

    @GetMapping("/rental-car")
    public String toRentalCar() {
        return "rental-car";
    }


    /**
     * 根据车辆类型，进行模糊查询
     * @param cname
     * @param pageNum
     * @param pageSize
     * @param model
     * @param request
     * @return
     */
    @PostMapping("/find-like")
    public String toindex(String cname,
                          @RequestParam(defaultValue = "1") int pageNum,
                          @RequestParam(defaultValue = "8") int pageSize, Model model, HttpServletRequest request)
    {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(carsService.findByLike(cname));
        request.removeAttribute("carsInfo");
        model.addAttribute("carsInfo", pageInfo);
        PageHelper.startPage(pageNum, pageSize);
        return "carlist";
    }


}
