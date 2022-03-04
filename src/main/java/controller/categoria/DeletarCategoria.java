package controller.categoria;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.CategoriaService;

@WebServlet(urlPatterns = "/categoria/deletar")
public class DeletarCategoria extends HttpServlet {
	private static final String URL_LIST_CATEGORIA = "/categoria/listar";

	@EJB
    private CategoriaService service;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Integer codigo = Integer.parseInt(request.getParameter("id"));
            service.deletar(codigo);
            response.sendRedirect(request.getContextPath() + URL_LIST_CATEGORIA);
		} catch (Exception ex) {
			ex.printStackTrace();
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<h2> Nao foi possivel deletar a categoria!</h2>");
			out.print("<br />");
			out.print("<a href=" + request.getContextPath() + URL_LIST_CATEGORIA + "> Voltar </a>");
			out.print("</html>");
		}
	}
}
