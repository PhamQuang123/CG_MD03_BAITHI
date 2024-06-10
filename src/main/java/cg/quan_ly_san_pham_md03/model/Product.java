package cg.quan_ly_san_pham_md03.model;

public class Product {
    private int productId;
    private String productName;
    private double price;
    private int quantity;
    private String color;
    private String descriptions;
    private Category category;

    public Product() {
    }

    public Product(int productId, String productName, double price, int quantity, String color, String descriptions, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.descriptions = descriptions;
        this.category = category;
    }

    public Product(String productName, double price, int quantity, String color, String descriptions, Category category) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.descriptions = descriptions;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
