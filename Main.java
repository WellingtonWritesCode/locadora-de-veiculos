
import java.util.Scanner;

public class Main {
    public static void main(String [] args)
    {
        boolean aberto = true;
        Scanner entrada = new Scanner(System.in);





            //identificação do cliente
            System.out.println("informe a identificação:");
            int id = entrada.nextInt();
            System.out.println("informe o nome:");
            entrada.nextLine();
            String nome = entrada.nextLine();
            System.out.println("informe seu cpf:");
            float cpf = entrada.nextFloat();
            System.out.println("informe o gênero:");
            char genero = entrada.next().charAt(0);





            //dados do veículo
            System.out.println("informe o modelo:");
            entrada.nextLine();
            String modelo = entrada.nextLine();
            System.out.println("informe a quilometragem inicial:");
            int quilometragem = entrada.nextInt();
            System.out.println("informe a placa do veículo:");
            entrada.nextLine();
            String placa = entrada.nextLine();
            System.out.println("informe a taxa do veículo:");
            double taxaVeiculo = entrada.nextDouble();
            System.out.println("informe a taxa de quilometragem:");
            double taxaKM = entrada.nextDouble();
            System.out.println("informe a taxa do dia:");
            double taxaDia = entrada.nextDouble();


            //informações do contrato
            System.out.println("informe a quantidade de dias que o veículo será alugado:");
            int dias = entrada.nextInt();
            System.out.println("informe a quilometragem final:");
            int kM = entrada.nextInt();

            
            Veiculo automovel = new Veiculo(taxaVeiculo, taxaKM, taxaDia, placa, modelo);
            Contrato contrato = new Contrato( automovel, dias, kM);
            Cliente cliente = new Cliente(id, nome, cpf, genero, contrato);

            System.out.println(String.format("Nome: %s", cliente.getNome()));
            System.out.println(String.format("Modelo: %s", automovel.getModelo()));
            System.out.println(String.format("Placa: %s", automovel.getPlaca()));
            System.out.println(String.format("taxa do veículo: %.2f", automovel.getTaxaVeiculo()));
            System.out.println(String.format("Taxa de quilometragem: %.2f", automovel.getTaxaKM()));
            System.out.println(String.format("Taxa do dia: %.2f", automovel.getTaxaDia()));
            System.out.println(String.format("valor total: %.2f", contrato.custoTotal()));
            

            
    }
}
