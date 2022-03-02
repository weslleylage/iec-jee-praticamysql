package repository;

import java.util.List;

import model.Produto;

public interface ProdutoRepository {
    
    void inserir(Produto produto);

    void editar(Produto produto) throws Exception;

    void deletar(int codigo) throws Exception;
    
    List<Produto> listar();

    Produto listarPorCodigo(int id) throws Exception;

    List<Produto> listarPorNome(String nome) throws Exception;

    List<Produto> listarPorCategoria(int codigoCategoria) throws Exception;
}