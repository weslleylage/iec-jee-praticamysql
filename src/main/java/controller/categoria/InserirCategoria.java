package controller.categoria;
import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.CategoriaService;
import model.Categoria;


/**
 * Servlet implementation class InserirCategoria
 */
@WebServlet(urlPatterns = "/categoria/inserir")
public class InserirCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String URL_LIST_CATEGORIA = "/categoria/listar";

	@EJB
	private CategoriaService service;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			  throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		
		Categoria categoria = new Categoria();
		categoria.setNome(nome);

		try {
			service.inserir(categoria);
			response.sendRedirect(request.getContextPath() + URL_LIST_CATEGORIA);
		} catch (Exception ex) {
			ex.printStackTrace();
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<h2> Nao foi possivel inserir a categoria!</h2>");
			out.print("<br />");
			out.print("<a href=" + request.getContextPath() + URL_LIST_CATEGORIA + "> Voltar </a>");
			out.print("</html>");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("inserirCategoria.jsp");
            dispatcher.forward(request, response);
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}
}
