package controller.categoria;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.CategoriaService;

@WebServlet(urlPatterns = "/categoria/deletar")
public class DeletarCategoria extends HttpServlet {
	@EJB
    private CategoriaService service;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Integer codigo = Integer.parseInt(request.getParameter("id"));
            service.deletar(codigo);
            response.sendRedirect(request.getContextPath() + "/categoria/listar");
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}
}
