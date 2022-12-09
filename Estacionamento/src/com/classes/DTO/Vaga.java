package com.classes.DTO;

public class Vaga {
	
	private String stats;
	private int codigo;
	private String placa;

	
	public Vaga(String placa, int codigo) {
		setPlaca(placa);
		setCodigo(codigo);
	}
	public Vaga(String placa) {
		
		setPlaca(placa);
	}
	public Vaga(int codigo) {
		setCodigo(codigo);
	}
	
	public Vaga() {
		
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
		builder.append(stats);
		builder.append(", codigo=");
		builder.append(codigo);
		builder.append("]");
		return builder.toString();
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getStats() {
		return stats;
	}
	public void setStats(String stats) {
		this.stats = stats;
	}

	
	
	
}
