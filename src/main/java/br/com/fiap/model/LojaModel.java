package br.com.fiap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_LOJA")
public class LojaModel {
	private long id;
	private String nome;
	private String url;
	
	public LojaModel() {
		
	}
	public LojaModel(long id, String nome, String url) {
		this.id = id;
		this.nome = nome;
		this.url = url;
	}
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOJA_SEQ")
	@SequenceGenerator(name = "LOJA_SEQ", sequenceName = "LOJA_SEQ", allocationSize = 1)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "NOME")
	@NotNull(message = "Nome obrigatÃ³rio")
	@Size(min = 2, max = 50, message = "NOME deve ser entre 2 e 50 caracteres")
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name = "URL")
	@NotNull(message = "URL obrigatória")
	@Size(min = 4, max = 50, message = "A URL deve conter entre 4 e 50 caracteres")
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
}
