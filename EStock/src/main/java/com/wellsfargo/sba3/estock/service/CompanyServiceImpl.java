package com.wellsfargo.sba3.estock.service;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wellsfargo.sba3.estock.dto.CompanyDetailsDto;
import com.wellsfargo.sba3.estock.entity.CompanyDetails;
import com.wellsfargo.sba3.estock.repository.CompanyDetailsRepo;
import com.wellsfargo.sba3.estock.utils.EStockUtility;


@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDetailsRepo repository;
    
    @Override
    public CompanyDetailsDto saveCompanyDetails(CompanyDetailsDto companyDetailsDto) {
        CompanyDetails newCompany = EStockUtility.convertToCompanyDetails(companyDetailsDto);
        repository.save(newCompany);
        return companyDetailsDto;
    }
    
    @Override
    @Transactional
    public CompanyDetailsDto deleteCompany(Long companyCode) { 
    	CompanyDetailsDto companyDetailsDto = this.getCompanyInfoById(companyCode);
    if (companyDetailsDto == null) {
        return null;
    }
    repository.deleteByCompanyCode(companyCode);
    return companyDetailsDto;
    }
    
    @Override
    public CompanyDetailsDto getCompanyInfoById(Long companyCode) {
        if (companyCode == null) {
            return null;
        }
        CompanyDetails companyInfo = repository.findCompanyDetailsBycompanyCode(companyCode);
        return EStockUtility.convertToCompanyDetailsDto(companyInfo);
    }
    
	@Override
	public CompanyDetailsDto getCompanyDetailsByNameAndStockExchange(String name, String stockExchange) {
		CompanyDetails companyInfo = repository.findCompanyDetailsByCompanyNameAndStockExchange(name,
                stockExchange);
        return EStockUtility.convertToCompanyDetailsDto(companyInfo);
	}
    
    
    
}
