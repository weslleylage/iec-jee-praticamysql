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

@WebServlet(urlPatterns = "/categoria/editar")
public class EditarCategoria extends HttpServlet {
    private static final String URL_LIST_CATEGORIA = "/categoria/listar";

    @EJB
    private CategoriaService service;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Integer codigo = Integer.parseInt(request.getParameter("id"));
            Categoria categoria = service.porCodigo(codigo);
            if(categoria == null) {
                PrintWriter out = response.getWriter();
                out.print("<html>");
                out.print("<h2> Nao foi possivel localizar a categoria de codigo " + codigo + "</h2>");
                out.print("<br />");
                out.print("<a href=" + request.getContextPath() + URL_LIST_CATEGORIA + "> Voltar </a>");
                out.print("</html>");
            }else {
                request.setAttribute("categoria", categoria);
                RequestDispatcher dispatcher = request.getRequestDispatcher("editarCategoria.jsp");
                dispatcher.forward(request, response);
            }
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer codigo = Integer.parseInt(request.getParameter("codigo"));
        String nome = request.getParameter("nome");
        try {
            Categoria categoria = new Categoria();
            categoria.setCodigo(codigo);
            categoria.setNome(nome);
            service.editar(categoria);
            response.sendRedirect(request.getContextPath() + URL_LIST_CATEGORIA);
        } catch (Exception ex) {
            ex.printStackTrace();
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<h2> Nao foi possivel editar a categoria!</h2>");
			out.print("<br />");
			out.print("<a href=" + request.getContextPath() + URL_LIST_CATEGORIA + "> Voltar </a>");
			out.print("</html>");
        }
    } 

}
