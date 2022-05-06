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
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;


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

		when(this.companyService.saveCompanyDetails(companyDetailsDto)).thenReturn(savedDevelopmentDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/add-company")
				.content(Mockdata.asJsonString(companyDetailsDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assert(result.getResponse().getContentAsString().contentEquals(Mockdata.asJsonString(savedDevelopmentDto)));
	}

	@Test
	public void testdeleteCompanyDetails() throws Exception {
		CompanyDetailsDto companyDetailsDto = Mockdata.getCompanyDto();
		companyDetailsDto.setCompanyCode(2L);

		when(this.companyService.deleteCompany(2L)).thenReturn(companyDetailsDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteCompany/2")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assert(result.getResponse().getContentAsString().contentEquals(Mockdata.asJsonString(true)));
						
	}

}
