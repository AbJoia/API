package org.g2ac.javabackendMarketplace.projetoFinal.Exceptions;

public class SolicitacaoInvalidaException extends Exception {
	
	private static final long serialVersionUID = 1L;
	String msg;
	public SolicitacaoInvalidaException(String msg) {
		this.msg = msg;
	}
	public String getMsg() {
		return msg;
	}	
	
}
