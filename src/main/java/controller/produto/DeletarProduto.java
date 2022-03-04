package controller.produto;
import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.ProdutoService;

@WebServlet(urlPatterns = "/produto/deletar")
public class DeletarProduto extends HttpServlet {
	private static final String URL_LIST_PRODUTO = "/produto/listar";

	@EJB
    private ProdutoService service;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Integer codigo = Integer.parseInt(request.getParameter("id"));
            service.deletar(codigo);
            response.sendRedirect(request.getContextPath() + URL_LIST_PRODUTO);
		} catch (Exception ex) {
			ex.printStackTrace();
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<h2> Nao foi possivel deletar o produto!</h2>");
			out.print("<br />");
			out.print("<a href=" + request.getContextPath() + URL_LIST_PRODUTO + "> Voltar </a>");
			out.print("</html>");
		}
	}
}