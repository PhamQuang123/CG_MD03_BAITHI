package cg.quan_ly_san_pham_md03.service;

import cg.quan_ly_san_pham_md03.model.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public interface ProductService {
   void findAll(HttpServletRequest request, HttpServletResponse response) throws SQLException;
 void renderFormAddNew(HttpServletRequest request, HttpServletResponse response);
   void save(HttpServletRequest request, HttpServletResponse response);
    void delete(HttpServletRequest request, HttpServletResponse response);
    void initUpdate(HttpServletRequest request, HttpServletResponse response);
    void update(HttpServletRequest request, HttpServletResponse response);
}
