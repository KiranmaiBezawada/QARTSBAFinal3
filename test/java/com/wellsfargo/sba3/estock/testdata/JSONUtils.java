package com.wellsfargo.sba3.estock.testdata;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wellsfargo.sba3.estock.dto.CompanyDetailsDto;
import com.wellsfargo.sba3.estock.dto.StockPriceDto;

public class JSONUtils {
	
	    public static byte[] toJson(Object object) throws IOException {
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	        return mapper.writeValueAsBytes(object);
	    }

	    public static CompanyDetailsDto createCompanyDetailaDTO(Long companyCode, String stockExchange, String companyName, String companyCEO, Double turnover, String boardOfDirectors, String companyProfile) 
	    {
	    	CompanyDetailsDto companyDetails = new CompanyDetailsDto();

	    	companyDetails.setCompanyCode(companyCode);
	    	companyDetails.setStockExchange(stockExchange);
	    	companyDetails.setCompanyName(companyName);
	    	companyDetails.setCompanyCEO(companyCEO);
	    	companyDetails.setTurnover(turnover);
	    	companyDetails.setBoardOfDirectors(boardOfDirectors);
	    	companyDetails.setCompanyProfile(companyProfile);

	    	return companyDetails;
	    }
	    
	    public static StockPriceDto createStockPriceDetailsDTO(Long id, Long companyCode, Double currentStockPrice, LocalDate stockPriceDate, LocalTime stockPriceTime) 
	    {
	    	StockPriceDto stockPrice = new StockPriceDto();

	    	stockPrice.setId(id);
	    	stockPrice.setCompanyCode(companyCode);
	    	stockPrice.setCurrentStockPrice(currentStockPrice);
	    	stockPrice.setStockPriceDate(stockPriceDate);
	    	stockPrice.setStockPriceTime(stockPriceTime);
	  	 	
	    	return stockPrice;
	    }

}
