package com.algaworks.estoque.service;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ServiceException(String msg) {
		super(msg);
	}

}