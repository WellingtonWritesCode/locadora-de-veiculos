package locadora;

public class Veiculo
{
	private String placa;
	private double taxaDia;
	private double taxaKm;
	private double taxaVeiculo;
	private Modelo modelo;
	
	public Veiculo(String placa, double taxaDia, double taxaKm, double taxaVeiculo, Modelo modelo) {
		this.placa = placa;
		this.taxaDia = taxaDia;
		this.taxaKm = taxaKm;
		this.taxaVeiculo = taxaVeiculo;
		this.modelo = modelo;
	}
	
	/**
	 * Construtor da classe usando somente Strings, usado em conjunção ao
	 * {@link locadora.Contrato#Contrato(Veiculo, String, String, String) Contrato(Veiculo, String, String, String)}
	 */
	public Veiculo(String placa, String taxaDia, String taxaKm, String taxaVeiculo, String modelo) {
		this.placa = placa;
		this.taxaDia = Double.parseDouble(taxaDia);
		this.taxaKm = Double.parseDouble(taxaKm);
		this.taxaVeiculo = Double.parseDouble(taxaVeiculo);
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
	
	/**
	 * @return String com todos os dados do objeto
	 */
	public String toString() {
		return this.placa +";"+ this.taxaDia +";"+ this.taxaKm +";"+ this.taxaVeiculo +";"+ this.modelo;
	}	
}
