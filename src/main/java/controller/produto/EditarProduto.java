package controller.produto;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.CategoriaService;
import business.ProdutoService;
import model.Produto;
import model.Categoria;

@WebServlet(urlPatterns = "/produto/editar")
public class EditarProduto extends HttpServlet {
    private static final String URL_LIST_PRODUTO = "/produto/listar";

    @EJB
    private CategoriaService categoriaService;

    @EJB
    private ProdutoService produtoService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Integer codigo = Integer.parseInt(request.getParameter("id"));
            Produto produto = produtoService.listarPorCodigo(codigo);
            if(produto == null) {
                PrintWriter out = response.getWriter();
                out.print("<html>");
                out.print("<h2> Nao foi possivel localizar o produto de codigo " + codigo + "</h2>");
                out.print("<br />");
                out.print("<a href=" + request.getContextPath() + URL_LIST_PRODUTO + "> Voltar </a>");
                out.print("</html>");
            }else {
                List<Categoria> listaCategoria = categoriaService.listar();
                request.setAttribute("listaCategoria", listaCategoria);
                request.setAttribute("produto", produto);
                RequestDispatcher dispatcher = request.getRequestDispatcher("editarProduto.jsp");
                dispatcher.forward(request, response);
            }
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Produto produto = new Produto();
        Integer codigo = Integer.parseInt(request.getParameter("codigo"));
        String nome = request.getParameter("nome");
        Float preco = Float.parseFloat(request.getParameter("preco"));
        Integer codigoCategoria = Integer.parseInt(request.getParameter("codigo_categoria"));
        produto.setCodigo(codigo);
        produto.setNome(nome);
		produto.setPreco(preco);

        try {
            Categoria categoria = categoriaService.porCodigo(codigoCategoria);
            produto.setCategoria(categoria);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            produtoService.editar(produto);
            response.sendRedirect(request.getContextPath() + URL_LIST_PRODUTO);
        } catch (Exception ex) {
            ex.printStackTrace();
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<h2> Nao foi possivel editar o produto!</h2>");
			out.print("<br />");
			out.print("<a href=" + request.getContextPath() + URL_LIST_PRODUTO + "> Voltar </a>");
			out.print("</html>");
        }
    } 

}