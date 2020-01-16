package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

public class DescontoParaBancos implements Desconto {

	@Override
	public BigDecimal aplicarDescontoSobre(BigDecimal precoOrigem) {

		return precoOrigem.subtract(TrintaPorCentoSobre(precoOrigem));
	}

	public BigDecimal TrintaPorCentoSobre(BigDecimal precoOrigem) {

		return precoOrigem.multiply(new BigDecimal("0.3"));
	}

	public String getDescricao() {

		return "Desconto Banco";
	}

}
