package com.wellsfargo.sba3.estock.controller;
import org.springframework.stereotype.Controller;
import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.sba3.estock.dto.StockPriceDto;
import com.wellsfargo.sba3.estock.dto.StockPriceIndexDto;
import com.wellsfargo.sba3.estock.exception.CompanyNotFoundException;
import com.wellsfargo.sba3.estock.exception.InvalidStockException;
import com.wellsfargo.sba3.estock.exception.StockNotFoundException;
import com.wellsfargo.sba3.estock.service.CompanyService;
import com.wellsfargo.sba3.estock.service.StockService;

@RestController
@RequestMapping("api/v1/stock")
public class EStockController {
	  	@Autowired
	    private StockService stockService;	   
	
@PostMapping("/add-Stock")
    public ResponseEntity<StockPriceDto> addStockDetails(
            @RequestBody @Validated StockPriceDto stockPriceDto, BindingResult result) {
        
        if (!result.hasErrors()) {
            throw new InvalidStockException("Invalid Input Details!!!");
        } 
               stockService.saveStockPriceDetails(stockPriceDto);
                return ResponseEntity.ok(stockPriceDto);       
                   
    }

	@GetMapping("/getStockByCompanyCode/{companyCode}")
	public ResponseEntity<List<StockPriceDto>> getStockByCompanyCode(@PathVariable Long companyCode) {
    if (companyCode != null) {
        List<StockPriceDto> stockPriceDetailsList = stockService.getStockByCode(companyCode);
        if (stockPriceDetailsList == null || stockPriceDetailsList.isEmpty()) {
            throw new StockNotFoundException("No Company/Stock codes available");
        }
        List<StockPriceDto> stockPriceList =stockService.getStockByCode(companyCode);
        return ResponseEntity.ok(stockPriceList);
    }
    else
        throw new CompanyNotFoundException("Invalid Company Code!! Please enter valid companyCode...");
}

	
	@GetMapping(value = "/getStockPriceIndex/{companyCode}/{startDate}/{endDate}")
    public ResponseEntity<StockPriceIndexDto> displayStockPriceIndex(@PathVariable Long companyCode,
            @PathVariable Date startDate, @PathVariable Date endDate) {

        if (companyCode != null) {
            StockPriceIndexDto stockPriceIndexDTO = stockService.getStockPriceIndex(companyCode, startDate, endDate);
            if (stockPriceIndexDTO == null) {
                throw new StockNotFoundException("No Company/Stock codes available");
            }            
            return new ResponseEntity<StockPriceIndexDto>(
                    stockPriceIndexDTO,
                    HttpStatus.OK);
        } else
            throw new CompanyNotFoundException("Invalid Company Code!! Please enter valid companyCode...");

    }
}
