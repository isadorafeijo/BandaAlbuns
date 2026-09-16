package br.edu.ifrs.bandaalbuns.dao;

import java.util.List;

import br.edu.ifrs.bandaalbuns.dominio.Banda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BandaDAOJPA implements BandaDAO {
	
	private EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("bandaAlbuns-pu");
	
	public void salvar(Banda banda) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(banda);
		em.getTransaction().commit();
		em.close();
	}
	
	public Banda buscarPorId(Long id) {
		EntityManager em = emf.createEntityManager();
		Banda banda = em.find(Banda.class, id);
		em.close();
		
		return banda;
	}
	
	public void atualizar(Banda banda) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(banda);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Banda> listarTodos() {
		EntityManager em = emf.createEntityManager();
		
		List<Banda> bandas = em
				.createQuery("SELECT b FROM Banda b", Banda.class)
				.getResultList();
		em.close();
		
		return bandas;
	}
	
	public List<Banda> listarPorGenero(String genero) {
		EntityManager em = emf.createEntityManager();
		
		List<Banda> bandas = em
				.createQuery("SELECT b FROM Banda b WHERE b.genero = :genero", Banda.class)
				.setParameter("genero", genero)
				.getResultList();
		em.close();
		
		return bandas;
	}
	
	public void remover(Long id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Banda banda = em.find(Banda.class, id);
		em.remove(banda);
		em.getTransaction().commit();
		em.close();
	}
	
	
}