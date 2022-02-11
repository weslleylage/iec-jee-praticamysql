package view;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import dao.CategoriaDAO;
import model.Categoria;

@Named
@ViewScoped
public class CategoriaView implements Serializable {
    private List<Categoria> categorias;
 
    private Categoria categoria = new Categoria();
 
    private CategoriaDAO dao = new CategoriaDAO();
 
    @PostConstruct
    public void init() {
        this.categorias = dao.listar();
    }
 
    public void delete(int codigo) {

        Optional<Categoria> categoria = this.categorias.stream().filter(c -> c.getCodigo() == codigo).findFirst();
        categoria.ifPresent(c -> {
            try {
                dao.deletar(codigo);
                categorias.remove(c);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Categoria deletada com sucesso"));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        });    
    }
 
    public void addUpdate() throws Exception {
        if(this.categoria.getCodigo() != null) {
            dao.editar(categoria);
        }else {
            dao.inserir(categoria);
        }
        this.categorias = dao.listar();
        this.categoria = new Categoria();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Categoria inserida com sucesso" ));
    }
 
    public void update() {
        try {
            dao.editar(categoria);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Categoria atualizada com sucesso"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<Categoria> getCategorias() {
        return this.categorias;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
