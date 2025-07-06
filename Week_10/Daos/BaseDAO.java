/*
 * BaseDAO.java
 *
 * Bu arayüz, tüm DAO (Data Access Object) sınıfları için temel CRUD (Create, Read, Update, Delete)
 * operasyonlarını tanımlar. Her bir entity için veritabanı işlemlerinin standart bir şekilde
 * gerçekleştirilmesini sağlar.
 *
 * Metodlar:
 * - findById: ID'ye göre kayıt getirme
 * - findAll: Tüm kayıtları getirme
 * - save: Yeni kayıt ekleme
 * - update: Mevcut kaydı güncelleme
 * - delete: Kayıt silme
 *
 */

package Week_10.Daos;

import java.util.List;
import java.util.Optional;

public interface BaseDAO<T> {
    Optional<T> findById(Long id);
    List<T> findAll();
    T save(T entity);
    T update(T entity);
    void delete(Long id);
} 