package locadora;

public class Cliente 
{
	private int ID;
	private String nome;
	private int cpf;
	private char genero;
	private Contrato contrato;
	
	public Cliente(int ID, String nome, int cpf, char genero, Contrato contrato)
	{
		this.ID = ID;
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero;
		this.contrato = contrato;
	}
	
	public int getID() {return ID;}

	public void setID(int ID) {this.ID = ID;}

	public String getNome() {return nome;}

	public void setNome(String nome) {this.nome = nome;}

	public int getCpf() {return cpf;}

	public void setCpf(int cpf) {this.cpf = cpf;}

	public char getGenero() {return genero;}

	public void setGenero(char genero) {this.genero = genero;}

	public Contrato getContrato() {return contrato;}

	public void setContrato(Contrato contrato) {this.contrato = contrato;}
}
