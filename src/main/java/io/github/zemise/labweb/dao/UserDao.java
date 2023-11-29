package io.github.zemise.labweb.dao;

import io.github.zemise.labweb.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * <p>
 *
 * </p>
 *
 * @author <a href= "https://github.com/zemise">Zemise</a>
 * @Date 2023/11/29
 * @since 1.0
 */
public interface UserDao extends CrudRepository<User, Integer> {
    User findUserByUsername(String username);
}
