package br.com.app.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Status {

	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id_status;
	   @Column
	   private String nome;
	   
	   public Status() {}
	   
	   public Status(Long id_status, String nome){
		   this.id_status = id_status;
		   this.nome = nome;
	   }
	   
	   public Long getId_status() {
			return id_status;
		}

		public void setId_status(Long id_status) {
			this.id_status = id_status;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
}
