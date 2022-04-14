package com.upload.fileUpload.Contorller;

import com.upload.fileUpload.Entity.Product;
import com.upload.fileUpload.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/image/")
public class ImageController {

    @Autowired
    private ProductService productService;


    @GetMapping(path="{productId}/{imageName}")
    public ResponseEntity getProductImage(@PathVariable("productId") Long id,
                                          @PathVariable("imageName")String imageName) throws Exception {
        Product product = productService.getProduct(id,imageName);
        return ResponseEntity.status(200)
                .contentType(MediaType.parseMediaType(product.getImageType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" +product.getImageName() + "\"")
                .body(product.getImage());
    }

}
