package locadora;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
	public static void printPg(int pagina, ArrayList<Cliente> clientes)
	{
		try
		{
			
		}
		catch (IndexOutOfBoundsException e)
		{
			return;
		}
	}

    public static void main(String [] args)
    {
        boolean aberto = false;
        boolean visualizandoBancoDados = false;
        Scanner entrada = new Scanner(System.in);
        int opcao;
        int pagAtual = 1;
        int totalPag = 3;
        ArrayList<Cliente> clientes = new ArrayList<Cliente>(5);
        System.out.println(clientes.get(5));
        while(aberto)
        {
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
        		System.out.println("Exemplo1\n"
        						 + "Exemplo2\n"
        						 + "Exemplo3\n"
        						 + "Exemplo4\n"
        						 + "Exemplo5\n"
        						 + "Pag 1/3\n"
        						 + "1- Próxima Página\n"
        						 + "2- Voltar ao menu principal");
        		opcao = entrada.nextInt();
        		if(totalPag == 1)
        		{
        			String temp = entrada.next();
        			visualizandoBancoDados = false;
        		}
        		else if(pagAtual == 1) 
        		{
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
