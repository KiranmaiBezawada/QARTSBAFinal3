package com.wellsfargo.sba3.estock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.wellsfargo.sba3.estock.entity.CompanyDetails;
import com.wellsfargo.sba3.estock.entity.StockPriceDetails;

@Repository
public interface CompanyDetailsRepo extends JpaRepository<CompanyDetails,Long>{
	CompanyDetails findCompanyDetailsBycompanyCode(Long companyCode);
	CompanyDetails findCompanyDetailsByCompanyNameAndStockExchange(String companyName,String stockExchange);
	void deleteByCompanyCode(Long companyCode);

}
