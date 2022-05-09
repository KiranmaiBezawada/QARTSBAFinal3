package com.wellsfargo.sba3.estock.exceptionTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.wellsfargo.sba3.estock.controller.EStockController;
import com.wellsfargo.sba3.estock.dto.StockPriceDto;
import com.wellsfargo.sba3.estock.exception.StockNotFoundException;
import com.wellsfargo.sba3.estock.service.StockService;
import com.wellsfargo.sba3.estock.testdata.Mockdata;


@WebMvcTest(EStockController.class)
@AutoConfigureMockMvc
public class StockExceptionTest {
	
	@Autowired
	private MockMvc mockMvc;


	@MockBean
	private StockService stockService;
	@Test
	public void testStockForExceptionUponFetchingStockDetailsByNullValue() throws Exception
	{
		Mockito.when(stockService.getStockByCode(2L)).thenReturn(null);
				
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/stock/getStockByCompanyCode/2")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		
		assert(result.getResponse().getStatus() == 404 );		
	}
	//--------------------------------------------------------------------------------------------
	

}
