package org.spring.boot.examples.web.rest.swagger.api.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import org.spring.boot.examples.web.rest.swagger.api.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

public class Products {

    @ApiModelProperty(notes = "The list of retrieved products", position = 1)
    List<ProductEntity> products;
    @ApiModelProperty(notes = "The size of the retrieved products list", position = 0)
    private int size;

    public Products() {
        products = new ArrayList<>();
        size = 0;
    }

    public Products addProduct(ProductEntity productEntity) {

        this.products.add(productEntity);
        size++;
        return this;
    }

    public Products addProducts(List<ProductEntity> productsList) {

        this.products.addAll(productsList);
        size += productsList.size();
        return this;
    }

    public int getSize() {
        return size;
    }

    public Products setSize(int size) {
        this.size = size;
        return this;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public Products setProducts(List<ProductEntity> products) {
        this.products = products;
        return this;
    }
}
