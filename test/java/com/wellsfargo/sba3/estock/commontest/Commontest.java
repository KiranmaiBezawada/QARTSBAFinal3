package com.wellsfargo.sba3.estock.commontest;

import javax.validation.Validator;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.wellsfargo.sba3.estock.dto.CompanyDetailsDto;
import com.wellsfargo.sba3.estock.dto.StockPriceDto;
import com.wellsfargo.sba3.estock.repository.CompanyDetailsRepo;
import com.wellsfargo.sba3.estock.repository.StockPriceDetailsRepo;
import com.wellsfargo.sba3.estock.service.CompanyServiceImpl;
import com.wellsfargo.sba3.estock.service.StockServiceImpl;
import com.wellsfargo.sba3.estock.testdata.Mockdata;

import static org.junit.Assert.*;

import java.util.Set;
import org.junit.platform.runner.JUnitPlatform;

@ExtendWith(SpringExtension.class)
@RunWith(JUnitPlatform.class)
public class Commontest {
	private static Validator validator;	
	private static final long serialVersionUID = 3L;
	
	@BeforeAll
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	@Test
	public void testboardOfDirectorsNotNull() throws Exception {
		CompanyDetailsDto companyDetailsDto = Mockdata.getCompanyDto();
		companyDetailsDto.setBoardOfDirectors(null);
		Set<ConstraintViolation<CompanyDetailsDto>> violations = validator.validate(companyDetailsDto);
		assert(!violations.isEmpty());
	}

	@Test
	public void testboardOfDirectorsMinFive() throws Exception {
		CompanyDetailsDto companyDetailsDto = Mockdata.getCompanyDto();
		companyDetailsDto.setBoardOfDirectors("ZX");
		Set<ConstraintViolation<CompanyDetailsDto>> violations = validator.validate(companyDetailsDto);
		assert(!violations.isEmpty());
	}
	@Test
	public void testboardOfDirectorsMaxTwoHundred() throws Exception {
		CompanyDetailsDto companyDetailsDto = Mockdata.getCompanyDto();
		String bod = "";
		for (int i = 0; i < 220; i++) {
			bod.concat("A");
		}
		companyDetailsDto.setBoardOfDirectors(bod);
		Set<ConstraintViolation<CompanyDetailsDto>> violations = validator.validate(companyDetailsDto);
		assert(!violations.isEmpty());
	}
	@Test
	public void testcompanyProfileNotNull() throws Exception {
		CompanyDetailsDto companyDetailsDto = Mockdata.getCompanyDto();
		companyDetailsDto.setCompanyProfile(null);
		Set<ConstraintViolation<CompanyDetailsDto>> violations = validator.validate(companyDetailsDto);
		assert(!violations.isEmpty());
	}

	@Test
	public void testcompanyProfileMinFive() throws Exception {
		CompanyDetailsDto companyDetailsDto = Mockdata.getCompanyDto();
		companyDetailsDto.setCompanyProfile("ZX");
		Set<ConstraintViolation<CompanyDetailsDto>> violations = validator.validate(companyDetailsDto);
		assert(!violations.isEmpty());
	}
	@Test
	public void testcompanyProfileMaxTwoHundredFiftyFive() throws Exception {
		CompanyDetailsDto companyDetailsDto = Mockdata.getCompanyDto();
		String cp = "";
		for (int i = 0; i < 270; i++) {
			cp.concat("A");
		}
		companyDetailsDto.setCompanyProfile(cp);
		Set<ConstraintViolation<CompanyDetailsDto>> violations = validator.validate(companyDetailsDto);
		assert(!violations.isEmpty());
	}
	@Test
	public void testcompanyCEONotNull() throws Exception {
		CompanyDetailsDto companyDetailsDto = Mockdata.getCompanyDto();
		companyDetailsDto.setCompanyCEO(null);
		Set<ConstraintViolation<CompanyDetailsDto>> violations = validator.validate(companyDetailsDto);
		assert(!violations.isEmpty());
	}

	@Test
	public void testcompanyCEOMinThree() throws Exception {
		CompanyDetailsDto companyDetailsDto = Mockdata.getCompanyDto();
		companyDetailsDto.setCompanyCEO("ZX");
		Set<ConstraintViolation<CompanyDetailsDto>> violations = validator.validate(companyDetailsDto);
		assert(!violations.isEmpty());
	}
	@Test
	public void testcompanyCEOMaxFifty() throws Exception {
		CompanyDetailsDto companyDetailsDto = Mockdata.getCompanyDto();
		String cc = "";
		for (int i = 0; i < 70; i++) {
			cc.concat("A");
		}
		companyDetailsDto.setCompanyCEO(cc);
		Set<ConstraintViolation<CompanyDetailsDto>> violations = validator.validate(companyDetailsDto);
		assert(!violations.isEmpty());
	}
	@Test
	public void testcompanyNameNotNull() throws Exception {
		CompanyDetailsDto companyDetailsDto = Mockdata.getCompanyDto();
		companyDetailsDto.setCompanyName(null);
		Set<ConstraintViolation<CompanyDetailsDto>> violations = validator.validate(companyDetailsDto);
		assert(!violations.isEmpty());
	}

