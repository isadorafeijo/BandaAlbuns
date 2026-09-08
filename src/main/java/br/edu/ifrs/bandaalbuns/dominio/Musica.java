package br.edu.ifrs.bandaalbuns.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Musica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String titulo;
	private int duracao;
	
	@ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;
	
	public Musica() {
	}
	
	public Musica(Long id, String titulo, int duracao, Album album) {
		this.id = id;
		this.titulo = titulo;
		this.duracao = duracao;
		this.album = album;
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

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	
	
}
