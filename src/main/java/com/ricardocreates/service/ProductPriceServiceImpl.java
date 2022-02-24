package com.ricardocreates.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ricardocreates.dto.FilterProductPrice;
import com.ricardocreates.entities.Price;
import com.ricardocreates.model.ProductPrice;
import com.ricardocreates.repository.PriceRepository;
import com.ricardocreates.service.mapper.ProductServiceMapper;

@Service
//readOnly by default in order improve only read operations
@Transactional(readOnly = true)
public class ProductPriceServiceImpl implements ProductPriceService {
    @Autowired
    private PriceRepository priceRepository;
    
    @Autowired
    private ProductServiceMapper productServiceMapper;
        
    @Cacheable(cacheNames="productPriceCache", key="#filterProductPrice")
    @Override
    public ProductPrice findByFilterProductPrice(FilterProductPrice filterProductPrice) {
        Price price = this.priceRepository.findFirstByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdEqualsAndBrandIdEqualsOrderByPriorityDesc
                (filterProductPrice.getDate(),filterProductPrice.getDate(), filterProductPrice.getProductId(),filterProductPrice.getBrandId());        
        
        return productServiceMapper.priceToProductPrice(price);
    }
}