package com.ricardocreates.service;

import com.ricardocreates.dto.FilterProductPrice;
import com.ricardocreates.model.ProductPrice;

/**
 * I have decided in the service layer to provide Interface/implementation,
 * It is a open debate to use only impl or both Interface/implementation
 * However this way Spring can use java native dynamic proxies (internally) instead of using clib or similar 3th party libraries (internally)
 * @author ricardo
 *
 */
public interface ProductPriceService {
    
    ProductPrice findByFilterProductPrice(FilterProductPrice filterProductPrice);
}
