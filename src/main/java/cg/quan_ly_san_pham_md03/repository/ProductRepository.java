package cg.quan_ly_san_pham_md03.repository;

import cg.quan_ly_san_pham_md03.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductRepository {
    List<Product> findAll() throws SQLException;
    boolean save(Product product);
    boolean delete(int id);
    boolean update(Product product);
    Product findProductById(int id);
    List<Product> findByName(String productName);
}
