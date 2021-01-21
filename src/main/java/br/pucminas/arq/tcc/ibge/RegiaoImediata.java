package br.pucminas.arq.tcc.ibge;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class RegiaoImediata implements Serializable{		

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	@SerializedName("regiao-intermediaria")
	private RegiaoIntermediaria regiaoIntermediaria;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public RegiaoIntermediaria getRegiaoIntermediaria() {
		return regiaoIntermediaria;
	}
	public void setRegiaoIntermediaria(RegiaoIntermediaria regiaoIntermediaria) {
		this.regiaoIntermediaria = regiaoIntermediaria;
	}
}
