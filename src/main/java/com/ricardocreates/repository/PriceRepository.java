package com.ricardocreates.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ricardocreates.entities.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

}