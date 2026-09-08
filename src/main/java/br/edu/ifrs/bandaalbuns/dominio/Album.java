package br.edu.ifrs.bandaalbuns.dominio;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String titulo;
	private int ano_lancamento;
	
	@ManyToOne
	@JoinColumn(name = "banda_id")
	private Banda banda;
	
	@OneToMany(mappedBy = "album")
	private List<Musica> musicas = new ArrayList<>();
	
	public Album() {
	}
	
	public Album(Long id, String titulo, int ano_lancamento, Banda banda) {
		this.id = id;
		this.titulo = titulo;
		this.ano_lancamento = ano_lancamento;
		this.banda = banda;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAno_lancamento() {
		return ano_lancamento;
	}
	public void setAno_lancamento(int ano_lancamento) {
		this.ano_lancamento = ano_lancamento;
	}
	
	
}
