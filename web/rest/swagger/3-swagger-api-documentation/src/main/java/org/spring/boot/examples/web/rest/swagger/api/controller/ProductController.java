package org.spring.boot.examples.web.rest.swagger.api.controller;

import io.swagger.annotations.Api;
import org.spring.boot.examples.web.rest.swagger.api.entity.ProductEntity;
import org.spring.boot.examples.web.rest.swagger.api.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/store/api/v1")
@Api(value = "onlinestore", description = "Operations pertaining to products in Online Store")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductEntity>> findBAll() {

        return new ResponseEntity<List<ProductEntity>>(productService.findAll(), HttpStatus.OK);
    }
}
