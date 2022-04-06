package com.upload.fileUpload;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ProductDetails {
    private Long id;
    private String name;
    private Double price;
    private String url;

    public ProductDetails(Long id, String name, Double price, String url) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.url = url;
    }
}
