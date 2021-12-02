package locadora;


public class Carro extends Veiculo{
	
	public Carro(double taxaVeiculo, double taxaKm, double taxaDia, String placa, Modelo modelo) {
		super(taxaVeiculo, taxaKm, taxaDia, placa, modelo);
	}

	public String toString() {
		return String.format("Modelo: %s%nPlaca: %s%nTaxa fixa do Veículo: %.2f%nTaxa diária: %.2f%nTaxa por quilômetro: %.2f%n",getModelo(), getPlaca(), getTaxaVeiculo(), getTaxaDia(), getTaxaKm());
	}	
}
