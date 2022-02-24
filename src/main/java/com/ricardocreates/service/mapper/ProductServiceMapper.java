package com.ricardocreates.service.mapper;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.mapstruct.*;

import com.ricardocreates.entities.Price;
import com.ricardocreates.model.ProductPrice;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.WARN)
public interface ProductServiceMapper {
    
      @Named("priceToProductPrice")
      @Mapping(target="product", source="product")
      @Mapping(target="brand", source="brand")
      @Mapping(target = "startDate", source = "startDate", qualifiedByName = "localDateTimeToOffsetDateTime")
      @Mapping(target = "endDate", source = "endDate", qualifiedByName = "localDateTimeToOffsetDateTime")
      @Mapping(target="priceId", source="id")
      @Mapping(target="finalPrice", source="productPrice")
      @Mapping(target="currency", source="curr")
      ProductPrice priceToProductPrice(Price priceEntity);
      
      //in order to transform LocalDateTime to OffsetDateTime in mappers
      @Named("localDateTimeToOffsetDateTime")
      default OffsetDateTime localDateTimeToOffsetDateTime(LocalDateTime date) {
          return date.atOffset(ZoneOffset.UTC);
      }
}