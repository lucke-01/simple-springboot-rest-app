package com.ricardocreates.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.ricardocreates.entities.enums.Currency;

import lombok.Data;

@Data
@Entity
@Table (schema = "COMPANY", name = "PRICE")
public class Price {
	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="START_DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime startDate;
	
	@Column(name="END_DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime endDate;
	
	@Column(name="PRICE_LIST")
	private Long priceList;
	
	@Column(name="PRIORITY")
	private Long priority;
	
	//it is better not having property with the same name of the class
	@Column(name="PRODUCT_PRICE")
	private BigDecimal productPrice;
	
	@Column(name="CURR")
	@Enumerated(EnumType.STRING)
	private Currency curr;
	
	//better all LAZY
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="BRAND_ID")
	private Brand brand;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PRODUCT_ID")
	private Product product;
}