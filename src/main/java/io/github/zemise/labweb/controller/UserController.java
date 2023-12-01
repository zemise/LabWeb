package io.github.zemise.labweb.controller;

import io.github.zemise.labweb.entity.User;
import io.github.zemise.labweb.utils.VerifyCodeUtils;
import io.github.zemise.labweb.service.UserService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;


/**
 * <p>
 *
 * </p>
 *
 * @author <a href= "https://github.com/zemise">Zemise</a>
 * @Date 2023/11/28
 * @since 1.0
 */
@Controller
@RequestMapping("user")
@Slf4j
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户登录
     *
     * @return
     */
    @RequestMapping("login")
    public String login(String username, String password, HttpSession session) {
        log.debug("本次登录的用户名：{}", username);
        log.debug("本次登录的密码：{}", password);
        try {
            // 1. 调用业务层进行登录
            User user = userService.login(username, password);
            // 2.保存用户信息
            session.setAttribute("user", user);
        }catch (Exception e){
            e.printStackTrace();
            return "redirect:/login"; // 登录失败，回到登录页面
        }


        return "redirect:/employee/lists"; // 登录成功之后，跳转到查询所有员工信息控制器路径
    }

    /**
     * 用户注册
     *
     * @return
     */
    // 注意表单中的input的name属性名和变量名一致，才能自动赋值，比如这里的验证码的code
    @RequestMapping("register")
    public String register(User user, String code, HttpSession session) {
        log.debug("用户名:{},真实姓名:{},密码：{}, 性别：{}", user.getUsername(), user.getRealName(),
                user.getPassword(), user.getGender());
        log.debug("用户输入的验证码：{}", code);

        try {
            // 判断用户输入的验证码和session中的验证码是否一致
            String sessionCode = session.getAttribute("code").toString();
            if (!sessionCode.equalsIgnoreCase(code)) {
                throw new RuntimeException("验证码输入错误");
            }
            // 1. 完成用户注册
            userService.register(user);
        } catch (RuntimeException e) {
            e.printStackTrace();
            // 注册失败，回到注册
            return "redirect:/register";
        }
        // 注册陈工，跳转到登录
        return "redirect:/login";
    }

    /**
     * 生成验证码
     */
    @RequestMapping("generateImageCode")
    public void generateImageCode(HttpSession session, HttpServletResponse response) throws IOException {
        // 1. 生成4位随机数
        String code = VerifyCodeUtils.generateVerifyCode(4);
        // 2. 保存到session作用域
        session.setAttribute("code", code);
        // 3. 根据随机数生成图片 && 4. 通过response响应图片 && 5. 设置响应类型
        response.setContentType("image/png");
        ServletOutputStream os = response.getOutputStream();
        VerifyCodeUtils.outputImage(220, 60, os, code);
    }
}
