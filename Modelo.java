package locadora;

public class Modelo extends Veiculo{
	
	private Double taxaDia;
	private Double taxaKM;

	public Modelo(String tipoDeVeiculo, Double taxaVeiculo) {
		super(tipoDeVeiculo, taxaVeiculo);
	}
	
	public Modelo(String tipoDeVeiculo, Double taxaVeiculo, Double taxaDia, Double taxaKM) {
		super(tipoDeVeiculo, taxaVeiculo);
		this.taxaDia = taxaDia;
		this.taxaKM = taxaKM;
	}

	public Double getTaxaDia() {
		return taxaDia;
	}

	public void setTaxaDia(Double taxaDia) {
		this.taxaDia = taxaDia;
	}

	public Double getTaxaKM() {
		return taxaKM;
	}

	public void setTaxaKM(Double taxaKM) {
		this.taxaKM = taxaKM;
	}
}
