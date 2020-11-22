package com.itry.component;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 定义登录之前的拦截器，在config包中的WebMvcConfig中调用
 */

public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果登录成功，session中会有用户名
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser == null || loginUser == "") {
//            传回错误信息并且转发到登录页面
            request.setAttribute("msg", "没有权限请先登录");
//            response.sendRedirect(request.getContextPath() + "index.html");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        } else {
            //已经登录成功，进行放行
            return true;
        }
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //在目标方法执行之前 进行拦截，防止用户在未登录的情况下，通过输入在uri中 输入/main.html等，跳过登录页面

}
