package com.ricardocreates.controller;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardocreates.api.ProductPriceApi;
import com.ricardocreates.dto.FilterProductPrice;
import com.ricardocreates.model.ProductPrice;
import com.ricardocreates.service.ProductPriceService;

@RestController
@RequestMapping("/api")
public class ProductPriceController implements ProductPriceApi 
{
    
    @Autowired
    private ProductPriceService productPriceService;
    
    @Override
    public ResponseEntity<ProductPrice> getProductPrice(OffsetDateTime date, Long productId, Integer brandId) {
        FilterProductPrice filterProductPrice = new FilterProductPrice(date.toLocalDateTime(), productId, Long.valueOf(brandId));
        
        ProductPrice productPrice = productPriceService.findByFilterProductPrice(filterProductPrice);
        
        return new ResponseEntity<>(productPrice , HttpStatus.OK);
    }
}