package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.OlimpiadaDAO;
import model.Olimpiada;

public class OlimpiadaService {
	OlimpiadaDAO olimpiadaDao = new OlimpiadaDAO();
	
	public void criar(Olimpiada olimpiada) throws SQLException {
		olimpiadaDao.criar(olimpiada);
	}

	public void atualizar(Olimpiada olimpiada) throws SQLException {
		olimpiadaDao.atualizar(olimpiada);
	}

	public void excluir(Olimpiada olimpiada) throws SQLException {
		olimpiadaDao.excluir(olimpiada);
	}

	public void carregar(Olimpiada olimpiada) throws SQLException {
		olimpiadaDao.carregar(olimpiada);
	}
	
	public int getTotalMedalhas(String nome, int idAno) throws SQLException {
		return olimpiadaDao.getTotalMedalhas(nome, idAno);
	}

	public List<Olimpiada> carregarMedalhasPorModalidade(String nome, int idAno) throws SQLException {
		return olimpiadaDao.carregarMedalhasPorModalidade(nome, idAno);
	}
}
