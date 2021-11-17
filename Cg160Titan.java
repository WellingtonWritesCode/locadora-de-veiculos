package locadora;

public class Cg160Titan extends Modelo{

	public Cg160Titan(String tipoDeVeiculo, Double taxaVeiculo, Double taxaDia, Double taxaKM) {
		super(tipoDeVeiculo, taxaVeiculo, taxaDia, taxaKM);
	}

	public Cg160Titan(String tipoDeVeiculo, Double taxaVeiculo) {
		super(tipoDeVeiculo, taxaVeiculo);
		setTaxaDia(null);// Mudar depois ...
		setTaxaKM(null);// Mudar depois ...
	}

	public String toString() {
		return "cg160Titans";
	}
}
