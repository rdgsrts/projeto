package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Filme;
import model.Genero;
import service.FilmeService;
import service.GeneroService;

/**
 * Servlet implementation class ManterFilmesController
 */
@WebServlet("/manterfilmes.do")
public class ManterFilmesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		RequestDispatcher dispatcher;
		FilmeService fService;
		GeneroService gService;
		Filme filme;
		
		switch (acao) {
		case "inserir":
			fService = new FilmeService();
			filme = new Filme();
			filme.setTitulo("O Náufrago");
			filme.setDescricao("WILSOOOOON !!!");
			filme.setDiretor("Robert Zemeckis");

			Genero genero = new Genero();
			genero.setId(18);
			genero.setNome("Drama");
			filme.setGenero(genero);

			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			try {
				filme.setDataLancamento(formatter.parse("2001/01/21"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				filme.setDataLancamento(null);
			}

			filme.setPopularidade(0.0);
			filme.setPosterPath("img/naufrago.jpg");

			filme = fService.inserirFilme(filme);

			request.setAttribute("filme", filme);

			dispatcher = request.getRequestDispatcher("MostrarFilme.jsp");
			dispatcher.forward(request, response);
			break;
		case "generos":
			gService = new GeneroService();
			ArrayList<Genero> generos = gService.listarGeneros();
			request.setAttribute("generos", generos);

			dispatcher = request.getRequestDispatcher("MostrarGeneros.jsp");
			dispatcher.forward(request, response);
			break;
		case "buscar":
			String pId = request.getParameter("id");
			int id = Integer.parseInt(pId);

			fService = new FilmeService();

			filme = fService.buscarFilme(id);
			request.setAttribute("filme", filme);

			dispatcher = request.getRequestDispatcher("MostrarFilme.jsp");
			dispatcher.forward(request, response);
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
