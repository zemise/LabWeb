package io.github.zemise.labweb.service;

import io.github.zemise.labweb.entity.Employee;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author <a href= "https://github.com/zemise">Zemise</a>
 * @Date 2023/12/2
 * @since 1.0
 */
public interface EmployeeService {
    // 员工列表方法
    List<Employee> lists();
}
