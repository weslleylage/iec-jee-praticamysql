package controller.produto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.ProdutoService;
import model.Produto;

@WebServlet(urlPatterns = {"/produto/index.jsp", "/produto/listar"})
public class ListarProduto extends HttpServlet{
    @EJB
    private ProdutoService service;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codigoCategoria = request.getParameter("codigo_categoria");
		List<Produto> listaProduto;
		try{
			if(codigoCategoria == null){
				listaProduto = service.listar();
			}else{
				Integer codigo = Integer.parseInt(codigoCategoria);
				listaProduto = service.listarPorCategoria(codigo);
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
		request.setAttribute("listaProduto", listaProduto);
		request.setAttribute("contextPath", request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("listarProduto.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		try{
			List<Produto> listaProduto = service.listarPorNome(nome);
			request.setAttribute("listaProduto", listaProduto);
			request.setAttribute("contextPath", request.getContextPath());
			RequestDispatcher dispatcher = request.getRequestDispatcher("listarProduto.jsp");
			dispatcher.forward(request, response);
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}
}