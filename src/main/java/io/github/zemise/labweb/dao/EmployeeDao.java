package io.github.zemise.labweb.dao;

import io.github.zemise.labweb.entity.Employee;
import org.springframework.data.repository.CrudRepository;

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
public interface EmployeeDao extends CrudRepository<Employee, Integer> {
}
