package br.edu.ifrs.bandaalbuns.dominio;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
	private Banda banda;
	
	@OneToMany(mappedBy = "album", cascade = CascadeType.REMOVE)
	private List<Musica> musicas = new ArrayList<>();
	
	public Album() {
	}
	
	public Album(String titulo, int ano_lancamento) {
		this.titulo = titulo;
		this.ano_lancamento = ano_lancamento;
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
	public int getAno_lancamento() {
		return ano_lancamento;
	}
	
	public void setAno_lancamento(int ano_lancamento) {
		this.ano_lancamento = ano_lancamento;
	}
	
	public void setBanda(Banda banda) {
		this.banda = banda;
	}
	
	public void addMusica(Musica musica) {
		this.musicas.add(musica);
		musica.setAlbum(this);
	}

}