	@Test
	public void testcompanyNameMinFive() throws Exception {
		CompanyDetailsDto companyDetailsDto = Mockdata.getCompanyDto();
		companyDetailsDto.setCompanyName("ZX");
		Set<ConstraintViolation<CompanyDetailsDto>> violations = validator.validate(companyDetailsDto);
		assert(!violations.isEmpty());
	}
	@Test
	public void testcompanyNameMaxFifty() throws Exception {
		CompanyDetailsDto companyDetailsDto = Mockdata.getCompanyDto();
		String cn = "";
		for (int i = 0; i < 70; i++) {
			cn.concat("A");
		}
		companyDetailsDto.setCompanyName(cn);
		Set<ConstraintViolation<CompanyDetailsDto>> violations = validator.validate(companyDetailsDto);
		assert(!violations.isEmpty());
	}
	@Test
	public void teststockExchangeNotNull() throws Exception {
		CompanyDetailsDto companyDetailsDto = Mockdata.getCompanyDto();
		companyDetailsDto.setStockExchange(null);
		Set<ConstraintViolation<CompanyDetailsDto>> violations = validator.validate(companyDetailsDto);
		assert(!violations.isEmpty());
	}

	@Test
	public void teststockExchangeMinFive() throws Exception {
		CompanyDetailsDto companyDetailsDto = Mockdata.getCompanyDto();
		companyDetailsDto.setStockExchange("ZX");
		Set<ConstraintViolation<CompanyDetailsDto>> violations = validator.validate(companyDetailsDto);
		assert(!violations.isEmpty());
	}
	@Test
	public void teststockExchangeMaxFifty() throws Exception {
		CompanyDetailsDto companyDetailsDto = Mockdata.getCompanyDto();
		String se = "";
		for (int i = 0; i < 70; i++) {
			se.concat("A");
		}
		companyDetailsDto.setStockExchange(se);
		Set<ConstraintViolation<CompanyDetailsDto>> violations = validator.validate(companyDetailsDto);
		assert(!violations.isEmpty());
	}
	@Test
	public void testturnoverNotNull() throws Exception {
		CompanyDetailsDto companyDetailsDto = Mockdata.getCompanyDto();
		companyDetailsDto.setTurnover(null);
		Set<ConstraintViolation<CompanyDetailsDto>> violations = validator.validate(companyDetailsDto);
		assert(!violations.isEmpty());
	}
	
	
	
	@Test
	public void testturnoverscaletwo() throws Exception {
		CompanyDetailsDto companyDetailsDto = Mockdata.getCompanyDto();
		double turnover=100000000.899;
		companyDetailsDto.setTurnover(turnover);
		Set<ConstraintViolation<CompanyDetailsDto>> violations = validator.validate(companyDetailsDto);
		assert(!violations.isEmpty());
	}
	
	@Test
	public void testcompanyCodeNotNull() throws Exception {
		CompanyDetailsDto companyDetailsDto = Mockdata.getCompanyDto();
		companyDetailsDto.setCompanyCode(null);
		Set<ConstraintViolation<CompanyDetailsDto>> violations = validator.validate(companyDetailsDto);
		assert(!violations.isEmpty());
	}
	@Test
	public void currentStockPriceNotNull() throws Exception {
		StockPriceDto stockPriceDto = Mockdata.getStockDto();
		stockPriceDto.setCurrentStockPrice(null);
		Set<ConstraintViolation<StockPriceDto>> violations = validator.validate(stockPriceDto);
		assert(!violations.isEmpty());
	}
	
	
	
	
	@Test
	public void stockPriceDateNotNull() throws Exception {
		StockPriceDto stockPriceDto = Mockdata.getStockDto();
		stockPriceDto.setStockPriceDate(null);
		Set<ConstraintViolation<StockPriceDto>> violations = validator.validate(stockPriceDto);
		assert(!violations.isEmpty());
	}
	
	@Test
	public void stockPriceTimeNotNull() throws Exception {
		StockPriceDto stockPriceDto = Mockdata.getStockDto();
		stockPriceDto.setStockPriceTime(null);
		Set<ConstraintViolation<StockPriceDto>> violations = validator.validate(stockPriceDto);
		assert(!violations.isEmpty());
	}
}
