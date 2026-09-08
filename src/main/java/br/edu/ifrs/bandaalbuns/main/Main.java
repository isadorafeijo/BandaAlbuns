package br.edu.ifrs.bandaalbuns.main;

import br.edu.ifrs.bandaalbuns.dao.BandaDAO;
import br.edu.ifrs.bandaalbuns.dao.BandaDAOJPA;
import br.edu.ifrs.bandaalbuns.dominio.Album;
import br.edu.ifrs.bandaalbuns.dominio.Banda;
import br.edu.ifrs.bandaalbuns.dominio.Integrante;
import br.edu.ifrs.bandaalbuns.dominio.Musica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		
		BandaDAO bandaDAO = new BandaDAOJPA();
		
		Banda legiao = new Banda(null, "Legião Urbana", "Rock");
		bandaDAO.salvar(legiao);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("banda-albuns-pu");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Integrante renato = new Integrante(null, "Renato Russo", "Vocal", legiao);
		em.persist(renato);
		
		Album dois = new Album(null, "Dois", 1986, legiao);
		em.persist(dois);
		
		Musica tempo = new Musica(null, "Tempo Perdido", 543, dois);
		em.persist(tempo);
		
		em.getTransaction().commit();
		em.close();
		
		legiao.setGenero("Rock Nacional");
		bandaDAO.atualizar(legiao);

	}

}
