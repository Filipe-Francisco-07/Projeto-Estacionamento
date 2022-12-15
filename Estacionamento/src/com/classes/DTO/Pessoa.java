package com.classes.DTO;

public class Pessoa {

	private String nome;
	private String cpf;
	
	public Pessoa(String nome, String cpf) {
		if(nome != null)
			setNome(nome);
		if(cpf != null)
			setCpf(cpf);
	}
	public Pessoa(String cpf) {
		if(cpf != null)
			setCpf(cpf);
	}
	public Pessoa() {

	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pessoa [nome=");
		builder.append(nome);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append("]");
		return builder.toString();
	}
	
	
}
