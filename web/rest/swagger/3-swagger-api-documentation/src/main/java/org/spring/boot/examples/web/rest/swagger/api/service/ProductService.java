package org.spring.boot.examples.web.rest.swagger.api.service;

import org.spring.boot.examples.web.rest.swagger.api.entity.ProductEntity;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    ProductEntity findById(String id);

    void create(String id, String decription, BigDecimal price);

    boolean removeOne(String id);

    void removeAll(String id);

    List<ProductEntity> findAll();
}
