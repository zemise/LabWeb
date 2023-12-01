package io.github.zemise.labweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *
 * </p>
 *
 * @author <a href= "https://github.com/zemise">Zemise</a>
 * @Date 2023/12/1
 * @since 1.0
 */
@Controller
@RequestMapping("employee")
@Slf4j
public class EmployeeController {

    @RequestMapping("lists")
    public String lists() {
        log.debug("查询所有员工信息");

        return "emplist";
    }
}
