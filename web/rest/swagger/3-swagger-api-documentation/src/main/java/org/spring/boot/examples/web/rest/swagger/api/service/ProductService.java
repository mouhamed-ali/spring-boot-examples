package org.spring.boot.examples.web.rest.swagger.api.service;

import org.spring.boot.examples.web.rest.swagger.api.controller.dto.Products;
import org.spring.boot.examples.web.rest.swagger.api.entity.ProductEntity;

public interface ProductService {

    ProductEntity findById(String id);

    void create(ProductEntity productEntity);

    boolean removeOne(String id);

    void removeAll();

    Products findAll();

    boolean update(String id, ProductEntity productEntity);
}
