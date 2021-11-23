package locadora;

public class Caminhao extends Veiculo{
	
	public static final String TIPO_VEICULO = "Caminhão";
	
	public Caminhao(double taxaVeiculo, double taxaKM, double taxaDia, String placa, String modelo) {
		super(taxaVeiculo, taxaKM, taxaDia, placa, modelo);
	}
	
	public String toString() {
		return null;
	}
	
}
