package com.wellsfargo.sba3.estock.testdata;

import com.wellsfargo.sba3.estock.dto.CompanyDetailsDto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wellsfargo.sba3.estock.dto.StockPriceDto;
import com.wellsfargo.sba3.estock.dto.StockPriceIndexDto;

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
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		stockPriceDto.setStockPriceDate(LocalDate.parse("08/07/2020", dateFormat));
		stockPriceDto.setStockPriceTime(LocalTime.parse("10:30:00"));
		
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
	public static StockPriceIndexDto getStockPriceIndexDto() 
	{
		StockPriceIndexDto stockPriceIndexDTO = new StockPriceIndexDto();
		
		CompanyDetailsDto companyDetailsDTO = getCompanyDto();

		List<StockPriceDto> stockPriceDetailsList = new ArrayList<StockPriceDto>();
		
		StockPriceDto stockPriceDetailsDTO1 = new StockPriceDto();
		stockPriceDetailsDTO1.setId((long)1001);
		stockPriceDetailsDTO1.setCompanyCode((long)2001);
		stockPriceDetailsDTO1.setCurrentStockPrice(55.76);
		DateTimeFormatter dateFormat1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		stockPriceDetailsDTO1.setStockPriceDate(LocalDate.parse("08/07/2020", dateFormat1));
		stockPriceDetailsDTO1.setStockPriceTime(LocalTime.parse("10:30:00"));
		
		StockPriceDto stockPriceDetailsDTO2 = new StockPriceDto();
		stockPriceDetailsDTO2.setId((long)1002);
		stockPriceDetailsDTO2.setCompanyCode((long)2002);
		stockPriceDetailsDTO2.setCurrentStockPrice(75.76);
		DateTimeFormatter dateFormat2 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		stockPriceDetailsDTO2.setStockPriceDate(LocalDate.parse("08/10/2020", dateFormat2));
		stockPriceDetailsDTO2.setStockPriceTime(LocalTime.parse("09:30:00"));		
		
		stockPriceDetailsList.add(stockPriceDetailsDTO1);
		stockPriceDetailsList.add(stockPriceDetailsDTO2);
			
		stockPriceIndexDTO.setCompanyDto(companyDetailsDTO);
		stockPriceIndexDTO.setStockPriceList(stockPriceDetailsList);
		stockPriceIndexDTO.setMaxStockPrice(85.55);
		stockPriceIndexDTO.setAvgStockPrice(47.15);
		stockPriceIndexDTO.setMinStockPrice(20.25);

		return stockPriceIndexDTO;
	}
	
	
	

}
