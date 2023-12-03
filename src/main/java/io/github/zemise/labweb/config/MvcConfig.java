package io.github.zemise.labweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>
 *
 * </p>
 *
 * @author <a href= "https://github.com/zemise">Zemise</a>
 * @Date 2023/11/28
 * @since 1.0
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    // 通过这里面的配置，不需要为每一个访问thymeleaf模版页面单独开发一个controller请求
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // viewController 请求的路径； viewName 跳转的视图
        registry.addViewController("login").setViewName("login");
        registry.addViewController("register").setViewName("regist");
        registry.addViewController("addEmp").setViewName("addEmp");
    }
}
