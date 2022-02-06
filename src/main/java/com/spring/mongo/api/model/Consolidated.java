package com.spring.mongo.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection="db_consolidado") 

public class Consolidated {
	
	@Id
	private String sede;
	private long totalVentas;

	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public long getTotalVentas() {
		return totalVentas;
	}
	public void setTotalVentas(long totalVentas) {
		this.totalVentas = totalVentas;
	}
	
	
}
