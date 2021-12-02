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
import java.util.regex.Pattern;
import java.util.regex.Matcher;

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
				Contrato k = j.getContrato();
				Veiculo l = k.getVeiculo();
				System.out.println("Cliente:\n"
								 + "-------\n"
								 + j.getNome() + ", " + j.getGenero() + "\n"
								 + "ID: " + clientes.indexOf(j) + ", Cpf: " + j.getCpf() + "\n"
								 + "Veículo:\n"
								 + "-------\n"
								 + "Placa: " + l.getPlaca() + ", Modelo: " + l.getModelo() + "\n"
								 + "Taxas:\n"
								 + "-----\n"
								 + "Do veículo: " + l.getTaxaVeiculo() + ", Diária: " + l.getTaxaDia() + ", Por km: " + l.getTaxaKm() + "\n"
								 + "Totais:\n"
								 + "------\n"
								 + "Dias: " + k.getDias() + ", Km inicial: " + k.getKmInicial() + ", Km final: " + k.getKmFinal() + "\n"
						 		 + "Valor dias: " + k.custoDias() + ", Valor total: " + k.custoTotal() + "\n"
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
        boolean aberto = true;
        boolean adicionando;
        boolean removendo;
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
        		clientes.add(new Cliente(valores[0], valores[1], valores[2],
        					 new Contrato(new Veiculo(valores[3], valores[4], valores[5], valores[6], valores[7]),
        					 valores[8], valores[9], valores[10])));
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
        					 + "3- Visualizar banco de dados.\n"
        					 + "4- Sair");
        	
			try
			{
				opcao = Integer.parseInt(entrada.nextLine());
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
        			boolean valido;
        			int dias;
        			String nome, placa = "";
        			float cpf = 0;
        			char genero;
        			double kmInicial, kmFinal, taxaVeiculo, taxaKm, taxaDia = 0;
        			Modelo modelo = Modelo.VOLKSWAGEN_GOL;
        			
    				System.out.println("Cliente\n"
    								 + "Nome (-1 p/ cancelar):");
    				nome = entrada.nextLine();
    				if(nome.equals("-1"))
    				{
    					adicionando = false;
    					break;
    				}
    				
    				System.out.println("Cpf (-1 p/ cancelar):");
    				do
        			{
        				try
        				{
        					cpf = Float.parseFloat(entrada.nextLine());
        				}
        				catch(Exception e)
        				{
        					cpf = 0;
        				}
        				if(cpf == -1)
        				{
        					adicionando = false;
        					break;
        				}
        				valido = cpf >= 10000000000f && cpf <= 99999999999f;
        				if(!valido) System.out.println("Insira um cpf válido.");
        			}while(!valido);
        			if(!adicionando)break;
        			System.out.println("Gênero (. p/ cancelar): ");
        			genero = entrada.nextLine().charAt(0);
        			if(genero == '.')
    				{
    					adicionando = false;
    					break;
    				}
        			
        			System.out.println("Veículo\n"
        							  +"Modelo (-1 p/ cancelar):");
        			for(int i = 0; i < Modelo.values().length; i++)
    				{
    					System.out.println((i+1) + "- " + Modelo.values()[i]);
    				}
        			do
        			{
        				try {
							opcao = Integer.parseInt(entrada.nextLine());
						} catch (Exception e) {
							opcao = -2;
						}
        				if(opcao == -1)
        				{
        					adicionando = false;
        					break;
        				}
        				try
        				{
        					modelo = Modelo.values()[opcao-1];
        					valido = true;
        				}
        				catch(Exception e)
        				{
        					System.out.println("Insira um valor de 1 a " + Modelo.values().length);
        					valido = false;
        				}
        			}while(!valido);
        			if(!adicionando)break;
        			
        			Pattern patternPlaca = Pattern.compile("[A-Z][A-Z][A-Z][0-9][A-Z][0-9][0-9]|[A-Z][A-Z][A-Z][0-9][0-9][0-9][0-9]");
        			Matcher matcher;
        			System.out.println("Placa (-1 p/ cancelar):");
        			do
        			{
        				placa = entrada.nextLine();
        				matcher = patternPlaca.matcher(placa);
        				if(placa.equals("-1"))
        				{
        					adicionando = false;
        					break;
        				}
        				valido = matcher.matches();
        				if(!valido)System.out.println("Insira uma placa válida (ABC1D23 ou ABC1234)");
        			}while(!valido);
        			if(!adicionando)break;
        			
        			System.out.println("Taxa do veículo (-1 p/ cancelar):");
        			do
        			{
        				try
        				{
        					taxaVeiculo = Double.parseDouble(entrada.nextLine());
        				}
        				catch(Exception e)
        				{
        					taxaVeiculo = 0;
        				}
        				if(taxaVeiculo == -1)
        				{
        					adicionando = false;
        					break;
        				}
        				valido = taxaVeiculo > 0;
        				if(!valido) System.out.println("Insira um valor acima de 0.");
        			}while(!valido);
        			if(!adicionando)break;
        			
        			System.out.println("Taxa diária (-1 p/ cancelar):");
        			do
        			{
        				try
        				{
        					taxaDia = Double.parseDouble(entrada.nextLine());
        				}
        				catch(Exception e)
        				{
        					taxaDia = 0;
        				}
        				if(taxaDia == -1)
        				{
        					adicionando = false;
        					break;
        				}
        				valido = taxaDia > 0;
        				if(!valido) System.out.println("Insira um valor acima de 0.");
        			}while(!valido);
        			if(!adicionando)break;
        			
        			System.out.println("Taxa por km (-1 p/ cancelar):");
        			do
        			{
        				try
        				{
        					taxaKm = Double.parseDouble(entrada.nextLine());
        				}
        				catch(Exception e)
        				{
        					taxaKm = 0;
        				}
        				if(taxaKm == -1)
        				{
        					adicionando = false;
        					break;
        				}
        				valido = taxaKm > 0;
        				if(!valido) System.out.println("Insira um valor acima de 0.");
        			}while(!valido);
        			if(!adicionando)break;
        			
        			System.out.println("Contrato\n"
        							 + "Dias (-1 p/ cancelar):");
        			do
        			{
        				try
        				{
        					dias = Integer.parseInt(entrada.nextLine());
        				}
        				catch(Exception e)
        				{
        					dias = 0;
        				}
        				if(dias == -1)
        				{
        					adicionando = false;
        					break;
        				}
        				valido = dias > 0;
        				if(!valido) System.out.println("Insira um valor acima de 0.");
        			}while(!valido);
        			if(!adicionando)break;
        			
        			System.out.println("Quilometragem inicial (-1 p/ cancelar):");
        			do
        			{
        				try
        				{
        					kmInicial = Double.parseDouble(entrada.nextLine());
        				}
        				catch(Exception e)
        				{
        					kmInicial = -2;
        				}
        				if(kmInicial == -1)
        				{
        					adicionando = false;
        					break;
        				}
        				valido = kmInicial >= 0;
        				if(!valido) System.out.println("Insira um número real positivo.");
        			}while(!valido);
        			if(!adicionando)break;
        			
        			System.out.println("Quilometragem final (-1 p/ cancelar):");
        			do
        			{
        				try
        				{
        					kmFinal = Double.parseDouble(entrada.nextLine());
        				}
        				catch(Exception e)
        				{
        					kmFinal = -2;
        				}
        				if(kmFinal == -1)
        				{
        					adicionando = false;
        					break;
        				}
        				valido = kmFinal > kmInicial;
        				if(!valido) System.out.println("Insira um número real maior que a quilometragem inicial.");
        			}while(!valido);
        			if(!adicionando)break;
        			
        			clientes.add(new Cliente(nome, cpf, genero,
        						 new Contrato(new Veiculo(placa, taxaDia, taxaKm, taxaVeiculo, modelo),
        						 dias, kmInicial, kmFinal)));
        			System.out.println("Adicionar outro cliente?(s/n)");
        			adicionando = entrada.nextLine().equalsIgnoreCase("s");
        		}
        		break;
