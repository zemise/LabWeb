package io.github.zemise.labweb.domain.init;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author <a href= "https://github.com/zemise">Zemise</a>
 * @Date 2023/11/9
 * @since 1.0
 */

@Data
@EqualsAndHashCode
public class DemoProtein {
    private String name;

    @Column(name = "mw")
    private String moleculeWeight;

    private String webUrl;
}
