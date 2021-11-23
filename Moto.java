package locadora;

public class Moto extends Veiculo{
	
	public static final String TIPO_VEICULO = "Moto";
	
	public Moto(double taxaVeiculo, double taxaKM, double taxaDia, String placa, String modelo) {
		super(taxaVeiculo, taxaKM, taxaDia, placa, modelo);
	}

	public String toString() {
		return null;
	}
	
}
