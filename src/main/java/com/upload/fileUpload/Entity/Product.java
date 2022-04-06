package com.upload.fileUpload.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;
    private Double productPrice;
    private String imageUrl;
    @Lob
    private byte[] image;
    private String imageName;
    private String imageType;

    public Product(String productName, Double productPrice, byte[] image, String imageName, String imageType) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.image = image;
        this.imageName = imageName;
        this.imageType = imageType;
    }

}
