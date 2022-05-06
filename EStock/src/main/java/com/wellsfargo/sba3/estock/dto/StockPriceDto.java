package com.wellsfargo.sba3.estock.dto;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import javax.validation.constraints.PastOrPresent;
import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.annotations.Columns;

public class StockPriceDto {
	@NotNull
    private Long Id;

    private Long companyCode;

    @NotNull
    @Column(precision = 10, scale = 2)
    private Double currentStockPrice;
    
	@NotNull
	@Size(min = 3, max = 100)
	private String stockExchange;

    @NotNull
    @Temporal(TemporalType.DATE)
    @PastOrPresent
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date stockPriceDate;

    @NotNull
    @Temporal(TemporalType.TIME)
    @PastOrPresent
    private Time stockPriceTime;

    // ---------------------------------------------------------------------------------------------------------------------------------
    public StockPriceDto() {
        super();
    }

    public StockPriceDto(Long id, @NotNull @Size(min = 1, max = 10) Long companyCode,
            @NotNull Double currentStockPrice, @NotNull Date stockPriceDate, @NotNull Time stockPriceTime) {
        super();
        Id = id;
        this.companyCode = companyCode;
        this.currentStockPrice = currentStockPrice;
        this.stockPriceDate = stockPriceDate;
        this.stockPriceTime = stockPriceTime;
    }

    // ---------------------------------------------------------------------------------------------------------------------------------
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    // ---------------------------------------------------------------------------------------------------------------------------------
    public Long getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(Long companyCode) {
        this.companyCode = companyCode;
    }

    // ---------------------------------------------------------------------------------------------------------------------------------
    public Double getCurrentStockPrice() {
        return currentStockPrice;
    }

    public void setCurrentStockPrice(Double currentStockPrice) {
        this.currentStockPrice = currentStockPrice;
    }

    // ---------------------------------------------------------------------------------------------------------------------------------
    public Date getStockPriceDate() {
        return stockPriceDate;
    }

    public void setStockPriceDate(Date stockPriceDate) {
        this.stockPriceDate = stockPriceDate;
    }

    // ---------------------------------------------------------------------------------------------------------------------------------
    public Time getStockPriceTime() {
        return stockPriceTime;
    }

    public void setStockPriceTime(Time stockPriceTime) {
        this.stockPriceTime = stockPriceTime;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Id == null) ? 0 : Id.hashCode());
        result = prime * result + ((companyCode == null) ? 0 : companyCode.hashCode());
        result = prime * result + ((currentStockPrice == null) ? 0 : currentStockPrice.hashCode());
        result = prime * result + ((stockPriceDate == null) ? 0 : stockPriceDate.hashCode());
        result = prime * result + ((stockPriceTime == null) ? 0 : stockPriceTime.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StockPriceDto other = (StockPriceDto) obj;
        if (Id == null) {
            if (other.Id != null)
                return false;
        } else if (!Id.equals(other.Id))
            return false;
        if (companyCode == null) {
            if (other.companyCode != null)
                return false;
        } else if (!companyCode.equals(other.companyCode))
            return false;
        if (currentStockPrice == null) {
            if (other.currentStockPrice != null)
                return false;
        } else if (!currentStockPrice.equals(other.currentStockPrice))
            return false;
        if (stockPriceDate == null) {
            if (other.stockPriceDate != null)
                return false;
        } else if (!stockPriceDate.equals(other.stockPriceDate))
            return false;
        if (stockPriceTime == null) {
            if (other.stockPriceTime != null)
                return false;
        } else if (!stockPriceTime.equals(other.stockPriceTime))
            return false;
        return true;
    }

}
