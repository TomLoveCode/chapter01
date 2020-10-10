package com.itry.config;

import com.itry.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 定义SpringMvc的配置类，为了扩展针对我们想要实现的功能做自我拓展
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送 /user 请求来到 success
        // /user,/,/index.html都会被转发到login页面
        registry.addViewController("/user").setViewName("login");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        //浏览器发送 /main.html 请求来到 dashboard页面
        registry.addViewController("/main.html").setViewName("dashboard");
        registry.addViewController("/zhu.html").setViewName("register");
    }

//注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration  registration=registry.addInterceptor(new LoginHandlerInterceptor());
        registration.addPathPatterns("/**");                      //所有路径都被拦截
        registration.excludePathPatterns("/index.html","/","/user/login","/zhu.html",
                "/**/*.css", "/**/*.js");
    }
}
