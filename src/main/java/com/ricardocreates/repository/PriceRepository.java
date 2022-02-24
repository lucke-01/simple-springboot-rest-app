package com.ricardocreates.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ricardocreates.entities.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    //we use spring data jpa sintax in order to execute the query we want
    Price findFirstByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdEqualsAndBrandIdEqualsOrderByPriorityDesc
        (LocalDateTime date1,LocalDateTime date2, Long productId, Long brandId);
}