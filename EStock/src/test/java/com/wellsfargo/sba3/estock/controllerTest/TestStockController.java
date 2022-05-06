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
import com.wellsfargo.sba3.estock.service.StockService;
import com.wellsfargo.sba3.estock.testdata.Mockdata;
import org.springframework.http.MediaType;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

@WebMvcTest(EStockController.class)
@AutoConfigureMockMvc
public class TestStockController {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private StockService stockService;
	
	@Test
	public void testaddStockDetails() throws Exception {
		StockPriceDto stockPriceDto=Mockdata.getStockDto();
		StockPriceDto savestockPriceDto=Mockdata.getStockDto();

		when(this.stockService.saveStockPriceDetails(stockPriceDto)).thenReturn(savestockPriceDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/add-Stock")
				.content(Mockdata.asJsonString(stockPriceDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assert(result.getResponse().getContentAsString().contentEquals(Mockdata.asJsonString(savestockPriceDto)));
	}
	@Test
	public void testgetStockPriceIndex() throws Exception {
		StockPriceDto stockPriceDto=Mockdata.getStockDto();
		StockPriceDto savestockPriceDto=Mockdata.getStockDto();
		Date startDate=java.sql.Date.valueOf("2022-2-15");
		Date endDate=java.sql.Date.valueOf("2022-2-15");
		//when(this.stockService.getStockPriceIndex(1l,startDate,endDate)).thenReturn(savestockPriceDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/getStockPriceIndex/1,2022-2-23,2022-3-23")
				.content(Mockdata.asJsonString(stockPriceDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assert(result.getResponse().getContentAsString().contentEquals(Mockdata.asJsonString(savestockPriceDto)));
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testgetStockByCode() throws Exception {
		StockPriceDto stockPriceDto=Mockdata.getStockDto();
		List<StockPriceDto> savestockPriceDto=(List<StockPriceDto>) Mockdata.getStockDto();

		when(this.stockService.getStockByCode(1l)).thenReturn(savestockPriceDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/getStockByCompanyCode/1")
				.content(Mockdata.asJsonString(stockPriceDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assert(result.getResponse().getContentAsString().contentEquals(Mockdata.asJsonString(savestockPriceDto)));
	}


}
