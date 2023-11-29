package io.github.zemise.labweb.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author <a href= "https://github.com/zemise">Zemise</a>
 * @Date 2023/11/29
 * @since 1.0
 */

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String realName;
    private String password;
    private Boolean gender;

    public User() {
    }

    public User(Integer id, String username, String realName, String password, boolean gender) {
        this.id = id;
        this.username = username;
        this.realName = realName;
        this.password = password;
        this.gender = gender;
    }
}
