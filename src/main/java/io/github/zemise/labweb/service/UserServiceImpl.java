package io.github.zemise.labweb.service;

import io.github.zemise.labweb.dao.UserDao;
import io.github.zemise.labweb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

import java.nio.charset.StandardCharsets;

/**
 * <p>
 *
 * </p>
 *
 * @author <a href= "https://github.com/zemise">Zemise</a>
 * @Date 2023/11/29
 * @since 1.0
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void register(User user) {
        // 1.根据用户查询数据库中是否存在该用户
        User userDB = userDao.findUserByUsername(user.getUsername());
        // 2.判断用户是否存在
        if(!ObjectUtils.isEmpty(userDB)){
            throw new RuntimeException("当前用户已被注册");
        }
        // 3. 注册用户 & 密码明文加密
        user.setPassword( DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)));
        userDao.save(user);
    }
}
