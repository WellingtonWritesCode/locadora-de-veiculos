package locadora;


public class Veiculo{
	
	private double taxaVeiculo;
	private double taxaKM;
	private double taxaDia;
	private String placa;
	private String modelo;
	
	public Veiculo(double taxaVeiculo, double taxaKM, double taxaDia, String placa, String modelo) {
		this.taxaVeiculo = taxaVeiculo;
		this.taxaKM = taxaKM;
		this.taxaDia = taxaDia;
		this.placa = placa;
		this.modelo = modelo;
	}

	public double getTaxaVeiculo() {
		return taxaVeiculo;
	}

	public void setTaxaVeiculo(double taxaVeiculo) {
		this.taxaVeiculo = taxaVeiculo;
	}

	public double getTaxaKM() {
		return taxaKM;
	}

	public void setTaxaKM(double taxaKM) {
		this.taxaKM = taxaKM;
	}

	public double getTaxaDia() {
		return taxaDia;
	}

	public void setTaxaDia(double taxaDia) {
		this.taxaDia = taxaDia;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String toString() {
		return String.format("Modelo: %s%nPlaca: %s%nTaxa fixa do Veículo: %.2f%nTaxa diária: %.2f%nTaxa por quilômetro: %.2f%n",modelo,placa,taxaVeiculo, taxaDia, taxaKM);
	}	
}
