package br.usjt.ads.arqdes.service;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.ads.arqdes.dao.GeneroDAO;
import br.usjt.ads.arqdes.entity.Genero;

public class GeneroService {
	private GeneroDAO dao;
	
	public GeneroService() {
		this.dao = new GeneroDAO();
	}
	
	public Genero buscarGenero(int id) throws IOException {
		return dao.buscarGenero(id);
	}
	
	public ArrayList<Genero> listarGeneros() throws IOException{
		return dao.listarGeneros();
	}

}
