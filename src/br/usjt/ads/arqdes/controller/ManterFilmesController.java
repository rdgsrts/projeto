package br.usjt.ads.arqdes.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.usjt.ads.arqdes.model.entity.Filme;
import br.usjt.ads.arqdes.model.entity.Genero;
import br.usjt.ads.arqdes.model.service.FilmeService;
import br.usjt.ads.arqdes.model.service.GeneroService;

@Controller
public class ManterFilmesController {
	@Autowired
	private FilmeService fService;
	@Autowired
	private GeneroService gService;
	@Autowired
	private ServletContext servletContext;
	
	
	@RequestMapping("/")
	public String inicio() {
		return "index";
	}
	
	@RequestMapping("/inicio")
	public String inicio1() {
		return "index";
	}
	
	@RequestMapping("/listar_filmes")
	public String listarFilmes(HttpSession session){
		session.setAttribute("lista", null);
		return "ListarFilmes";
	}
	
	@RequestMapping("/novo_filme")
	public String novoFilme(HttpSession session) {
		try {
			List<Genero> generos = gService.listarGeneros();
			session.setAttribute("generos", generos);
			return "CriarFilme";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/visualizar_filme")
	public String visualizarFilme(Filme filme, Model model) {
		try {
			filme = fService.buscarFilme(filme.getId());
			model.addAttribute("filme", filme);
			return "VisualizarFilme";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/excluir_filme")
	public String excluirFilme(Filme filme, HttpSession session, Model model) {
		try {
			fService.excluirFilme(filme.getId());
			List<Filme> filmes = (List<Filme>) session.getAttribute("lista");
			session.setAttribute("lista", removerDaLista(filme, filmes));
			return "ListarFilmes";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}
	
	@RequestMapping("/inserir_filme")
	public String inserirFilme(@Valid Filme filme, BindingResult result, Model model, @RequestParam("file") MultipartFile file) {
		try {
			if(!result.hasFieldErrors("titulo")) {
				Genero genero = gService.buscarGenero(filme.getGenero().getId());
				filme.setGenero(genero);
				model.addAttribute("filme", filme);
				filme = fService.inserirFilme(filme);
				fService.gravarImagem(servletContext, filme, file);
				return "redirect:inicio";
			} else {
				return "CriarFilme";
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "index";
	}

	@RequestMapping("/buscar_filmes")
	public String buscarFilmes(HttpSession session, @RequestParam String chave){
		try {
			List<Filme> lista;
			if (chave != null && chave.length() > 0) {
				lista = fService.listarFilmes(chave);
			} else {
				lista = fService.listarFilmes();
			}
			session.setAttribute("lista", lista);
			return "ListarFilmes";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	private List<Filme> removerDaLista(Filme filme, List<Filme> filmes){
		for(int i = 0; i < filmes.size(); i++) {
			if(filme.getId() == filmes.get(i).getId()) {
				filmes.remove(i);
				break;
			}
		}
		return filmes;
	}
	
	private List<Filme> atualizarDaLista(Filme filme, List<Filme> filmes){
		for(int i = 0; i < filmes.size(); i++) {
			if(filme.getId() == filmes.get(i).getId()) {
				filmes.remove(i);
				filmes.add(i, filme);
				break;
			}
		}
		return filmes;
	}
	
	@RequestMapping("/alterar_filme")
	public String atualizar(Filme filme, Model model, HttpSession session) {
		try {
			List<Genero> generos = gService.listarGeneros();
			session.setAttribute("generos", generos);
			filme = fService.buscarFilme(filme.getId());
			model.addAttribute("filme", filme);
			return "AtualizarFilme";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/atualizar_filme")
	public String gravarAtualizacaoFilme(@Valid Filme filme, BindingResult erros, Model model, HttpSession session, @RequestParam("file") MultipartFile file) {
		try {
			if (!erros.hasErrors()) {
				Genero genero = new Genero();
				genero.setId(filme.getGenero().getId());
				genero.setNome(gService.buscarGenero(genero.getId()).getNome());
				filme.setGenero(genero);

				fService.atualizarFilme(filme);
				fService.gravarImagem(servletContext, filme, file);
				model.addAttribute("filme", filme);
				List<Filme> filmes = (List<Filme>) session.getAttribute("lista");
				session.setAttribute("lista", atualizarDaLista(filme, filmes));

				return "VisualizarFilme";
			} else {
				return "AtualizarFilme";
			}
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}
	
	@RequestMapping("/baixar_populares")
	public String baixarFilmesMaisPopulares() {
		try {
			fService.baixarFilmesMaisPopulares();
			return "ListarFilmes";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("/baixar_lancamentos")
	public String baixarLancamentos() {
		try {
			fService.baixarLancamentos();
			return "ListarFilmes";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
}

















