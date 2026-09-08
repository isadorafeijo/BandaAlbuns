package br.edu.ifrs.bandaalbuns.dominio;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Banda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String genero;
	
	@OneToMany(mappedBy = "banda")
	private List<Album> albuns = new ArrayList<>();
	
	@OneToMany(mappedBy = "banda")
	private List<Integrante> integrantes = new ArrayList<>();
	
	public Banda() {
	}
	
	public Banda(Long id, String nome, String genero) {
		this.id = id;
		this.nome = nome;
		this.genero = genero;
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
}
