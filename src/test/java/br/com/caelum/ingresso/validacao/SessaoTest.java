package br.com.caelum.ingresso.validacao;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class SessaoTest {
	
	@Test
	public void oPrecoDaSessaoDeveSerIgualASomaDoPrecoDaSalaMaisOPrecoDoFilme() {
		
		Sala sala = new  Sala("Eldorado - IMax", new BigDecimal("22.55"));
		Filme filme = new Filme("rOGUE One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12.0") );
		
		BigDecimal somaDosPrecosDaSalaEFilmes = sala.getPreco().add(filme.getPreco());
		
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
		
		Assert.assertEquals(somaDosPrecosDaSalaEFilmes, sessao.getPreco());
		
	}

}
