package org.spring.boot.examples.web.rest.swagger.api.entity;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductEntity {

    @ApiModelProperty(notes = "The application-specific product ID", position = 0)
    private String productId;

    @ApiModelProperty(notes = "The product description", position = 1)
    private String description;

    @ApiModelProperty(notes = "The price of the product", required = true, position = 2)
    private BigDecimal price;

    public String getProductId() {
        return productId;
    }

    public ProductEntity setProductId(String productId) {
        this.productId = productId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "productId='" + productId + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return productId.equals(that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}
