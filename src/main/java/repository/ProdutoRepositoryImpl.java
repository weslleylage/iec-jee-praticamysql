package repository;

import java.util.List;

import javax.persistence.EntityManager;

import model.Produto;

public class ProdutoRepositoryImpl implements ProdutoRepository {
    private EntityManager em;
    public ProdutoRepository setEntityManager(EntityManager em) {
        this.em = em;
        return this;
    }

    @Override
    public void inserir(Produto produto) {
        em.persist(produto);
    }

    @Override
    public void editar(Produto produto) throws Exception  {
        em.merge(produto);
    }

    @Override
    public void deletar(int codigo) throws Exception  {
        var produto = em.find(Produto.class, codigo);
        em.remove(produto);
    }

    @Override
    public List<Produto> listar() {
        return em.createQuery("select p from Produto p", Produto.class)
            .getResultList();
    }

    @Override
    public Produto listarPorCodigo(int id) throws Exception {
        return em.find(Produto.class, id);
    }

    @Override
    public List<Produto> listarPorNome(String nome) throws Exception {
        return em.createQuery("select p from Produto p where p.nome like :nome", Produto.class)
            .setParameter("nome", nome + "%")
            .getResultList();
    }

    @Override
    public List<Produto> listarPorCategoria(int codigoCategoria) throws Exception {
        return em.createQuery("select p from Produto p where p.categoria.codigo = :codigoCategoria", Produto.class)
            .setParameter("codigoCategoria", codigoCategoria)
            .getResultList();
    }
}