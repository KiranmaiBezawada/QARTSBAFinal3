package com.wellsfargo.sba3.estock.servicetest;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.wellsfargo.sba3.estock.dto.CompanyDetailsDto;
import com.wellsfargo.sba3.estock.service.CompanyService;
import com.wellsfargo.sba3.estock.service.StockService;
import com.wellsfargo.sba3.estock.testdata.Mockdata;

@WebMvcTest(CompanyService.class)
@AutoConfigureMockMvc
public class CompanyServiceTest {
	private static Validator validator;	
	private static final long serialVersionUID = 8L;
	@MockBean
	private CompanyService companyService;
	
	@BeforeAll
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		
	}
	@Test
	public void testgetCompanyDetailsByNameAndStockExchange() throws Exception {
		CompanyDetailsDto companyDetailsDto = Mockdata.getCompanyDto();
		companyDetailsDto.setCompanyName(null);
		
		Mockito.when(companyService.getCompanyDetailsByNameAndStockExchange(null, "Keshav")).thenReturn(null);
        CompanyDetailsDto result=companyService.getCompanyDetailsByNameAndStockExchange(null, "Keshav");
		assert (result == null);
	}
	@Test
	public void testgetCompanyInfoById() throws Exception {
		CompanyDetailsDto companyDetailsDto = Mockdata.getCompanyDto();
		companyDetailsDto.setCompanyCode(null);
		
		Mockito.when(companyService.getCompanyInfoById(null)).thenReturn(null);
        CompanyDetailsDto result=companyService.getCompanyInfoById(null);
		assert (result == null);
	}

	
}
