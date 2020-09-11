package org.g2ac.javabackendMarketplace.projetoFinal.Exceptions;

public class MethodArgumentNotValidException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String msg;
	public MethodArgumentNotValidException(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}	
	
}
