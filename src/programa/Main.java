package programa;
import java.util.ArrayList;
import java.util.Scanner;

import locadora.Cliente;
import locadora.Contrato;
import locadora.Modelo;
import locadora.Veiculo;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Random;

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

	public static boolean unico(int ID, ArrayList<Cliente> clientes)
	{
		for(Cliente i : clientes)
		{
			if(ID == i.getID())return false;
		}
		return true;
	}

    public static void main(String [] args)
    {
        boolean aberto = true;
        boolean adicionando;
        boolean removendo;
        boolean editando;
        boolean visualizandoBancoDados = false;
        Scanner entrada = new Scanner(System.in);
        int opcao;
        int pagAtual = 1;
        int totalPag;
        
        Scanner arquivoClientes = null;
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        try
        {
        	FileReader in = new FileReader("clientes.csv");
        	arquivoClientes = new Scanner(in);
        	while(arquivoClientes.hasNext())
        	{
        		String[] valores = arquivoClientes.nextLine().split(";");
        		clientes.add(new Cliente(valores[0], valores[1], valores[2], valores[4],
        					 new Contrato(new Veiculo(valores[5], valores[6], valores[7], valores[8], valores[9]),
        					 valores[10], valores[11], valores[12])));
        	}
        }
        catch(java.io.FileNotFoundException e) {}
        finally
        {
        	if(arquivoClientes!=null)arquivoClientes.close();
        }
        
        while(aberto)
        {
        	totalPag = (int)Math.ceil(clientes.size()/3.0);
        	System.out.println("1- Adicionar entrada.\n"
        					 + "2- Remover entrada.\n"
        					 + "3- Editar entrada.\n"
        					 + "4- Visualizar banco de dados.\n"
        					 + "5- Sair");
        	
			try
			{
				opcao = entrada.nextInt();
				entrada.nextLine();
			}
			catch(Exception e)
			{
				opcao = -1;
			}
        	
        	switch(opcao) 
        	{
        	case 1:
        		adicionando = true;
        		while(adicionando)
        		{
        			Random genID = new Random();
        			boolean valido = false;
        			int ID, dias, modelo;
        			String nome, placa = "";
        			float cpf;
        			char genero;
        			double kmInicial, kmFinal, taxaVeiculo, taxaKm, taxaDia;
        			do {
        				ID = genID.nextInt();
        			}while(!unico(ID, clientes));
        			
    				System.out.println("Nome:");
    				nome = entrada.nextLine();
    				if(nome == "-1")
    				{
    					adicionando = false;
    					break;
    				}
        			while(!valido)
        			{
        				System.out.println("Cpf (-1 para cancelar):");
        				try
        				{
        					cpf = Float.parseFloat(entrada.nextLine());
        				}
        				catch(Exception e)
        				{
        					cpf = 0;
        				}
        				if(cpf >= 10000000000f)valido = true;
        				else if(cpf == -1)
        				{
        					adicionando = false;
        					break;
        				}
        				else System.out.println("Insira um valor válido.");
        			}
        			System.out.println();
        			

//        			clientes.add(new Cliente(ID, nome, cpf, genero,
//        						 new Contrato(new Veiculo(taxaVeiculo, taxaKm, taxaDia, placa,Modelo.values()[modelo-1]),
//        						 dias, kmInicial, kmFinal)));
        		}
        		break;
//-------------------------------------------------------------------------------------------------------------------------------
        	case 2:
        		removendo = true;
        		while(removendo)
        		{
        			
        		}
        		break;
//-------------------------------------------------------------------------------------------------------------------------------
        	case 3:
        		editando = true;
        		while(editando)
        		{
        			
        		}
        		break;
//-------------------------------------------------------------------------------------------------------------------------------
        	case 4:
        		if(clientes.size() == 0)
            	{
            		System.out.println("Banco de dados vazio.\n");
            	}
            	else
            	{
            		visualizandoBancoDados = true;
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
            			entrada.nextLine();
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
            			entrada.nextLine();
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
            			entrada.nextLine();
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
        		break;
//-------------------------------------------------------------------------------------------------------------------------------
        	case 5:
        		PrintWriter arquivoClientesW = null;
        		try 
        		{
	        		FileWriter out = new FileWriter("clientes.csv", true);
	        		arquivoClientesW = new PrintWriter(out);
	        		for(Cliente i : clientes)
	        		{
	        			arquivoClientesW.println(i.toString());
	        		}
        		}
        		catch(java.io.IOException e) {
        			System.out.println(e);
        		}
        		finally 
        		{
        			arquivoClientesW.close();
        			aberto = false;
        		}
        		break;
        	default:
        		System.out.println("Digite um valor inteiro de 1 a 6");
        		break;
        	}
        }
        entrada.close();
    }
}
