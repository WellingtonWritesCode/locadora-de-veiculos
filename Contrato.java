package locadora;

public class Contrato {
	
	private Veiculo veiculo;
	private int dias; //O jeito de pegar/contar os dias pode ser sujeito à mudança
	private double kM;

	public Contrato(Veiculo veiculo, int dias, double kM) {
		this.veiculo = veiculo;
		this.dias = dias;
		this.kM = kM;
	}
	
	

	public double valorKM() {
		return kM * veiculo.getTaxaKM();
	}
	
	public double custoDias() {
		return dias * veiculo.getTaxaDia();
	}
	
	public double custoTotal() {
		return custoDias() + veiculo.getTaxaVeiculo() + valorKM();
	}
	
	public String toString() {
		return String.format("O valor a ser pago: %.2f + %.2f = %.2f", custoDias(), valorKM(), custoTotal());
	}	
}
