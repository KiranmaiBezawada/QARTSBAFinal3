package com.wellsfargo.sba3.estock.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.sba3.estock.dto.CompanyDetailsDto;
import com.wellsfargo.sba3.estock.dto.StockPriceDto;
import com.wellsfargo.sba3.estock.dto.StockPriceIndexDto;
import com.wellsfargo.sba3.estock.entity.StockPriceDetails;
import com.wellsfargo.sba3.estock.repository.StockPriceDetailsRepo;
import com.wellsfargo.sba3.estock.utils.EStockUtility;

@Service
public class StockServiceImpl implements StockService{
	
		@Autowired
	    private StockPriceDetailsRepo stockRepository;
		@Autowired
	    private CompanyServiceImpl companyServiceImpl;
		
	   

	@Override
	public StockPriceDto saveStockPriceDetails(StockPriceDto stockPriceDto) {
		StockPriceDetails newStock = EStockUtility.convertToStockPriceDetails(stockPriceDto);
        stockRepository.save(newStock);
        return stockPriceDto;
		
	}
	

	@Override
	public List<StockPriceDto> getStockByCode(Long companyCode) {
		 List<StockPriceDetails> stockPriceDetailsList = stockRepository.findStockDetailslsByCode(companyCode);
	        return EStockUtility.convertToStockPriceDtoList(stockPriceDetailsList);
	}


	@Override
	public StockPriceIndexDto getStockPriceIndex(Long companyCode, Date startDate, Date endDate) {
		 CompanyDetailsDto companyDetailsDto = companyServiceImpl.getCompanyInfoById(companyCode);

	        if (companyDetailsDto == null) {
	            return null;
	        }
	        List<StockPriceDetails> stockPriceDetails = stockRepository.findStockPriceIndex(companyCode, startDate,
	                endDate);

	        Double maxStockPrice = getMaxStockPrice(companyCode, startDate, endDate);
	        Double minStockPrice = getMinStockPrice(companyCode, startDate, endDate);
	        Double avgStockPrice = getAvgStockPrice(companyCode, startDate, endDate);
	        return new StockPriceIndexDto(companyDetailsDto,
	                EStockUtility.convertToStockPriceDtoList(stockPriceDetails), maxStockPrice, minStockPrice,
	                avgStockPrice);
	        
	}
	
	 public Double getMaxStockPrice(Long companyCode, Date startDate, Date endDate) {
	        return stockRepository.max(companyCode, startDate, endDate);
	    };

	    public Double getAvgStockPrice(Long companyCode, Date startDate, Date endDate) {
	        return stockRepository.avg(companyCode, startDate, endDate);
	    };

	    public Double getMinStockPrice(Long companyCode,Date startDate, Date endDate) {
	        return stockRepository.min(companyCode, startDate, endDate);
	    };

}
