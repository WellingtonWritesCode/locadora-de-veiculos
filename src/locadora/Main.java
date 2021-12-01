package locadora;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Main {
	public static int selecionarPag(int totalPag, Scanner entrada)
	{
		boolean entradaValida = false;
		int temp = 1;
		System.out.println("Digite a página que deseja ver:\n");
		do 
		{
			try 
			{
				temp = entrada.nextInt();
				if(temp <= totalPag && temp > 0)entradaValida = true;
			}catch(Exception e)
			{
				entradaValida = false;
			}
			if(!entradaValida) System.out.println("Valor inválido, digite um número de 0 à " + totalPag);
		}while(!entradaValida);
		return temp;
	}
	public static void printPg(int pagina, ArrayList<Cliente> clientes)
	{
		try
		{
			for(int i = 0; i < 3; i++)
			{
				Cliente j = clientes.get((pagina-1)*3 + i);
				System.out.println(j.getNome() + ", " + j.getGenero() + "\n"
								 + "ID: " + j.getID() + "Cpf: " + j.getCpf() + "\n"
								 //TODO adicionar informações do contrato
								 + "------------------------------------------");
			}
		}
		catch (IndexOutOfBoundsException e)
		{
			return;
		}
	}

    public static void main(String [] args)
    {
    	//TODO adicionar leitura e escrita de arquivos
        boolean aberto = true;
        boolean visualizandoBancoDados = false;
        Scanner entrada = new Scanner(System.in);
        int opcao;
        int pagAtual = 1;
        int totalPag;
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        
        while(aberto)
        {
        	totalPag = (int)Math.ceil(clientes.size()/3.0);
        	System.out.println("1- Adicionar entrada.\n"
        					 + "2- Remover Entrada.\n"
        					 + "3- Editar entrada.\n"
        					 + "4- Visualizar banco de dados.\n"
        					 + "5- Sair");
        	opcao = entrada.nextInt();
        	
        	switch(opcao) 
        	{
        	case 1:
        		break;
        	case 2:
        		break;
        	case 3:
        		break;
        	case 4:
        		visualizandoBancoDados = true;
        		break;
        	case 5:
        		aberto = false;
        		break;
        	default:
        		System.out.println("Digite um valor inteiro de 1 a 5");
        		break;
        	}
        	
        	
        	if(visualizandoBancoDados && clientes.size() == 0)
        	{
        		System.out.println("Banco de dados vazio.\n");
        		visualizandoBancoDados = false;
        	}
        	while(visualizandoBancoDados) 
        	{
        		printPg(pagAtual, clientes);
        		System.out.println("Pag " + pagAtual + "/" + totalPag);
        		if(totalPag == 1)
        		{
        			System.out.println();
        			visualizandoBancoDados = false;
        		}
        		else if(pagAtual == 1) 
        		{
        			System.out.println("1- Próxima Página\n"
   						 			 + "2- Selecionar Página\n"
   						 			 + "3- Voltar ao menu principal");
        			opcao = entrada.nextInt();
        			switch(opcao)
        			{
        			case 1:
        				pagAtual++;
        				break;
        			case 2:
        				pagAtual = selecionarPag(totalPag, entrada);
        				break;
        			case 3:
        				visualizandoBancoDados = false;
        				break;
        			default:
        				System.out.println("Digite 1, 2 ou 3.");
        				break;
        			}
        		}
        		else if(pagAtual == totalPag) 
        		{
        			System.out.println("1- Página Anterior\n"
					 			 	 + "2- Selecionar Página\n"
					 			 	 + "3- Voltar ao menu principal");
        			opcao = entrada.nextInt();
        			switch(opcao)
        			{
        			case 1:
        				pagAtual--;
        				break;
        			case 2:
        				pagAtual = selecionarPag(totalPag, entrada);
        				break;
        			case 3:
        				visualizandoBancoDados = false;
        				break;
        			default:
        				System.out.println("Digite 1, 2 ou 3.");
        				break;
        			}
        			
        		}
        		else 
        		{
        			System.out.println("1- Próxima Página\n"
        							 + "2-Página Anterior\n"
					 			 	 + "3- Selecionar Página\n"
					 			 	 + "4- Voltar ao menu principal");
        			opcao = entrada.nextInt();
        			switch(opcao)
        			{
        			case 1:
        				pagAtual++;
        				break;
        			case 2:
        				pagAtual--;
        				break;
        			case 3:
        				pagAtual = selecionarPag(totalPag, entrada);
        				break;
        			case 4:
        				visualizandoBancoDados = false;
        				break;
        			default:
        				System.out.println("Digite um valor inteiro de 1 a 4");
        				break;
        			}
        		}
        		
        	}
        }
        entrada.close();
    }
}
