package com.ams.devtest.exception;

public class ThirdPartyException extends RuntimeException{

	private static final long serialVersionUID = 1363849454906985288L;
	
	public ThirdPartyException(String errorMessage) {
        super(errorMessage);
    }

}
