package br.edu.ifrs.bandaalbuns.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private Album album;
	
	public Musica() {
	}
	
	public Musica(String titulo, int duracao) {
		this.titulo = titulo;
		this.duracao = duracao;
	}

	public Long getId() {
		return id;
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
	
	public void setAlbum(Album album) {
		this.album = album;
	}

	@Override
	public String toString() {
		return "Musica [id=" + id + ", titulo=" + titulo + ", duracao=" + duracao + ", album=" + album + "]";
	}
	
	
	
}
