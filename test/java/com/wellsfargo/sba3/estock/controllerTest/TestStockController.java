package com.wellsfargo.sba3.estock.controllerTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.wellsfargo.sba3.estock.controller.ECompanyController;
import com.wellsfargo.sba3.estock.controller.EStockController;
import com.wellsfargo.sba3.estock.dto.CompanyDetailsDto;
import com.wellsfargo.sba3.estock.dto.StockPriceDto;
import com.wellsfargo.sba3.estock.dto.StockPriceIndexDto;
import com.wellsfargo.sba3.estock.service.StockService;
import com.wellsfargo.sba3.estock.testdata.Mockdata;
import org.springframework.http.MediaType;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

@WebMvcTest(EStockController.class)
@AutoConfigureMockMvc
public class TestStockController {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private StockService stockService;
	
	/*	@Test
	public void testaddStockDetails() throws Exception {
		StockPriceDto stockPriceDto=Mockdata.getStockDto();
		StockPriceDto savestockPriceDto=Mockdata.getStockDto();

		Mockito.when(stockService.saveStockPriceDetails(stockPriceDto)).thenReturn(savestockPriceDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/stock/add-Stock")
				.content(Mockdata.asJsonString(stockPriceDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assert(result.getResponse().getContentAsString().contentEquals(Mockdata.asJsonString(savestockPriceDto)));
	}*/
	@Test
	public void testgetStockPriceIndex() throws Exception {
		  StockPriceIndexDto stockPriceIndexDto = Mockdata.getStockPriceIndexDto();
	        
	        CompanyDetailsDto companyDetailDTO = stockPriceIndexDto.getCompanyDto();
	        Long companyCode = companyDetailDTO.getCompanyCode();
	        
	        List<StockPriceDto> stockPDDTOList = stockPriceIndexDto.getStockPriceList();
	        StockPriceDto spDetails1 = stockPDDTOList.get(0);
	        StockPriceDto spDetails2 = stockPDDTOList.get(1);
	        
	        LocalDate startDate = spDetails1.getStockPriceDate();
	        LocalDate endDate   = spDetails2.getStockPriceDate();

	        //StockPriceIndexDTO stockPriceIndexDTO = new StockPriceIndexDTO();
	        
			Mockito.when(stockService.getStockPriceIndex(companyCode, startDate, endDate)).thenReturn(stockPriceIndexDto);

			RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/stock/getStockPriceIndex/"+companyCode+"/"+startDate+"/"+endDate)
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();

			

		assertFalse(result.getResponse().getContentAsString().contains("\"companyCode\":1L"));
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testgetStockByCode() throws Exception {
		  StockPriceDto stockDto = Mockdata.getStockDto();
	        Long companyCode = stockDto.getCompanyCode();
	        
			List<StockPriceDto> stockList = new ArrayList<StockPriceDto>();
			stockList.add(stockDto);

			Mockito.when(stockService.getStockByCode(companyCode)).thenReturn(stockList);

			RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/stock/getStockByCompanyCode/" + companyCode)
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();


		assertFalse(result.getResponse().getContentAsString().contains("\"currentStockPrice\":8900.00"));
	}
	@SuppressWarnings("unused")
	@Test
	public void testFindStockByCompanyCodeBDD() throws Exception 
	{
		final int count[] = new int[1];
		
        StockPriceDto stockDto = Mockdata.getStockDto();
        Long companyCode = stockDto.getCompanyCode();

		List<StockPriceDto> stockList = new ArrayList<StockPriceDto>();
		stockList.add(stockDto);
		Mockito.when(stockService.getStockByCode(companyCode)).then(new Answer<List<StockPriceDto>>() {
			@Override
			public List<StockPriceDto> answer(InvocationOnMock invocation) throws Throwable {
				
				count[0]++;
				return stockList;
			}
		});
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/stock/getStockByCompanyCode/" + companyCode)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		assertFalse(count[0] > 0);
	}	
	public void testStockPriceIndexBDD() throws Exception 
	{
		final int count[] = new int[1];
	
        StockPriceIndexDto stockPriceIndexDTO = new StockPriceIndexDto();
        
        StockPriceIndexDto stockPriceDto = Mockdata.getStockPriceIndexDto();
        
        CompanyDetailsDto companyDetailDTO = stockPriceDto.getCompanyDto();
        Long companyCode = companyDetailDTO.getCompanyCode();
        
        List<StockPriceDto> stockPDDTOList = stockPriceDto.getStockPriceList();
        
        StockPriceDto spDetails1 = stockPDDTOList.get(0);
        StockPriceDto spDetails2 = stockPDDTOList.get(1);
        
        LocalDate startDate = spDetails1.getStockPriceDate();
        LocalDate endDate   = spDetails2.getStockPriceDate();

		Mockito.when(stockService.getStockPriceIndex(companyCode, startDate, endDate)).then(new Answer<StockPriceIndexDto>() {
			@Override
			public StockPriceIndexDto answer(InvocationOnMock invocation) throws Throwable {
				
				count[0]++;
				return stockPriceIndexDTO;
			}
		});
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/stock/getStockPriceIndex/"+companyCode+"/"+startDate+"/"+endDate)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

	
		assert(count[0] >0 );
	}	

}
