package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Olimpiada;
import model.Pais;
import service.OlimpiadaService;
import service.PaisService;


/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/buscaPais")
public class PaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomePais = request.getParameter("nomePais");
		int idAno = Integer.parseInt(request.getParameter("idAno"));
		
		
		System.out.println(nomePais);
		System.out.println(idAno);
		
		//instanciar o javabean
		
		Pais pais = new Pais();
		pais.setNome(nomePais);
		
		PaisService ps = new PaisService();
		OlimpiadaService os = new OlimpiadaService();
		
		int total;
		try {
			total = os.getTotalMedalhas(nomePais, idAno);
		} catch (SQLException e) {
			total = 0;
		}
		
		List<Olimpiada> olimpiadas = new ArrayList<>();
		try {
			olimpiadas = os.carregarMedalhasPorModalidade(nomePais, idAno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		pais.setNome(nomePais);
		
		//enviar para o jsp
        request.setAttribute("pais", pais);
        request.setAttribute("total", total);
        request.setAttribute("list", olimpiadas);
        
        RequestDispatcher view = 
        request.getRequestDispatcher("/Medalhas.jsp");
        view.forward(request, response);
		
	}

}
