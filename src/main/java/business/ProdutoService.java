package business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import model.Produto;
import repository.ProdutoRepository;
import repository.RepositorySession;

@Stateless
public class ProdutoService {

    @EJB
    private RepositorySession repository;
    private ProdutoRepository produtoRepository;

    @PostConstruct
    public void initialize() {
        produtoRepository = repository.getProdutoRepository();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void inserir(Produto timesheet) {
        produtoRepository.inserir(timesheet);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void editar(Produto produto) throws Exception {
        produtoRepository.editar(produto);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deletar(int codigo) throws Exception {
        produtoRepository.deletar(codigo);
    }

    public List<Produto> listar() {
        return produtoRepository.listar();
    }

    public Produto listarPorCodigo(int codigo) throws Exception {
        return produtoRepository.listarPorCodigo(codigo);
    }

    public List<Produto> listarPorNome(String nome) throws Exception {
        return produtoRepository.listarPorNome(nome);
    }

    public List<Produto> listarPorCategoria(int codigoCategoria) throws Exception {
        return produtoRepository.listarPorCategoria(codigoCategoria);
    }
}
