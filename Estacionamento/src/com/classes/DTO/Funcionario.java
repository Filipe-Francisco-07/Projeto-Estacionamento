package com.classes.DTO;

public class Funcionario extends Pessoa {
	
	private String nome;
	private String cpf;
	private double salario;
	
	public Funcionario(String nome, String cpf) {
		if(nome != null)
			setNome(nome);
		if(cpf != null)
			setCpf(cpf);
	}
	public Funcionario(double salario) {
		if(salario != 0)
			setSalario(salario);
	}
	
	public Funcionario(String cpf) {
		if(cpf != null)
			setCpf(cpf);
	}
	public Funcionario() {

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
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Funcionario [nome=");
		builder.append(nome);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append(", salario=");
		builder.append(salario);
		builder.append("]");
		return builder.toString();
	}
	
}
