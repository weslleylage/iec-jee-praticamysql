package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private int codigo;

	@Column(nullable = false, length = 100)
	private String nome;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "categoria")
	private Set<Produto> produto;
	
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
	public Set<Produto> getProduto() {
		return produto;
	}
	public void setProduto(Set<Produto> produto) {
		this.produto = produto;
	}
}
