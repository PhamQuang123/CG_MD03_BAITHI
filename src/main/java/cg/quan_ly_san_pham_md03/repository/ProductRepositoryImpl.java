package cg.quan_ly_san_pham_md03.repository;

import cg.quan_ly_san_pham_md03.config.ConnectionDB;
import cg.quan_ly_san_pham_md03.model.Category;
import cg.quan_ly_san_pham_md03.model.Product;
import cg.quan_ly_san_pham_md03.service.CategoryServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private Connection conn;
    private CategoryServiceImpl categoryService;

    public ProductRepositoryImpl() {
        conn = ConnectionDB.openConnection();
        categoryService = new CategoryServiceImpl();
    }

    @Override
    public List<Product> findAll() {
        String sql = "select * from product";
        List<Product> listProduct = null;
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            listProduct = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setColor(rs.getString("color"));
                product.setDescriptions(rs.getString("descriptions"));
                int categoryId = rs.getInt("category_id");
                Category category = categoryService.findCategoryById(categoryId);
                product.setCategory(category);
                listProduct.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listProduct;
    }

    @Override
    public boolean save(Product product) {
        String sql = "insert into product(product_name, price, quantity,color, descriptions, category_id)" +
                "value (?,?,?,?,?,?)";
        boolean result = false;
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, product.getProductName());
            pre.setDouble(2, product.getPrice());
            pre.setInt(3, product.getQuantity());
            pre.setString(4, product.getColor());
            pre.setString(5, product.getDescriptions());
            pre.setInt(6, product.getCategory().getCategoryId());
            pre.executeUpdate();
            result = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from product where product_id = ?";
        boolean result = false;
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            pre.executeUpdate();
            result = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean update(Product product) {
        String sql = "update product " +
                "set product_name = ?, price = ?, quantity = ?, color = ?, descriptions = ?, category_id = ? where product_id = ?";
        boolean result = false;
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, product.getProductName());
            pre.setDouble(2, product.getPrice());
            pre.setInt(3, product.getQuantity());
            pre.setString(4, product.getColor());
            pre.setString(5, product.getDescriptions());
            pre.setInt(6, product.getCategory().getCategoryId());
            pre.setInt(7, product.getProductId());
            pre.executeUpdate();
            result = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public Product findProductById(int id) {
        String sql = "select * from product where product_id = ?";
        Product product = null;
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            product = new Product();
            while (rs.next()) {
                product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setColor(rs.getString("color"));
                product.setDescriptions(rs.getString("descriptions"));
                int categoryId = rs.getInt("category_id");
                Category category = categoryService.findCategoryById(categoryId);
                product.setCategory(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return product;
    }

    @Override
    public List<Product> findByName(String productName) {
        String sql = "select * from product where product_name like '%' ? '%'";
        List<Product> listProduct = null;
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, productName);
            ResultSet rs = pre.executeQuery();
            listProduct = new ArrayList<>();
            while (rs.next()) {
              Product  product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setColor(rs.getString("color"));
                product.setDescriptions(rs.getString("descriptions"));
                int categoryId = rs.getInt("category_id");
                Category category = categoryService.findCategoryById(categoryId);
                product.setCategory(category);
                listProduct.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return listProduct;
    }
}
