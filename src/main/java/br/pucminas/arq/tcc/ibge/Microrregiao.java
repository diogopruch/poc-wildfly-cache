package br.pucminas.arq.tcc.ibge;

import java.io.Serializable;

public class Microrregiao  implements Serializable{		

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Mesorregiao mesorregiao;

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
	public Mesorregiao getMesorregiao() {
		return mesorregiao;
	}
	public void setMesorregiao(Mesorregiao mesorregiao) {
		this.mesorregiao = mesorregiao;
	}
}
