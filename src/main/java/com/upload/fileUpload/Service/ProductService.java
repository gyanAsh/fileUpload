package com.upload.fileUpload.Service;

import com.upload.fileUpload.Entity.Product;
import com.upload.fileUpload.ProductDetails;
import com.upload.fileUpload.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductDetails addNewProduct(String name, Double price, MultipartFile file) throws IOException {
            Product newProduct = new Product(name,price,file.getBytes(),file.getOriginalFilename(),file.getContentType());
            String url = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/image/")
                    .path(newProduct.getImageName())
                    .toUriString();
            newProduct.setImageUrl(url);
            Product savedProduct = productRepository.save(newProduct);
            return new ProductDetails(savedProduct.getId(),savedProduct.getProductName(),savedProduct.getProductPrice(),savedProduct.getImageUrl());

    }


}
