package io.github.zemise.labweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author <a href= "https://github.com/zemise">Zemise</a>
 * @Date 2023/11/9
 * @since 1.0
 */

@Controller
@Slf4j
public class IndexController {
    @GetMapping("/index")
    public String showIndexPage(Model model) {
        model.addAttribute("title", "首页");
        model.addAttribute("name", "Hello Thymeleaf from controller");

        return "index";
    }

}
