package br.usjt.ads.arqdes.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.ads.arqdes.entity.Filme;
import br.usjt.ads.arqdes.entity.Genero;
import br.usjt.ads.arqdes.service.FilmeService;
import br.usjt.ads.arqdes.service.GeneroService;

@Controller
public class ManterFilmesController {
	private FilmeService fService;
	private GeneroService gService;
	
	public ManterFilmesController() {
		fService = new FilmeService();
		gService = new GeneroService();
	}
	
	@RequestMapping("/")
	public String inicio() {
		return "index";
	}
	
	@RequestMapping("/inicio")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/listar_filmes")
	public String listarFilmes(HttpSession session) {
		session.setAttribute("lista", null);
		return "ListarFilmes";
	}
	
	@RequestMapping("/novo_filme")
	public String novoFilme(HttpSession session) {
		try {
			ArrayList<Genero> generos = gService.listarGeneros();
			session.setAttribute("generos", generos);
			return "CriarFilme";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/inserir_filme")
	public String incluirFilme(Filme filme, Model model) {
		try {
			Genero genero = gService.buscarGenero(filme.getGenero().getId());
			filme.setGenero(genero);
			model.addAttribute("filme", filme);
			fService.inserirFilme(filme);
			return "VisualizarFilme";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "index";
	}

}

























