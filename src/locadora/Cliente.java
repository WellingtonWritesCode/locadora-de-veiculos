package locadora;

public class Cliente 
{
	private int ID;
	private String nome;
	private String cpf;
	private char genero;
	private Contrato contrato;
	
	public Cliente(int ID, String nome, float cpf, char genero, Contrato contrato) {
		this.ID = ID;
		this.nome = nome;
		this.cpf = String.format("%.0f", cpf);
		this.genero = genero;
		this.contrato = contrato;
	}
	
	public Cliente(String ID, String nome, String cpf, String genero, Contrato contrato) {
		this.ID = Integer.parseInt(ID);
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero.charAt(0);
		this.contrato = contrato;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
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
	
	public String toString() {
		return this.ID +";"+ this.nome +";"+ this.cpf +";"+ this.genero +";"+ this.contrato.toString();
	}
}
