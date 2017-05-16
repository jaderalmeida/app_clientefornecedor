package br.com.app.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ItemPedido {
	
	@Column
	private Long id_pedido;
	@Column 
	private Long id_produto;
	@Column 
	private Integer quant;
	@Column 
	private String observacao;
	@Column
	private float preco_unit;
	
	public ItemPedido() {}
	
	public ItemPedido(Long id_pedido, Long id_produto, Integer quant, String observacao, float preco_unit){
		this.id_pedido = id_pedido;
		this.id_produto = id_produto;
		this.quant = quant;
		this.observacao = observacao;
		this.preco_unit = preco_unit;
	}

	public Long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Long getId_produto() {
		return id_produto;
	}

	public void setId_produto(Long id_produto) {
		this.id_produto = id_produto;
	}

	public Integer getQuant() {
		return quant;
	}

	public void setQuant(Integer quant) {
		this.quant = quant;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public float getPreco_unit() {
		return preco_unit;
	}

	public void setPreco_unit(float preco_unit) {
		this.preco_unit = preco_unit;
	}
	
	
}
