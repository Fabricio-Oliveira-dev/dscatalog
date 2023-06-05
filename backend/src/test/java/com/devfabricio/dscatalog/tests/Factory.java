package com.devfabricio.dscatalog.tests;

import com.devfabricio.dscatalog.dtos.ProductDTO;
import com.devfabricio.dscatalog.entities.Category;
import com.devfabricio.dscatalog.entities.Product;

import java.time.Instant;

public class Factory {

    public static Product createProduct() {
        Product product = new Product(1L, "Phone", Instant.parse("2020-10-20T03:00:00Z"), "Good phone", 800.0 , "https://img.com/img.png");
        product.getCategories().add(createCategory());
        return product;
    }

    public static ProductDTO createProductDTO() {
        Product product = createProduct();
        return new ProductDTO(product, product.getCategories());
    }

    public static Category createCategory() {
        return new Category(1L, "Electronics");
    }
}
