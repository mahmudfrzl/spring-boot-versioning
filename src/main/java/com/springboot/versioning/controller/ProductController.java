package com.springboot.versioning.controller;

import com.springboot.versioning.dto.ProductDtoV1;
import com.springboot.versioning.dto.ProductDtoV2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {
    //Url versioning
    //localhost:8080/api/v1/product
    @GetMapping("/v1/product")
    public ResponseEntity<ProductDtoV1> pathVersioningV1(){
        return  ResponseEntity.of(Optional.of(new ProductDtoV1("HP 15")));
    }
    //localhost:8080/v2/product
    @GetMapping("/v2/product")
    public ResponseEntity<ProductDtoV2> pathVersioningV2(){
        return  ResponseEntity.of(Optional.of(new ProductDtoV2("HP 15", BigDecimal.TEN)));
    }
    //Param versioning
    //localhost:8080/api/param/product?apiVersion=1
    @GetMapping(value = "/param/product" , params = "apiVersion=1")
    public ResponseEntity<ProductDtoV1> paramVersioningV1(){
        return  ResponseEntity.of(Optional.of(new ProductDtoV1("HP 15")));
    }
    //localhost:8080/api/param/product?apiVersion=2
    @GetMapping(value = "/param/product", params = "apiVersion=2")
    public ResponseEntity<ProductDtoV2> paramVersioningV2(){
        return  ResponseEntity.of(Optional.of(new ProductDtoV2("HP 15", BigDecimal.TEN)));
    }
    //localhost:8080/api/header/product
    @GetMapping(value = "/header/product" , headers = "Test-Version=1")
    public ResponseEntity<ProductDtoV1> headersVersioningV1(){
        return  ResponseEntity.of(Optional.of(new ProductDtoV1("HP 15")));
    }
    //localhost:8080/api/header/product
    @GetMapping(value = "/header/product", headers = "Test-Version=2")
    public ResponseEntity<ProductDtoV2> headersVersioningV2(){
        return  ResponseEntity.of(Optional.of(new ProductDtoV2("HP 15", BigDecimal.TEN)));
    }
}
