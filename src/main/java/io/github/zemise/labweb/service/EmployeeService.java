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

    // 保存员工信息
    void save(Employee employee);

    // 根据id查询一个
    Employee findById(Integer id);

    // 更新员工信息
    void update(Employee employee);

    // 删除员工信息
    void delete(Integer id);
}
