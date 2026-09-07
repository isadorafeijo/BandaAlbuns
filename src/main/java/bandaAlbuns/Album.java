package bandaAlbuns;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	public Album(Long id, String titulo, int ano_lancamento) {
		this.id = id;
		this.titulo = titulo;
		this.ano_lancamento = ano_lancamento;
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
