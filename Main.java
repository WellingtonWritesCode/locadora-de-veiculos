import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner entrada = new Scanner(System.in);
		
		File file = new File("/home/davi/out.txt");
		String path = "/home/davi/out.txt";
		

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
			// identificação do cliente
			System.out.println("Informações sobre o cliente");
			System.out.println();
			
			System.out.print("informe a identificação:");
			int id = entrada.nextInt();
			System.out.print("informe o nome:");
			entrada.nextLine();
			String nome = entrada.nextLine();
			System.out.print("informe seu cpf:");
			float cpf = entrada.nextFloat();
			System.out.print("informe o gênero:");
			char genero = entrada.next().charAt(0);

			// dados do veículo
			System.out.println();
			System.out.println("Informações sobre o Veículo");
			System.out.println();
			
			System.out.print("informe o modelo:");
			entrada.nextLine();
			String modelo = entrada.nextLine();
			System.out.print("informe a quilometragem inicial:");
			double kmInicial = entrada.nextDouble();
			System.out.print("informe a placa do veículo:");
			entrada.nextLine();
			String placa = entrada.nextLine();
			System.out.print("informe a taxa do veículo:");
			double taxaVeiculo = entrada.nextDouble();
			System.out.print("informe a taxa de quilometragem:");
			double taxaKM = entrada.nextDouble();
			System.out.print("informe a taxa do dia:");
			double taxaDia = entrada.nextDouble();

			// informações do contrato
			System.out.println();
			System.out.println("Informações sobre o contrato");
			System.out.println();
			
			System.out.print("informe a quantidade de dias que o veículo será alugado:");
			int dias = entrada.nextInt();
			System.out.print("informe a quilometragem final:");
			double kmFinal = entrada.nextDouble();

			Veiculo automovel = new Carro(taxaVeiculo, taxaKM, taxaDia, placa, modelo);
			Contrato contrato = new Contrato(automovel, dias, kmInicial, kmFinal);
			Cliente cliente = new Cliente(id, nome, cpf, genero, contrato);

			System.out.println();
			
			System.out.println(cliente);
			System.out.println(automovel);
			System.out.println(contrato);
			
			String [] clienteInfo = new String [] {"NOME:"+cliente.getNome(), "ID:" + cliente.getID(),"CPF:"+cliente.getCpf(),"GENERO:" + cliente.getGenero()};
			
			for(String st : clienteInfo) {
				bw.write(st);
				bw.newLine();
			}
			
			String [] automovelInfo = new String [] {"TAXA_VEICULO:"+automovel.getTaxaVeiculo(), "TAXA_KM:"+automovel.getTaxaKM(), "TAXA_DIA:"+automovel.getTaxaDia(), "PLACA:"+automovel.getPlaca(), "MODELO:"+automovel.getModelo()};
			
			for(String st : automovelInfo) {
				bw.write(st);
				bw.newLine();
			}
			
			String [] contratoInfo = new String [] {"DIAS:"+contrato.getDias(), "KM_INICIAL:"+contrato.getKmInicial(), "KM_FINAL:"+contrato.getKmFinal()};
			
			for(String st : contratoInfo) {
				bw.write(st);
				bw.newLine();
			}
			
		} 
		catch (InputMismatchException e) {
			System.out.println("ERROR: wrong input!");
		}
		catch(IOException e) {
			System.out.println("Error:" + e.getMessage());
		}

	}

}
