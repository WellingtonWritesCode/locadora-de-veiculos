package locadora;

public class Cliente 
{
	private int ID;
	private String nome;
	private int cpf;
	private char genero;

	public Cliente(int ID, String nome, int cpf, char genero)
	{
		this.ID = ID;
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero;
	}

	public int getID() {return ID;}

	public void setID(int ID) {this.ID = ID;}

	public String getNome() {return nome;}

	public void setNome(String nome) {this.nome = nome;}

	public int getCpf() {return cpf;}

	public void setCpf(int cpf) {this.cpf = cpf;}

	public char getGenero() {return genero;}

	public void setGenero(char genero) {this.genero = genero;}
}
