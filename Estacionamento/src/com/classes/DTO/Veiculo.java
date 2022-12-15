package com.classes.DTO;

public class Veiculo {

	private String placa;
	private String cor;
	private String modelo;
	private int n_rodas;
	private String cpf;
	
	public Veiculo(String placa, String cor, String modelo, int n_rodas, String cpf) {
		if(placa != null)
			setPlaca(placa);
		if(cor != null)
			setCor(cor);
		if(modelo != null)
			setModelo(modelo);
		if(n_rodas != 0)
			setN_rodas(n_rodas);
		if(cpf != null)
			setCpf(cpf);
	}
	public Veiculo(String placa) {
		if(placa != null)
			setPlaca(placa);
	}

	public Veiculo() {

	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getN_rodas() {
		return n_rodas;
	}

	public void setN_rodas(int n_rodas) {
		this.n_rodas = n_rodas;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Veiculo [cor=");
		builder.append(cor);
		builder.append(", placa=");
		builder.append(placa);
		builder.append(", modelo=");
		builder.append(modelo);
		builder.append(", n_rodas=");
		builder.append(n_rodas);
		builder.append("]");
		return builder.toString();
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
