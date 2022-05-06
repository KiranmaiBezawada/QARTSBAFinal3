package com.wellsfargo.sba3.estock.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.wellsfargo.sba3.estock.dto.StockPriceDto;
import com.wellsfargo.sba3.estock.dto.StockPriceIndexDto;
import com.wellsfargo.sba3.estock.entity.StockPriceDetails;

public interface StockService {
	public StockPriceDto saveStockPriceDetails(StockPriceDto stockPriceDto);
		public List<StockPriceDto> getStockByCode(Long companyCode);
		public StockPriceIndexDto getStockPriceIndex(Long companyCode, Date startDate, Date endDate);
	}
