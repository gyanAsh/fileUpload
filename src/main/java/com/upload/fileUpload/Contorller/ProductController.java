package com.upload.fileUpload.Contorller;

import com.upload.fileUpload.Entity.Product;
import com.upload.fileUpload.ProductDetails;
import com.upload.fileUpload.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(path="/api/v1")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(path="/products")
    public List<ProductDetails> getListOfProducts(){
        List<Product> products = productService.getAllProducts();
        List<ProductDetails> productDetailsList = new LinkedList<>();
        products.forEach(product -> productDetailsList.add( new ProductDetails(product.getId(),product.getProductName(),product.getProductPrice(),product.getImageUrl())));
        return productDetailsList;
    }

    @PostMapping(path = "/register/new_product")
    private ProductDetails addNewProduct(@RequestParam("productName") String name,
                               @RequestParam("productPrice") Double price,
                               @RequestParam("file")MultipartFile file) throws IOException {
        return productService.addNewProduct(name,price,file);
    }



}
