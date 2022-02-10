package model;

import javax.validation.constraints.NotEmpty;

public class Categoria {
	private Integer codigo;
	@NotEmpty
	private String nome;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}		
}
