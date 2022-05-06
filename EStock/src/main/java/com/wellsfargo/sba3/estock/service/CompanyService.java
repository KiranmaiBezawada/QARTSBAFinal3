package com.wellsfargo.sba3.estock.service;

import java.util.List;

import com.wellsfargo.sba3.estock.dto.CompanyDetailsDto;
import com.wellsfargo.sba3.estock.entity.CompanyDetails;

public interface CompanyService {		
	public CompanyDetailsDto saveCompanyDetails(CompanyDetailsDto companyDetailsDto);
	public CompanyDetailsDto deleteCompany(Long companyCode);
	public CompanyDetailsDto getCompanyInfoById(Long companyCode);
	public CompanyDetailsDto getCompanyDetailsByNameAndStockExchange(String name , String stockExchange);

	
		
}
