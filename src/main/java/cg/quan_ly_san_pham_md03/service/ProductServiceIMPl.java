package cg.quan_ly_san_pham_md03.service;

import cg.quan_ly_san_pham_md03.config.ConnectionDB;
import cg.quan_ly_san_pham_md03.model.Category;
import cg.quan_ly_san_pham_md03.model.Product;
import cg.quan_ly_san_pham_md03.repository.ProductRepository;
import cg.quan_ly_san_pham_md03.repository.ProductRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceIMPl implements ProductService {
    private ProductRepository productRepository;
    private CategoryServiceImpl categoryService;

    public ProductServiceIMPl() {
        productRepository = new ProductRepositoryImpl();
        categoryService = new CategoryServiceImpl();
    }


    @Override
    public void findAll(HttpServletRequest request, HttpServletResponse response) {
        try {

            request.setAttribute("listProduct", productRepository.findAll());
            request.getRequestDispatcher("/views/home.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void renderFormAddNew(HttpServletRequest request, HttpServletResponse response) {
        List<Category> listCategory = categoryService.findAll();
        request.setAttribute("listCategory", listCategory);
        try {
            request.getRequestDispatcher("/views/addNew.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(HttpServletRequest request, HttpServletResponse response) {
        String productName = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String descriptions = request.getParameter("descriptions");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        Product product = new Product(productName, price, quantity, color, descriptions, categoryService.findCategoryById(categoryId));
        productRepository.save(product);
        try {
            response.sendRedirect("/product/listProduct");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        productRepository.delete(Integer.parseInt(request.getParameter("productId")));
        try {
            response.sendRedirect("/product/listProduct");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initUpdate(HttpServletRequest request, HttpServletResponse response) {
        Product product = productRepository.findProductById(Integer.parseInt(request.getParameter("productId")));
        request.setAttribute("product", product);
        List<Category> listCategory = categoryService.findAll();
        request.setAttribute("listCategory",listCategory);
        try {
            request.getRequestDispatcher("/views/update.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) {
        int productId = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String descriptions = request.getParameter("descriptions");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Category category = categoryService.findCategoryById(categoryId);
        Product product = new Product(productId, productName, price, quantity, color, descriptions, category);
        productRepository.update(product);
        try {
            response.sendRedirect("/product/listProduct");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void findByName(HttpServletRequest request, HttpServletResponse response) {
        List<Product> listProduct = productRepository.findByName(request.getParameter("productName"));
        request.setAttribute("listProduct",listProduct);
        try {
            request.getRequestDispatcher("/views/home.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
