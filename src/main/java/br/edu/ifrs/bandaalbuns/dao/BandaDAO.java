package br.edu.ifrs.bandaalbuns.dao;

import java.util.List;

import br.edu.ifrs.bandaalbuns.dominio.Banda;

public interface BandaDAO {

	void salvar(Banda banda);
	Banda buscarPorId(Long id);
	List<Banda> listarTodos();
	List<Banda> listarPorGenero(String genero);
	void atualizar(Banda banda);
	void remover(Long id);
}
