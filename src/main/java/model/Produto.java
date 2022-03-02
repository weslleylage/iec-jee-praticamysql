package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;

    @Column(length = 100)
	private String nome;

    private float preco;

    @ManyToOne
    @JoinColumn(name = "codigo_categoria")
    private Categoria categoria;

	public int getCodigo() {
		return this.codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
    public float getPreco() {
		return this.preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public Categoria getCategoria() {
		return this.categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
