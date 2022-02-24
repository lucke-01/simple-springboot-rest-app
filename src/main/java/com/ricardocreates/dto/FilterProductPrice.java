package com.ricardocreates.dto;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class FilterProductPrice {
    private LocalDateTime date;
    private Long productId;
    private Long brandId;
}