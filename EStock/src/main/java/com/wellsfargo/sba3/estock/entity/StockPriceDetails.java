package com.wellsfargo.sba3.estock.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="StockPriceDetails")
public class StockPriceDetails implements Serializable {

	private static final long serialVersionUID = 3721936374836041464L;

	@GeneratedValue(strategy=GenerationType.AUTO)
	@javax.persistence.Id
	@Column
	private Long Id;
	
	@Column
	private Long companyCode;

	@Column(precision=10, scale=2)
	private Double currentStockPrice;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column
	private Date stockPriceDate;
	
	@Column(columnDefinition = "TIME")
	private Time stockPriceTime;

	//---------------------------------------------------------------------------------------------------------------------------------
	public StockPriceDetails() {
		super();
	}	
	public StockPriceDetails(Long id, Long companyCode, Double currentStockPrice, Date stockPriceDate,	Time stockPriceTime) {
		super();
		this.Id = id;
		this.companyCode = companyCode;
		this.currentStockPrice = currentStockPrice;
		this.stockPriceDate = stockPriceDate;
		this.stockPriceTime = stockPriceTime;
	}

	//---------------------------------------------------------------------------------------------------------------------------------
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	//---------------------------------------------------------------------------------------------------------------------------------
	public Long getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(Long companyCode) {
		this.companyCode = companyCode;
	}
	//---------------------------------------------------------------------------------------------------------------------------------
	public Double getCurrentStockPrice() {
		return currentStockPrice;
	}
	public void setCurrentStockPrice(Double currentStockPrice) {
		this.currentStockPrice = currentStockPrice;
	}
	//---------------------------------------------------------------------------------------------------------------------------------
	public Date getStockPriceDate() {
		return stockPriceDate;
	}
	public void setStockPriceDate(Date stockPriceDate) {
		this.stockPriceDate = stockPriceDate;
	}
	//---------------------------------------------------------------------------------------------------------------------------------
	public Time getStockPriceTime() {
		return stockPriceTime;
	}
	public void setStockPriceTime(Time stockPriceTime) {
		this.stockPriceTime = stockPriceTime;
	}
}