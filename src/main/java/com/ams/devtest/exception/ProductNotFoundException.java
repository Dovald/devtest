package com.ams.devtest.exception;

public class ProductNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1363849454906985289L;
	
	public ProductNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
