package com.webcuoiky.softwareshop.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

//import jakarta.validation.constraints.NotEmpty;
//CRUD
public class SoftwareDTO {
    @NotEmpty(message = "The name is required")
    private String name;

    @NotEmpty(message = "The dec description required")
    private String description;

    //@NotEmpty(message = "The dec price required")
    @NotNull(message = "The dec price required") //float nên là notnull thay vì notempty
    private Float price;


    private Float sale_price;

    //@NotEmpty(message = "The dec quantity required")
    //@NotNull(message = "The dec price required")
    private Integer quantity;

    @NotEmpty(message = "The dec category required")
    private String category;

    //@NotEmpty(message = "The dec image required")
    private String image;

    public @NotEmpty(message = "Tên không được bỏ trống") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "Tên không được bỏ trống") String name) {
        this.name = name;
    }

    public @NotEmpty(message = "Mô tả sản phẩm không được bỏ trống") String getDescription() {
        return description;
    }

    public void setDescription(@NotEmpty(message = "The dec description required") String description) {
        this.description = description;
    }

    public @NotNull(message = "The dec price required") Float getPrice() {
        return price;
    }

    public void setPrice(@NotNull(message = "The dec price required") Float price) {
        this.price = price;
    }

    public Float getSale_price() {
        return sale_price;
    }

    public void setSale_price(Float sale_price) {
        this.sale_price = sale_price;
    }

//    public @NotEmpty(message = "The dec quantity required") Integer getQuantity() {
//        return quantity;
//    }

//    public void setQuantity(@NotEmpty(message = "The dec quantity required") Integer quantity) {
//        this.quantity = quantity;
//    }

    public @NotEmpty(message = "The dec category required") String getCategory() {
        return category;
    }

    public void setCategory(@NotEmpty(message = "The dec category required") String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}