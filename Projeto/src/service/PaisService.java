package service;

import dao.PaisDAO;
import model.Pais;

public class PaisService {
	PaisDAO paisDAO = new PaisDAO();

	public void criar(Pais pais) {
		paisDAO.criar(pais);;
	}

	public void atualizar(Pais pais) {
		paisDAO.atualizar(pais);
	}

	public void excluir(Pais pais) {
		paisDAO.excluir(pais);
	}

	public void carregar(Pais pais) {
		paisDAO.carregar(pais);
	}
	
	public String getNome(int id){
		return paisDAO.getNome(id);
	}
}
