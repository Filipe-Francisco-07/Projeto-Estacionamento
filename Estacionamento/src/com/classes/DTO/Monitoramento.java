package com.classes.DTO;


public class Monitoramento {

	private int id;
	private String cpf;
	private String placa;
	private int dataEntrada;
	private int dataSaida;
	private boolean val;
	private double valorTotal;
	private double pagamento;
	double valorHora = 5.00;
	private int n_horas;
	
	public Monitoramento(String cpf, int dataEntrada, boolean val, String placa) {
		setCpf(cpf);
		setDataEntrada(dataEntrada);
		setVal(val);
		setPlaca(placa);
	}
	public Monitoramento(String cpf, String placa, int dataSaida) {
		setCpf(cpf);
		setDataSaida(dataSaida);
		setPlaca(placa);
	}
	public Monitoramento(int dataSaida) {
		setDataSaida(dataSaida);
	}
	public Monitoramento() {
	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(int dataEntrada2) {
		this.dataEntrada = dataEntrada2;
	}
	public int getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(int dataSaida2) {
		this.dataSaida = dataSaida2;
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
	public boolean getVal() {
		return val;
	}

	public void setVal(boolean val2) {
		this.val = val2;
	}
	

	
	public void pagar(Double pagamento) {
		setPagamento(pagamento);
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
		builder.append("]");
		return builder.toString();
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getN_horas() {
		return n_horas;
	}
	public void setN_horas(int n_horas) {
		this.n_horas = n_horas;
	}
	public double getPagamento() {
		return pagamento;
	}
	public void setPagamento(double pagamento) {
		this.pagamento = pagamento;
	}

}
