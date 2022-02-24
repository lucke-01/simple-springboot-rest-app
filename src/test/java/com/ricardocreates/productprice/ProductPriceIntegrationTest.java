package com.ricardocreates.productprice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.ricardocreates.SpringCrudCommerceApplication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest(classes = SpringCrudCommerceApplication.class)
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class ProductPriceIntegrationTest {
    private static final String PRODUCT_PATH = "/api/product-price/";
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    void productPriceRestTest() throws Exception {
        this.mockMvc.perform(get(PRODUCT_PATH)
                .param("date", "2018-03-20T09:12:28Z")
                .param("productId", "35455")
                .param("brandId", "1")
        )
        //we should delete "MockMvcResultHandlers.print()" this but can be usefull to see what is returned
        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string(""));
        
        
        this.mockMvc.perform(get(PRODUCT_PATH)
                .param("date", "2020-06-14T10:00:00Z")
                .param("productId", "35455")
                .param("brandId", "1")
        )
        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().json("{'priceId': 1}"));
        
        this.mockMvc.perform(get(PRODUCT_PATH)
                .param("date", "2020-06-14T16:00:00Z")
                .param("productId", "35455")
                .param("brandId", "1")
        )
        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().json("{'priceId': 2}"));
        
        this.mockMvc.perform(get(PRODUCT_PATH)
                .param("date", "2020-06-14T21:00:00Z")
                .param("productId", "35455")
                .param("brandId", "1")
        )
        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().json("{'priceId': 1}"));
        
        this.mockMvc.perform(get(PRODUCT_PATH)
                .param("date", "2020-06-15T10:00:00Z")
                .param("productId", "35455")
                .param("brandId", "1")
        )
        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().json("{'priceId': 3}"));
        
        
        this.mockMvc.perform(get(PRODUCT_PATH)
                .param("date", "2020-06-16T21:00:00Z")
                .param("productId", "35455")
                .param("brandId", "1")
        )
        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().json("{'priceId': 4}"));
        
    }
}
