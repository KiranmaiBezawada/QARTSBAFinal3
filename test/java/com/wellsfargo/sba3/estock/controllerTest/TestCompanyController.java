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
import com.wellsfargo.sba3.estock.dto.CompanyDetailsDto;
import com.wellsfargo.sba3.estock.service.CompanyService;
import com.wellsfargo.sba3.estock.testdata.Mockdata;
import org.springframework.http.MediaType;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;


@WebMvcTest(ECompanyController.class)
@AutoConfigureMockMvc
public class TestCompanyController {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CompanyService companyService;
	
	@Test
	public void testaddCompanyDetails() throws Exception {
		CompanyDetailsDto companyDetailsDto = Mockdata.getCompanyDto();
		CompanyDetailsDto savedDevelopmentDto = Mockdata.getCompanyDto();

		savedDevelopmentDto.setCompanyCode(1L);

		 Mockito.when(companyService.saveCompanyDetails(companyDetailsDto)).thenReturn(savedDevelopmentDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/company/add-company")
				.content(Mockdata.asJsonString(companyDetailsDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assert(result.getResponse().getContentAsString().contentEquals(Mockdata.asJsonString(savedDevelopmentDto)));
	}

	@Test
	public void testdeleteCompanyDetails() throws Exception {
		CompanyDetailsDto companyDetailsDto = Mockdata.getCompanyDto();
		companyDetailsDto.setCompanyCode(2L);

		Mockito.when(companyService.deleteCompany(2L)).thenReturn(companyDetailsDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/company/deleteCompany/2")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertFalse(result.getResponse().getContentAsString().contentEquals(Mockdata.asJsonString(true)));
						
	}
	@SuppressWarnings("unused")
	@Test
	public void testAddCompanyBDD() throws Exception 
	{
		final int count[] = new int[1];
		
        CompanyDetailsDto companyDto = Mockdata.getCompanyDto();
		
		Mockito.when(companyService.saveCompanyDetails(companyDto)).then(new Answer<CompanyDetailsDto>() {
			@Override
			public CompanyDetailsDto answer(InvocationOnMock invocation) throws Throwable {
				
				count[0]++;
				return companyDto;
			}
		});
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/company/addCompany")
				.content(Mockdata.asJsonString(companyDto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);	
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		assertFalse(count[0] > 0);
	}
	@SuppressWarnings("unused")
	@Test
	public void testDeleteCompanyBDD() throws Exception 
	{
		final int count[] = new int[1];
	
        CompanyDetailsDto companyDto = Mockdata.getCompanyDto();
		Long companyCode = companyDto.getCompanyCode();
		
		Mockito.when(companyService.deleteCompany(companyCode)).then(new Answer<CompanyDetailsDto>() {
			@Override
			public CompanyDetailsDto answer(InvocationOnMock invocation) throws Throwable {
				
				count[0]++;
				return Mockdata.getCompanyDto();
			}
		});
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/company/deleteCompany/" + companyCode)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		assertFalse(count[0] > 0);
	}

}
