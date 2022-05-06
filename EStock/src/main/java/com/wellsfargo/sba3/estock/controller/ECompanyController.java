package com.wellsfargo.sba3.estock.controller;
import org.springframework.stereotype.Controller;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.websocket.server.PathParam;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.sba3.estock.dto.CompanyDetailsDto;
import com.wellsfargo.sba3.estock.exception.CompanyNotFoundException;
import com.wellsfargo.sba3.estock.exception.InvalidCompanyException;
import com.wellsfargo.sba3.estock.service.CompanyService;


@RestController
@RequestMapping("/api/v1/company")
public class ECompanyController {
	@Autowired
    private CompanyService companyService;
	
	@PostMapping("/add-company")
	 public ResponseEntity<CompanyDetailsDto> addCompanyDetails(
	            @RequestBody @Validated CompanyDetailsDto companyDetailsDto, BindingResult result) {
	        if (!result.hasErrors())
	            throw new InvalidCompanyException("Invalid Input Details!!!");
	        else {
	            if (companyService.getCompanyDetailsByNameAndStockExchange(companyDetailsDto.getCompanyName(),
	                    companyDetailsDto.getStockExchange()) != null)
	                throw new InvalidCompanyException("Comapany already exists");
	            return new ResponseEntity<CompanyDetailsDto>(companyService.saveCompanyDetails(companyDetailsDto),
	                    HttpStatus.OK);
	        }
	    }
	
	@DeleteMapping("/deleteCompany/{companyCode}")
	public ResponseEntity<CompanyDetailsDto> deleteCompanyDetails(@PathVariable Long companyCode) {
     CompanyDetailsDto companyDetailsDto = companyService.deleteCompany(companyCode);
   if (companyDetailsDto == null) {
            throw new CompanyNotFoundException("Invalid Company Code!! Please enter valid companyCode...");
        } else {
         return new ResponseEntity<CompanyDetailsDto>(companyDetailsDto, HttpStatus.OK);
        }
    }

}
