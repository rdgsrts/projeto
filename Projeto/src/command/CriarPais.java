package command;

import java.io.IOException;

import javax.activation.DataHandler;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisService;

public class CriarPais implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String pNome = request.getParameter("nome");
		double pArea = Double.parseDouble(request.getParameter("Área"));
		long pPopulacao = Long.parseLong( request.getParameter("Populacão"));

		Pais pais = new Pais();
		pais.setNome(pNome);
		pais.setArea(pArea);
		pais.setPopulacao(pPopulacao);

		//instanciar o service
		PaisService ps = new PaisService();
		ps.criar(pais);
		pais = ps.carregar(pais.getId());

		//enviar para o jsp
		request.setAttribute("Pais", pais);

		RequestDispatcher view =
		request.getRequestDispatcher("Pais.jsp");
		view.forward(request, response);
	}

	@Override
	public void setCommandContext(String verb, DataHandler dh) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
