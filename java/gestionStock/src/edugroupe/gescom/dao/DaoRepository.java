package edugroupe.gescom.dao;

import java.sql.SQLException;
import java.util.List;

public interface DaoRepository<T> {

    T save(T t) throws SQLException;
    T update(T t) throws SQLException;
    T findById(int id) throws SQLException;
    List<T> findAll() throws SQLException;
    boolean deleteById(int id) throws SQLException;


}
