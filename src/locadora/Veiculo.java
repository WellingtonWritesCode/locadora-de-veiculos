package locadora;

public class Veiculo
{
	private double taxaVeiculo;
	private double taxaKm;
	private double taxaDia;
	private String placa;
	private Modelo modelo;
	
	public Veiculo(double taxaVeiculo, double taxaKm, double taxaDia, String placa, Modelo modelo) {
		this.taxaVeiculo = taxaVeiculo;
		this.taxaKm = taxaKm;
		this.taxaDia = taxaDia;
		this.placa = placa;
		this.modelo = modelo;
	}
	
	public Veiculo(String taxaVeiculo, String taxaKm, String taxaDia, String placa, String modelo) {
		this.taxaVeiculo = Double.parseDouble(taxaVeiculo);
		this.taxaKm = Double.parseDouble(taxaKm);
		this.taxaDia = Double.parseDouble(taxaDia);
		this.placa = placa;
		this.modelo = Modelo.valueOf(modelo);
	}

	public double getTaxaVeiculo() {
		return taxaVeiculo;
	}

	public void setTaxaVeiculo(double taxaVeiculo) {
		this.taxaVeiculo = taxaVeiculo;
	}

	public double getTaxaKm() {
		return taxaKm;
	}

	public void setTaxaKm(double taxaKm) {
		this.taxaKm = taxaKm;
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

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
	public String toString() {
		return this.placa +";"+ this.taxaDia +";"+ this.taxaKm +";"+ this.taxaVeiculo +";"+ this.modelo;
	}	
}
