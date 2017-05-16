package br.com.app.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProdutoUsuario {
	
	@Column
	private Integer quantidade;
	@Id
	private Long id_usu;
	@Column
	private Long id_produto;
	
	public ProdutoUsuario() {}
	
	public ProdutoUsuario(Integer quant, Long id_usu, Long id_produto){
		this.quantidade = quant;
		this.id_usu = id_usu;
		this.id_produto = id_produto;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Long getId_usu() {
		return id_usu;
	}

	public void setId_usu(Long id_usu) {
		this.id_usu = id_usu;
	}

	public Long getId_produto() {
		return id_produto;
	}

	public void setId_produto(Long id_produto) {
		this.id_produto = id_produto;
	}
}
