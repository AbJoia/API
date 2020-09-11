package org.g2ac.javabackendMarketplace.projetoFinal.Exceptions;

public class DataNotFoundException extends Exception {
		
	private static final long serialVersionUID = 1L;
	private Integer id;
	
	public DataNotFoundException(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}	
	
}
