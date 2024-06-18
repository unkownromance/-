package com.ctgu.usedcar.config;

import com.ctgu.usedcar.config.intercepors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;


//    /**
//     * 视图跳转控制器
//     * 无业务逻辑的跳转 均可以以这种方法写在这里
//     *
//     * @param registry
//     */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //告知系统static 当成 静态资源访问
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns("/**") 表示拦截所有的请求，
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/index", "/login", "/", "/static/**");
    }
}