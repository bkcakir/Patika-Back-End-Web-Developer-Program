package Week_10.Service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {
    Optional<T> findById(Long id);
    List<T> findAll();
    T save(T entity);
    T update(T entity);
    boolean delete(Long id);
}
