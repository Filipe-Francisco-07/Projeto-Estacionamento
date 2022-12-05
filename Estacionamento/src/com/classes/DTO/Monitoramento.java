package com.classes.DTO;
import java.util.Date;

public class Monitoramento {

	private int id;
	private Date dataEntrada;
	private Date dataSaida;
	private double valorTotal;
	private double valorHora;
	private Veiculo veiculo;
	private boolean valet;
	
	public Monitoramento(int id, Date dataEntrada, Date dataSaida, double valorTotal, double valorHora, Veiculo veiculo, boolean valet) {
		setId(id);
		setDataEntrada(dataEntrada);
		setDataSaida(dataSaida);
		setValorTotal(valorTotal);
		setValorHora(valorHora);
		setVeiculo(veiculo);
		setValet(valet);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public Date getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public double getValorHora() {
		return valorHora;
	}
	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public boolean isValet() {
		return valet;
	}
	public void setValet(boolean valet) {
		this.valet = valet;
	}
	
	public void adicionarVeiculo() {
		
		
		
	}
	
	public void retirarVeiculo() {
		
		
		
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Monitoramento [id=");
		builder.append(id);
		builder.append(", dataEntrada=");
		builder.append(dataEntrada);
		builder.append(", dataSaida=");
		builder.append(dataSaida);
		builder.append(", valorTotal=");
		builder.append(valorTotal);
		builder.append(", valorHora=");
		builder.append(valorHora);
		builder.append(", veiculo=");
		builder.append(veiculo);
		builder.append(", valet=");
		builder.append(valet);
		builder.append("]");
		return builder.toString();
	}
	
	
}
