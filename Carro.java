package locadora;

public class Carro extends Veiculo{
	
	public static final String TIPO_VEICULO = "Carro";
	
	public Carro(double taxaVeiculo, double taxaKM, double taxaDia, String placa, String modelo) {
		super(taxaVeiculo, taxaKM, taxaDia, placa, modelo);
	}

	public String toString() {
		return null;
	}
	
}
