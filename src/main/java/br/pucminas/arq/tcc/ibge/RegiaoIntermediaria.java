package br.pucminas.arq.tcc.ibge;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class RegiaoIntermediaria implements Serializable{		

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	@SerializedName("UF")
	private UF uf;
	
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
	public UF getUf() {
		return uf;
	}
	public void setUf(UF uf) {
		this.uf = uf;
	}

}
