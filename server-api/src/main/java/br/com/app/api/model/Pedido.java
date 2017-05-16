package br.com.app.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pedido {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id_pedido;
	 @Column 
	 private Long id_status;
	 @Column 
	 private Long id_cliente;
	 @Column
	 private Long id_fornecedor;
	 
	 public Pedido() {}
	 
	 public Pedido(Long id_pedido, Long id_status, Long id_cliente, Long id_fornecedor){
		 this.id_pedido = id_pedido;
		 this.id_status = id_status;
		 this.id_cliente = id_cliente;
		 this.id_fornecedor = id_fornecedor;
	 }

	public Long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Long getId_status() {
		return id_status;
	}

	public void setId_status(Long id_status) {
		this.id_status = id_status;
	}

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Long getId_fornecedor() {
		return id_fornecedor;
	}

	public void setId_fornecedor(Long id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}
	 
}
