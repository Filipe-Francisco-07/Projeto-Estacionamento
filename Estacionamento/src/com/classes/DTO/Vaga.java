package com.classes.DTO;

public class Vaga {
	
	private String stats;
	private int codigo;
	private String placa;

	
	public Vaga(String placa, int codigo) {
		if(placa != null)
			setPlaca(placa);
		if(codigo != 0)
			setCodigo(codigo);
	}
	public Vaga(String placa) {
		if(placa != null)
			setPlaca(placa);
	}
	public Vaga(int codigo) {
		if(codigo != 0)
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vaga [stats=");
		builder.append(stats);
		builder.append(", codigo=");
		builder.append(codigo);
		builder.append(", placa=");
		builder.append(placa);
		builder.append("]");
		return builder.toString();
	}
}
