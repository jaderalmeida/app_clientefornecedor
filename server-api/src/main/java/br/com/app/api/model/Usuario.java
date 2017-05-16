package br.com.app.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usu;
	@Column
	private String nome;
    @Column
    private String login;
    @Column
    private Integer tipo;
    
    public Usuario() {}
    
    public Usuario(Long id_usu, String nome, String login, Integer tipo) {
    	this.id_usu = id_usu;
    	this.nome = nome;
    	this.login = login;
    	this.tipo = tipo;
    }

    public Long getId_usu() {
		return id_usu;
	}

	public void setId_usu(Long id_usu) {
		this.id_usu = id_usu;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
    
}
