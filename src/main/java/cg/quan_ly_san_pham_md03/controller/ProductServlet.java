package cg.quan_ly_san_pham_md03.controller;

import cg.quan_ly_san_pham_md03.service.CategoryServiceImpl;
import cg.quan_ly_san_pham_md03.service.ProductService;
import cg.quan_ly_san_pham_md03.service.ProductServiceIMPl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ProductServlet", value = "/product/*")
public class ProductServlet extends HttpServlet {
    private ProductService productService;
    private CategoryServiceImpl categoryService;

    @Override
    public void init() throws ServletException {
        productService = new ProductServiceIMPl();
        categoryService = new CategoryServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String url = request.getPathInfo();
        switch (url){
            case "/listProduct":
                try {
                    productService.findAll(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/addNew":

              productService.renderFormAddNew(request,response);
                break;
            case "/delete":
                productService.delete(request,response);
                break;
            case "/initUpdate":
                productService.initUpdate(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String url = request.getPathInfo();
        switch (url){
            case "/doAddNew":
                productService.save(request,response);
                break;
            case "/doUpdate":
                productService.update(request,response);
                break;
        }
    }
}
