package com.ricardocreates.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (schema = "COMPANY", name = "BRAND")
public class Brand {
	@Id
	@Column(name="ID")
	private Long id;
	@Column(name="NAME")
	private String name;
}