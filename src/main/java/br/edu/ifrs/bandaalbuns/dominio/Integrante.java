package br.edu.ifrs.bandaalbuns.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    @JoinColumn(name = "banda_id")
    private Banda banda;
	
	public Integrante() {
	}
	
	public Integrante(Long id, String nome, String instrumento, Banda banda) {
		this.id = id;
		this.nome = nome;
		this.instrumento = instrumento;
		this.banda = banda;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
}
