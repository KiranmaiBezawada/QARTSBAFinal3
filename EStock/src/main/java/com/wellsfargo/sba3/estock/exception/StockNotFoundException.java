package com.wellsfargo.sba3.estock.exception;

public class StockNotFoundException extends RuntimeException{
	public StockNotFoundException(String message) {
		super(message);
	}

}
