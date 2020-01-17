package br.com.caelum.ingresso.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	List<Ingresso> ingressos = new ArrayList<>();
	
	/*
	 * 
	 * @deprecated hibernate only
	 * 
	 * 
	 */
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Ingresso> getIngressos() {
		return ingressos;
	}
	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}
	public Compra (List<Ingresso> ingressos) {
		
		ingressos.forEach(this.ingressos::add);
		
	}
	public Compra() {
		
	}

}
