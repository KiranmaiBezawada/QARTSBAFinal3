package com.wellsfargo.sba3.estock.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellsfargo.sba3.estock.entity.StockPriceDetails;

@Repository
public interface StockPriceDetailsRepo extends JpaRepository<StockPriceDetails,Long>{
	
	@Query("select sd FROM StockPriceDetails sd WHERE sd.companyCode=?1")
	List<StockPriceDetails> findStockDetailslsByCode(Long companyCode);
	
	@Query("select sd FROM StockPriceDetails sd where sd.companyCode=?1 and sd.stockPriceDate between ?2 and ?3")
	List<StockPriceDetails> findStockPriceIndex(Long companyCode, Date startDate,Date endDate);
	
	@Query( "SELECT max(currentStockPrice) from StockPriceDetails sd where sd.companyCode=?1 and sd.stockPriceDate between ?2 and ?3")
	double max(Long companyCode, Date startDate,Date endDate);
	
	@Query("SELECT min(currentStockPrice) from StockPriceDetails sd where sd.companyCode=?1 and sd.stockPriceDate between ?2 and ?3")
	double min(Long companyCode, Date startDate,Date endDate);
	
	 @Query( "SELECT avg(currentStockPrice) from StockPriceDetails sd where sd.companyCode=?1 and sd.stockPriceDate between ?2 and ?3")
	double avg(Long companyCode, Date startDate,Date endDate);
}
