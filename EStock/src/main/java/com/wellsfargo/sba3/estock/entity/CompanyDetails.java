package com.wellsfargo.sba3.estock.entity;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CompanyDetails")
public class CompanyDetails implements Serializable {

	private static final long serialVersionUID = 531050392622113165L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "companyCode")
	private Long companyCode;
	
	@Column
	private String stockExchange;
	@Column
	private String companyName;
	@Column
	private String companyCEO;
	@Column
	private Double turnover;
	@Column
	private String boardOfDirectors;
	@Column
	private String companyProfile;
		
	//---------------------------------------------------------------------------------------------------------------------------------
	public CompanyDetails() {
		super();
	}
	public CompanyDetails(Long companyCode, String stockExchange, String companyName, String companyCEO, Double turnover, String boardOfDirectors, String companyProfile) {
		super();
		this.companyCode = companyCode;
		this.stockExchange = stockExchange;
		this.companyName = companyName;
		this.companyCEO = companyCEO;
		this.turnover = turnover;
		this.boardOfDirectors = boardOfDirectors;
		this.companyProfile = companyProfile;
	}

	//---------------------------------------------------------------------------------------------------------------------------------
	public Long getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(Long companyCode) {
		this.companyCode = companyCode;
	}
	//---------------------------------------------------------------------------------------------------------------------------------
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
	//---------------------------------------------------------------------------------------------------------------------------------
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	//---------------------------------------------------------------------------------------------------------------------------------
	public String getCompanyCEO() {
		return companyCEO;
	}
	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}
	//---------------------------------------------------------------------------------------------------------------------------------
	public Double getTurnover() {
		return turnover;
	}
	public void setTurnover(Double turnover) {
		this.turnover = turnover;
	}
	//---------------------------------------------------------------------------------------------------------------------------------
	public String getBoardOfDirectors() {
		return "";
	}
	public void setBoardOfDirectors(String boardOfDirectors) {
		this.boardOfDirectors = "";
	}
	//---------------------------------------------------------------------------------------------------------------------------------
	public String getCompanyProfile() {
		return companyProfile;
	}
	public void setCompanyProfile(String companyProfile) {
		this.companyProfile = companyProfile;
	}
	//---------------------------------------------------------------------------------------------------------------------------------
	public Set<StockPriceDetails> getStockPriceDetails() {
		return StockPriceDetails;
	}
	public void setStockPriceDetails(Set<StockPriceDetails> stockPriceDetails) {
		StockPriceDetails = stockPriceDetails;
	}
	//---------------------------------------------------------------------------------------------------------------------------------
	@OneToMany(cascade={CascadeType.MERGE})
	@JoinColumn(name="companyCode")
	private Set<StockPriceDetails> StockPriceDetails;
}