//-------------------------------------------------------------------------------------------------------------------------------
        	case 2:
        		removendo = true;
        		while(removendo)
        		{
        			System.out.println("Digite o ID do cliente que deseja remover (-1 p/ cancelar):");
        			int removeID = -2;
        			do
        			{
        				try {
							removeID = Integer.parseInt(entrada.nextLine());
						} catch (NumberFormatException e) {
							removeID = -2;
						}
        				if(removeID < -1 || removeID >= clientes.size()) System.out.println("Digite um ID válido.");
        			}while(removeID < -1);
        			removendo = removeID != -1;
        			if(!removendo) break;
        			else clientes.remove(removeID);
        			System.out.println("Remover outro?(s/n)");
        			removendo = entrada.nextLine().equalsIgnoreCase("s");
        		}
        		break;
//-------------------------------------------------------------------------------------------------------------------------------
        	case 3:
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
            			try {
							opcao = Integer.parseInt(entrada.nextLine());
						} catch (Exception e) {
							opcao = -1;
						}
            			
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
            			try {
							opcao = Integer.parseInt(entrada.nextLine());
						} catch (Exception e) {
							opcao = -1;
						}
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
            			try {
							opcao = Integer.parseInt(entrada.nextLine());
						} catch (Exception e) {
							opcao = -1;
						}
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
        	case 4:
        		PrintWriter arquivoClientesW = null;
        		try 
        		{
	        		FileWriter out = new FileWriter("clientes.csv");
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
        		System.out.println("Digite um valor inteiro de 1 a 4");
        		break;
        	}
        }
        entrada.close();
    }
}
