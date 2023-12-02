package io.github.zemise.labweb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author <a href= "https://github.com/zemise">Zemise</a>
 * @Date 2023/12/2
 * @since 1.0
 */
@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double salary;
    private Date birthday;
    private String photo;

    public Employee() {
    }

    public Employee(Integer id, String name, Double salary, Date birthday, String photo) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
        this.photo = photo;
    }
}
