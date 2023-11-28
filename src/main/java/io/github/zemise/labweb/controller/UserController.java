package io.github.zemise.labweb.controller;

import io.github.zemise.labweb.utils.VerifyCodeUtils;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
public class UserController {
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
