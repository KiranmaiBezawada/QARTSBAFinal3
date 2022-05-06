package com.wellsfargo.sba3.estock.exception;

public class CompanyNotFoundException extends RuntimeException{
	public CompanyNotFoundException(String message) {
		super(message);
	}

}
