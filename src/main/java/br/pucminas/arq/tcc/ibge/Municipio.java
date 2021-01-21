package br.pucminas.arq.tcc.ibge;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Municipio implements Serializable{		

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Microrregiao microrregiao;
	@SerializedName("regiao-imediata")
	private RegiaoImediata regiaoImediata;

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
	public Microrregiao getMicrorregiao() {
		return microrregiao;
	}
	public void setMicrorregiao(Microrregiao microrregiao) {
		this.microrregiao = microrregiao;
	}
	public RegiaoImediata getRegiaoImediata() {
		return regiaoImediata;
	}
	public void setRegiaoImediata(RegiaoImediata regiaoImediata) {
		this.regiaoImediata = regiaoImediata;
	}
}
