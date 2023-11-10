package io.github.zemise.labweb.domain.repository;

import io.github.zemise.labweb.domain.Protein;
import org.springframework.data.repository.CrudRepository;

/**
 * <p>
 *
 * </p>
 *
 * @author <a href= "https://github.com/zemise">Zemise</a>
 * @Date 2023/11/9
 * @since 1.0
 */
public interface DaoProtein extends CrudRepository<Protein, Long> {
    Protein findByName(String name);

}
