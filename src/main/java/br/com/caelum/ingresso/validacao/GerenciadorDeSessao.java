package br.com.caelum.ingresso.validacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessao {

	private List<Sessao> sessoesDaSala;

	public GerenciadorDeSessao(List<Sessao> sessoesDaSala) {

		this.sessoesDaSala = sessoesDaSala;
	}

	public boolean cabe(Sessao sessaoNova) {

		if (terminaAmanha(sessaoNova)) {
			System.out.println("termina amanha");
			return false;
		}
		return sessoesDaSala.stream().noneMatch(sessaoExistente -> horarioIsConfltante(sessaoExistente, sessaoNova));
	}

	private boolean terminaAmanha(Sessao sessao) {

		LocalDateTime terminoessaoNova = getTerminoSessaoComDiaDeHoje(sessao);
		LocalDateTime ultimoSegundoDeHoje = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);

		if (terminoessaoNova.isAfter(ultimoSegundoDeHoje)) {

			return true;

		}
		return false;

	}

	private boolean horarioIsConfltante(Sessao sessaoExistente, Sessao sessaoNova) {

		LocalDateTime inicioSessaoExistente = getInicioSessaoComDiaDeHoje(sessaoExistente);
		LocalDateTime terminoSessaoExistente = getTerminoSessaoComDiaDeHoje(sessaoExistente);
		LocalDateTime inicioSessaoNova = getInicioSessaoComDiaDeHoje(sessaoNova);
		LocalDateTime terminoSessaoNova = getTerminoSessaoComDiaDeHoje(sessaoNova);

		boolean sessaoNovaTerminaAntesDaExistente = terminoSessaoNova.isBefore(inicioSessaoExistente);
		boolean sessaoNovaComecaDepoisDaExistente = terminoSessaoExistente.isBefore(inicioSessaoNova);

		if (sessaoNovaTerminaAntesDaExistente || sessaoNovaComecaDepoisDaExistente) {
			System.out.println("horarioIsConfltante false");
			return false;
		}
		System.out.println("horarioIsConfltante true");
		return true;
	}

	private LocalDateTime getInicioSessaoComDiaDeHoje(Sessao sessao) {

		LocalDate hoje = LocalDate.now();

		return sessao.getHorario().atDate(hoje);

	}

	private LocalDateTime getTerminoSessaoComDiaDeHoje(Sessao sessao) {

		LocalDateTime inicioSessaoNova = getInicioSessaoComDiaDeHoje(sessao);

		return inicioSessaoNova.plus(sessao.getFilme().getDuracao());
	}
}