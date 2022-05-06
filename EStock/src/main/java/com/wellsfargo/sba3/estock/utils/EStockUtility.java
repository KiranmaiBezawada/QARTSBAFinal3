package com.wellsfargo.sba3.estock.utils;

import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.sba3.estock.dto.CompanyDetailsDto;
import com.wellsfargo.sba3.estock.dto.StockPriceDto;
import com.wellsfargo.sba3.estock.entity.CompanyDetails;
import com.wellsfargo.sba3.estock.entity.StockPriceDetails;

public class EStockUtility {
	   public static StockPriceDetails convertToStockPriceDetails(StockPriceDto stockPriceDto) {

        StockPriceDetails newStock = new StockPriceDetails();

        newStock.setId(stockPriceDto.getId());
        newStock.setCompanyCode(stockPriceDto.getCompanyCode());
        newStock.setCurrentStockPrice(stockPriceDto.getCurrentStockPrice());
        newStock.setStockPriceDate(stockPriceDto.getStockPriceDate());
        newStock.setStockPriceTime(stockPriceDto.getStockPriceTime());

        return newStock;
    };

    // ---------------------------------------------------------------------------------------------------------------------------------
    public static StockPriceDto convertTostockPriceDto(StockPriceDetails stockPriceDetails) {

    	StockPriceDto newStock = new StockPriceDto();

        newStock.setId(stockPriceDetails.getId());
        newStock.setCompanyCode(stockPriceDetails.getCompanyCode());
        newStock.setCurrentStockPrice(stockPriceDetails.getCurrentStockPrice());
        newStock.setStockPriceDate(stockPriceDetails.getStockPriceDate());
        newStock.setStockPriceTime(stockPriceDetails.getStockPriceTime());

        return newStock;
    };

    // =================================================================================================================================
    // 2. Company Details Conversion : Model to DTO - AND - DTO to Model
    // =================================================================================================================================
    public static CompanyDetailsDto convertToCompanyDetailsDto(CompanyDetails companyDetails) {
        if (companyDetails == null) {
            return null;
        }
        CompanyDetailsDto newCompanyDTO = new CompanyDetailsDto();

        newCompanyDTO.setCompanyCode(companyDetails.getCompanyCode());
        newCompanyDTO.setStockExchange(companyDetails.getStockExchange());
        newCompanyDTO.setCompanyName(companyDetails.getCompanyName());
        newCompanyDTO.setCompanyCEO(companyDetails.getCompanyCEO());
        newCompanyDTO.setTurnover(companyDetails.getTurnover());
        newCompanyDTO.setBoardOfDirectors(companyDetails.getBoardOfDirectors());
        newCompanyDTO.setCompanyProfile(companyDetails.getCompanyProfile());

        return newCompanyDTO;
    };

    // ---------------------------------------------------------------------------------------------------------------------------------
    public static CompanyDetails convertToCompanyDetails(CompanyDetailsDto companyDetailsDto) {

        CompanyDetails newCompany = new CompanyDetails();

        newCompany.setCompanyCode(companyDetailsDto.getCompanyCode());
        newCompany.setStockExchange(companyDetailsDto.getStockExchange());
        newCompany.setCompanyName(companyDetailsDto.getCompanyName());
        newCompany.setCompanyCEO(companyDetailsDto.getCompanyCEO());
        newCompany.setTurnover(companyDetailsDto.getTurnover());
        newCompany.setBoardOfDirectors(companyDetailsDto.getBoardOfDirectors());
        newCompany.setCompanyProfile(companyDetailsDto.getCompanyProfile());

        return newCompany;
    };

    // ---------------------------------------------------------------------------------------------------------------------------------
    public static List<CompanyDetailsDto> convertToCompanyDetailsDtoList(List<CompanyDetails> companyDetailsList) {

        List<CompanyDetailsDto> list = new ArrayList<CompanyDetailsDto>();

        for (CompanyDetails companyDto : companyDetailsList) {
            list.add(convertToCompanyDetailsDto(companyDto));
        }
        return list;
    }

    // ---------------------------------------------------------------------------------------------------------------------------------
    public static List<StockPriceDto> convertToStockPriceDtoList(
            List<StockPriceDetails> stockPriceDetailsList) {

        if (stockPriceDetailsList == null || stockPriceDetailsList.isEmpty()) {
            return null;
        }
        List<StockPriceDto> list = new ArrayList<StockPriceDto>();

        for (StockPriceDetails stockDto : stockPriceDetailsList) {
            list.add(convertTostockPriceDto(stockDto));
        }
        return list;
    }

}
