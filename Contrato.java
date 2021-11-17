package locadora;

public class Contrato {
	
	private Modelo modelo;
	private int dias; //O jeito de pegar/contar os dias pode ser sujeito à mudança
	private double kM;

	public Contrato(Modelo modelo, int dias, double kM) {
		this.modelo = modelo;
		this.dias = dias;
		this.kM = kM;
	}
	
	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public double getkM() {
		return kM;
	}

	public void setkM(double kM) {
		this.kM = kM;
	}

	public double valorKM() {
		return kM * modelo.getTaxaKM();
	}
	
	public double custoDias() {
		return dias * modelo.getTaxaDia();
	}
	
	public double custoTotal() {
		return custoDias() + modelo.getTaxaVeiculo() + valorKM();
	}
	
	public String toString() {
		return String.format("O valor a ser pago: %.2f + %.2f = %.2f", custoDias(), valorKM(), custoTotal());
	}	
}
