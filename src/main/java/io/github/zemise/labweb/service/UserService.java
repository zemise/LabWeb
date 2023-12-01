package io.github.zemise.labweb.service;

import io.github.zemise.labweb.entity.User;

/**
 * <p>
 *
 * </p>
 *
 * @author <a href= "https://github.com/zemise">Zemise</a>
 * @Date 2023/11/29
 * @since 1.0
 */
public interface UserService {
    // 注册用户
    void register(User user);

    // 用户登录
    User login(String username, String password);
}
