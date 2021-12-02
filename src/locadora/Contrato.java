package locadora;
public class Contrato {

	private Veiculo veiculo;
	private int dias;
	private double kmInicial;
	private double kmFinal;

	public Contrato(Veiculo veiculo, int dias, double kmInicial, double kmFinal) {
		this.veiculo = veiculo;
		this.dias = dias;
		this.kmInicial = kmInicial;
		this.kmFinal = kmFinal;
	}
	
	public Contrato(Veiculo veiculo, String dias, String kmInicial, String kmFinal) {
		this.veiculo = veiculo;
		this.dias = Integer.parseInt(dias);
		this.kmInicial = Double.parseDouble(kmInicial);
		this.kmFinal = Double.parseDouble(kmFinal);
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public double getKmInicial() {
		return kmInicial;
	}

	public void setKmInicial(double kmInicial) {
		this.kmInicial = kmInicial;
	}

	public double getKmFinal() {
		return kmFinal;
	}

	public void setKmFinal(double kmFinal) {
		this.kmFinal = kmFinal;
	}

	public double valorKm() {
		return (kmFinal - kmInicial) * veiculo.getTaxaKm();
	}

	public double custoDias() {
		return dias * veiculo.getTaxaDia();
	}

	public double custoTotal() {
		return custoDias() + veiculo.getTaxaVeiculo() + valorKm();
	}

	public String toString() {
		return this.veiculo.toString() +";"+ this.dias +";"+ this.kmInicial +";"+ this.kmFinal;
	}
}
