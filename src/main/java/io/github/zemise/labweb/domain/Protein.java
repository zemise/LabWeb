package io.github.zemise.labweb.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author <a href= "https://github.com/zemise">Zemise</a>
 * @Date 2023/11/9
 * @since 1.0
 */
@Entity
@Data
public class Protein {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "mw")
    private String moleculeWeight;

    private String webUrl;

    /**
     * 实体创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    protected Date dateCreated = new Date();

    /**
     * 实体修改时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    protected Date dateModified = new Date();

    /**
     * 乐观锁
     */
    private @Version Long version;

    public Protein(String name, String moleculeWeight, String webUrl) {
        this.name = name;
        this.moleculeWeight = moleculeWeight;
        this.webUrl = webUrl;
    }

    public Protein() {
    }
}
