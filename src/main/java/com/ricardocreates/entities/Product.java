package com.ricardocreates.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (schema = "COMPANY", name = "PRODUCT")
public class Product {
	@Id
	@Column(name="ID")
	private Long id;
	@Column(name="NAME")
	private String name;
	
}
