package br.edu.ifrs.bandaalbuns.dao;

import java.util.List;

import br.edu.ifrs.bandaalbuns.dominio.Album;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AlbumDAOJPA implements AlbumDAO{

private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bandaAlbuns-pu");
	
	public void salvar(Album album) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(album);
		em.getTransaction().commit();
		em.close();
	}
	
	public Album buscarPorId(Long id) {
		EntityManager em = emf.createEntityManager();
		Album album = em.find(Album.class, id);
		em.close();
		return album;
	}
	
	public List<Album> listarTodos(){
		EntityManager em = emf.createEntityManager();
		List<Album> albuns = em.createQuery("SELECT a from Album a", Album.class).getResultList();
		em.close();
		return albuns;
	}
	public void atualizar(Album album) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(album);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Long id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Album album = em.find(Album.class, id);
		em.remove(album);
		em.getTransaction().commit();
		em.close();
	}
}
