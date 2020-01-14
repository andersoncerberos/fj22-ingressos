package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

public class DescontoParaEstudante implements Desconto {
	
	
	@Override
	public BigDecimal aplicarDescontoSobre(BigDecimal precoOrigem) {
		
		return precoOrigem.divide(new BigDecimal("2.0"));
	}

}
