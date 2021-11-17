package locadora;

public class Veiculo{
	
	private String tipoDeVeiculo;
	private Double taxaVeiculo;
	
	public Veiculo(){
	}
	
	public Veiculo(String tipoDeVeiculo, Double taxaVeiculo) {
		this.tipoDeVeiculo = tipoDeVeiculo;
		this.taxaVeiculo = taxaVeiculo;
	}

	public String getTipoDeVeiculo() {
		return tipoDeVeiculo;
	}

	public void setTipoDeVeiculo(String tipoDeVeiculo) {
		this.tipoDeVeiculo = tipoDeVeiculo;
	}

	public Double getTaxaVeiculo() {
		return taxaVeiculo;
	}

	public void setTaxaVeiculo(Double taxaVeiculo) {
		this.taxaVeiculo = taxaVeiculo;
	}
}
