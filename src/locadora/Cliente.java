package locadora;

public class Cliente 
{
	private String nome;
	private String cpf;
	private char genero;
	private Contrato contrato;
	
	/**
	 * Construtor da classe
	 */
	public Cliente(String nome, float cpf, char genero, Contrato contrato) {
		this.nome = nome;
		this.cpf = String.format("%.0f", cpf);
		this.genero = genero;
		this.contrato = contrato;
	}
	
	/**
	 * Construtor da classe usando somente Strings, usado para facilitar o carregamento de dados.
	 * @see locadora.Contrato#Contrato(Veiculo, String, String, String)
	 */
	public Cliente(String nome, String cpf, String genero, Contrato contrato) {
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero.charAt(0);
		this.contrato = contrato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	
	/**
	 * @return String com todos os dados do objeto
	 */
	public String toString() {
		return this.nome +";"+ this.cpf +";"+ this.genero +";"+ this.contrato.toString();
	}
}
