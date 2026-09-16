package br.edu.ifrs.bandaalbuns.main;

import br.edu.ifrs.bandaalbuns.dao.AlbumDAO;
import br.edu.ifrs.bandaalbuns.dao.AlbumDAOJPA;
import br.edu.ifrs.bandaalbuns.dao.BandaDAO;
import br.edu.ifrs.bandaalbuns.dao.BandaDAOJPA;
import br.edu.ifrs.bandaalbuns.dominio.Album;
import br.edu.ifrs.bandaalbuns.dominio.Banda;
import br.edu.ifrs.bandaalbuns.dominio.Integrante;
import br.edu.ifrs.bandaalbuns.dominio.Musica;


public class Main {

	public static void main(String[] args) {
		
		 BandaDAO bandaDAO = new BandaDAOJPA();
	     AlbumDAO albumDAO = new AlbumDAOJPA();

	     Banda legiao = new Banda("Legião Urbana", "Rock");
         bandaDAO.salvar(legiao);
         
	     Integrante integrante = new Integrante("Renato Russo", "Vocal");
	     integrante.setBanda(legiao);
	     
         Album dois = new Album("Dois", 1986);
         dois.setBanda(legiao);
	     albumDAO.salvar(dois);

	     Musica tempo = new Musica("Tempo Perdido", 543);
	     tempo.setAlbum(dois);

	     legiao.setGenero("Rock Nacional");
         bandaDAO.atualizar(legiao);
   }
}

