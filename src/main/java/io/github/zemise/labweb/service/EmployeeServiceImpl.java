package io.github.zemise.labweb.service;

import io.github.zemise.labweb.dao.EmployeeDao;
import io.github.zemise.labweb.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> lists() {
        List<Employee> employeeList = new ArrayList<Employee>();
        Iterable<Employee> all = employeeDao.findAll();
        all.forEach(employeeList::add);

        return employeeList;
    }
}
