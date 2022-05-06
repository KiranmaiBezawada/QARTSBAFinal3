package com.wellsfargo.sba3.estock.testdata;

import com.wellsfargo.sba3.estock.dto.CompanyDetailsDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wellsfargo.sba3.estock.dto.StockPriceDto;

public class Mockdata {
	public static CompanyDetailsDto getCompanyDto() {
		CompanyDetailsDto companyDetailsDto = new CompanyDetailsDto();
		companyDetailsDto.setBoardOfDirectors("Kiran");
		companyDetailsDto.setCompanyCEO("Mai");
		companyDetailsDto.setCompanyName("wellsfargo");
		companyDetailsDto.setCompanyProfile("Banking");
		companyDetailsDto.setStockExchange("Bsc");
		companyDetailsDto.setCompanyCode(1L);
		companyDetailsDto.setTurnover(70000000.00);
		return companyDetailsDto;
	}
	
	public static StockPriceDto getStockDto() {
		StockPriceDto stockPriceDto = new StockPriceDto();	
		stockPriceDto.setCompanyCode(1l);
		stockPriceDto.setCurrentStockPrice(8900.00);
		stockPriceDto.setId(1l);
		stockPriceDto.setStockPriceDate(java.sql.Date.valueOf("2017-11-15"));
		stockPriceDto.setStockPriceTime(java.sql.Time.valueOf("15:30:14"));
		return stockPriceDto;
	}
	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	

}
