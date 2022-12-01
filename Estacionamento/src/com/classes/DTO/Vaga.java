package com.classes.DTO;

public class Vaga {
	
	private String status;
	private int codigo;
	
	public Vaga(String status, int codigo) {
		setStatus(status);
		setCodigo(codigo);
	}
	public Vaga(String status) {
		setStatus(status);
	}
	public Vaga(int codigo) {
		setCodigo(codigo);
	}
	
	public Vaga() {
		
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vaga [status=");
		builder.append(status);
		builder.append(", codigo=");
		builder.append(codigo);
		builder.append("]");
		return builder.toString();
	}
	
	
}
