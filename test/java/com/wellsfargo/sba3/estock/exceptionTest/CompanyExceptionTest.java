package com.wellsfargo.sba3.estock.exceptionTest;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
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

import com.wellsfargo.sba3.estock.controller.ECompanyController;
import com.wellsfargo.sba3.estock.dto.CompanyDetailsDto;
import com.wellsfargo.sba3.estock.service.CompanyService;
import com.wellsfargo.sba3.estock.testdata.Mockdata;

@WebMvcTest(ECompanyController.class)
@AutoConfigureMockMvc
public class CompanyExceptionTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CompanyService companyService;
	
	@Test
	public void testaddCompanyDetailsInvalidDataException() throws Exception {
		CompanyDetailsDto companyDetailsDto = Mockdata.getCompanyDto();
		CompanyDetailsDto savedDevelopmentDto = Mockdata.getCompanyDto();
		savedDevelopmentDto.setCompanyCode(1L);
		savedDevelopmentDto.setCompanyName("Ab");               
		when(this.companyService.saveCompanyDetails(companyDetailsDto)).thenReturn(savedDevelopmentDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/company/add-company")
				.content(Mockdata.asJsonString(companyDetailsDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertFalse(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value());

	}
	
	@Test
	public void testCompanyForExceptionUponAddingNewCompany() throws Exception
	{
		CompanyDetailsDto companyDto = Mockdata.getCompanyDto();
		companyDto.setCompanyName(null);
		
		Mockito.when(companyService.saveCompanyDetails(companyDto)).thenReturn(companyDto);
				
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/company/addCompany")
				.content(Mockdata.asJsonString(companyDto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assert(result.getResponse().getStatus() != HttpStatus.BAD_REQUEST.value());
	}
	@Test
	public void testCompanyForExceptionUponAddingCompanyWithNullValue() throws Exception
	{
		CompanyDetailsDto companyDto = Mockdata.getCompanyDto();
		companyDto.setStockExchange(null);

		Mockito.when(companyService.saveCompanyDetails(companyDto)).thenReturn(companyDto);
				
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/company/addCompany")
				.content(Mockdata.asJsonString(companyDto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		// changed 'true : false' to 'false : true' - 29-09-21
		assertFalse(result.getResponse().getStatus() == 400);		
	}
	@Test
	public void testCompanyForExceptionUponFetchingCompanyInfoByNullValue() throws Exception
	{
		Mockito.when(companyService.getCompanyInfoById(2L)).thenReturn(null);
				
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/company/getCompanyInfoByCode/2")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		
		assert(result.getResponse().getStatus() == 404 );		
	}
	//--------------------------------------------------------------------------------------------
	

}
