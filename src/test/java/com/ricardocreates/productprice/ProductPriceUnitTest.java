package com.ricardocreates.productprice;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockReset;
import org.springframework.boot.test.mock.mockito.SpyBean;

import com.ricardocreates.SpringCrudCommerceApplication;
import com.ricardocreates.dto.FilterProductPrice;
import com.ricardocreates.model.ProductPrice;
import com.ricardocreates.service.ProductPriceService;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = SpringCrudCommerceApplication.class)
@ExtendWith(SpringExtension.class)
class ProductPriceUnitTest {
    @SpyBean(reset = MockReset.BEFORE)
    private ProductPriceService productPriceService;
    
    @Test
    @Order(1)
    void testPrices() {
        final Long mainBrand = 1L;
        final Long mainProduct = 35455L;
        
        ProductPrice price1 = productPriceService.findByFilterProductPrice(new FilterProductPrice(LocalDateTime.of(2020, 6, 14, 10, 0, 0),mainProduct, mainBrand));
        
        ProductPrice price2 = productPriceService.findByFilterProductPrice(new FilterProductPrice(LocalDateTime.of(2020, 6, 14, 16, 0, 0), mainProduct, mainBrand));
        
        ProductPrice price3 = productPriceService.findByFilterProductPrice(new FilterProductPrice(LocalDateTime.of(2020, 6, 14, 21, 0, 0), mainProduct, mainBrand));
        
        ProductPrice price4 = productPriceService.findByFilterProductPrice(new FilterProductPrice(LocalDateTime.of(2020, 6, 15, 10, 0, 0), mainProduct, mainBrand));
        
        ProductPrice price5 = productPriceService.findByFilterProductPrice(new FilterProductPrice(LocalDateTime.of(2020, 6, 16, 21, 0, 0), mainProduct, mainBrand));
        
        ProductPrice priceNull = productPriceService.findByFilterProductPrice(new FilterProductPrice(LocalDateTime.of(2016, 6, 16, 21, 0, 0), mainProduct, mainBrand));
        
        assertNull(priceNull, "this product should not exist");
        assertEquals(1, price1.getPriceId());
        assertEquals(2, price2.getPriceId());
        assertEquals(1, price3.getPriceId());
        assertEquals(3, price4.getPriceId());
        assertEquals(4, price5.getPriceId());

    }
    @Test
    @Order(2)
    void testEhcacheProductPrice() {
        productPriceService.findByFilterProductPrice(new FilterProductPrice(LocalDateTime.of(2021, 6, 15, 10, 0, 0), 35455L, 1L));
        
        productPriceService.findByFilterProductPrice(new FilterProductPrice(LocalDateTime.of(2021, 6, 16, 21, 0, 0), 35455L, 1L));
        //we call with the same parameter in order to check if cache is working (counting how many times has called findByFilterProductPrice for example)
        productPriceService.findByFilterProductPrice(new FilterProductPrice(LocalDateTime.of(2021, 6, 16, 21, 0, 0), 35455L, 1L));
        
        //we could think "findByFilterProductPrice" would have been called 3 times 
        //however using ehcache in the 3th findByFilterProductPrice this method was not called, instead stored cache data were used.
        verify(productPriceService, times(2)).findByFilterProductPrice(Mockito.any());
    }
}
