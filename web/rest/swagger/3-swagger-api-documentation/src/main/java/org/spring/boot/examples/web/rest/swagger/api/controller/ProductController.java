package org.spring.boot.examples.web.rest.swagger.api.controller;

import io.swagger.annotations.*;
import org.spring.boot.examples.web.rest.swagger.api.controller.dto.Products;
import org.spring.boot.examples.web.rest.swagger.api.entity.ProductEntity;
import org.spring.boot.examples.web.rest.swagger.api.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store/api/v1")
@Api(value = "onlinestore", description = "Operations pertaining to products in Online Store")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ApiOperation(value = "View a list of available products", response = Products.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    }
    )
    @GetMapping("/products")
    public ResponseEntity<Products> findBAll() {

        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }


    @ApiOperation(value = "Search a product with an ID", response = ProductEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved product"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")
    }
    )
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductEntity> findById(
            @ApiParam(value = "the product id", required = true)
            @PathVariable String id) {

        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }


    @ApiOperation(value = "Add a product", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product saved successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")
    }
    )
    @PostMapping("/products/save")
    public ResponseEntity<String> create(
            @ApiParam(value = "the product to be created", required = true)
            @RequestBody ProductEntity product) {

        productService.create(product);
        return new ResponseEntity("Product saved successfully", HttpStatus.OK);
    }


    @ApiOperation(value = "Update a product", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product updated successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "Not found product")
    }
    )
    @PutMapping("/products/update/{id}")
    public ResponseEntity<String> updateProduct(
            @ApiParam(value = "the id of the product to be updated", required = true)
            @PathVariable String id,
            @ApiParam(value = "the new product values", required = true)
            @RequestBody ProductEntity product) {

        boolean updated = productService.update(id, product);
        if (updated)
            return new ResponseEntity("Product updated successfully", HttpStatus.OK);
        else
            return new ResponseEntity("Not found product", HttpStatus.NOT_FOUND);
    }


    @ApiOperation(value = "Delete a product with its ID", response = ProductEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product deleted successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "Not found product")
    }
    )
    @DeleteMapping("/products/delete/{id}")
    public ResponseEntity<String> removeById(
            @ApiParam(value = "the id of the product to be deleted", required = true)
            @PathVariable String id) {

        boolean deleted = productService.removeOne(id);
        if (deleted)
            return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
        else
            return new ResponseEntity("Not found product", HttpStatus.NOT_FOUND);
    }


    @ApiOperation(value = "Delete all products", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Products deleted successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 500, message = "An error has occurred")
    }
    )
    @DeleteMapping("/products/delete")
    public ResponseEntity<String> removeAll() {

        productService.removeAll();
        if (productService.findAll().getSize() < 1)
            return new ResponseEntity("Products deleted successfully", HttpStatus.OK);
        else
            return new ResponseEntity("An error has occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
