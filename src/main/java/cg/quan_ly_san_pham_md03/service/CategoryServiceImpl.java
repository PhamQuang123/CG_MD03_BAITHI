package cg.quan_ly_san_pham_md03.service;

import cg.quan_ly_san_pham_md03.config.ConnectionDB;
import cg.quan_ly_san_pham_md03.model.Category;
import cg.quan_ly_san_pham_md03.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl {
    private Connection conn;

    public CategoryServiceImpl() {
        conn = ConnectionDB.openConnection();
    }


    public List<Category> findAll()  {
        String sql = "select * from category";
        List<Category> listCategory = null;
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            listCategory = new ArrayList<>();
            while (rs.next()){
              Category category = new Category();
              category.setCategoryId(rs.getInt("category_id"));
              category.setCategoryName(rs.getString("category_name"));
              listCategory.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listCategory;
    }

    public Category findCategoryById(int id){
        String sql = "select * from category where category_íd = ?";
        Category category = null;
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,id);
            ResultSet rs = pre.executeQuery();
            category = new Category();
            if (rs.next()){
                category.setCategoryId(rs.getInt("category_id"));
                category.setCategoryName(rs.getString("category_name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return category;
    }
}
