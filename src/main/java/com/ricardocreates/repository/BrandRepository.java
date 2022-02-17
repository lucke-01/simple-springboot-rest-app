package com.ricardocreates.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ricardocreates.entities.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}