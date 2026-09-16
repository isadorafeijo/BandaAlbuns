package br.edu.ifrs.bandaalbuns.dao;

import java.util.List;

import br.edu.ifrs.bandaalbuns.dominio.Album;

public interface AlbumDAO {

	void salvar(Album album);
	Album buscarPorId(Long id);
	List<Album> listarTodos();
	void atualizar(Album album);
	void remove(Long Id);
}
