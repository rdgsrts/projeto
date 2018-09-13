package service;

import java.io.IOException;

import dao.FilmeDAO;
import model.Filme;

public class FilmeService {
	private FilmeDAO dao;
	
	public FilmeService() {
		dao = new FilmeDAO();
	}
	
	public Filme buscarFilme(int id) throws IOException
	{
		return dao.buscarFilme(id);
	}
	
	public Filme inserirFilme(Filme filme) throws IOException 
	{
		int id = dao.inserirFilme(filme);
		filme.setId(id);
		return filme;
	}

	/* inicio
	public Filme atualizarDadosFilme()
	{
		Teremos um TODO aqui porém ainda nem li o código
	}

	public Filme excluirFile()
	{
		Teremos um TODO aqui porém ainda nem li o código
	}

	FIM*/

}
