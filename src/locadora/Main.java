package locadora;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void printPg(int pagina, ArrayList<Cliente> clientes)
	{
		try
		{
			for(int i = 0; i < 3; i++)
			{
				Cliente j = clientes.get(pagina + i - 1);
				System.out.println(j.getNome() + ", " + j.getGenero() + "\n"
								+ "Cpf: " + j.getCpf() + "\n"
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
        				//TODO Próxima Página
        				break;
        			case 2:
        				//TODO Selecionar Página
        				break;
        			case 3:
        				visualizandoBancoDados = false;
        				break;
        			default:
        				System.out.println("Digite 1 ou 2.");
        				break;
        			}
        		}
        		else if(pagAtual == totalPag) 
        		{
        			opcao = entrada.nextInt();
        			switch(opcao)
        			{
        			case 1:
        				//TODO Página anterior
        				break;
        			case 2:
        				//TODO Selecionar Página
        				break;
        			case 3:
        				visualizandoBancoDados = false;
        				break;
        			default:
        				System.out.println("Digite 1 ou 2.");
        				break;
        			}
        			
        		}
        		else 
        		{
        			opcao = entrada.nextInt();
        			switch(opcao)
        			{
        			case 1:
        				//TODO Próxima página
        				break;
        			case 2:
        				//TODO Página Anterior
        				break;
        			case 3:
        				//TODO Selecionar Página
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
