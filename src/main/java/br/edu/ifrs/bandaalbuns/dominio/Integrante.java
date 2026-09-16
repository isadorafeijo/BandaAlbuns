package br.edu.ifrs.bandaalbuns.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Integrante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String nome;
	private String instrumento;
	
	@ManyToOne
    private Banda banda;
	
	public Integrante() {
	}
	
	public Integrante(String nome, String instrumento) {
		this.nome = nome;
		this.instrumento = instrumento;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInstrumento() {
		return instrumento;
	}

	public void setInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}
	public void setBanda(Banda banda) {
		this.banda = banda;
	}

	@Override
	public String toString() {
		return "Integrante [id=" + id + ", nome=" + nome + ", instrumento=" + instrumento + "]";
	}
}
