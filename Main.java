import java.util;
import java.util.Scanner;
public class Main {
    public static void main(String [] args)
    {
        boolean aberto = true;
        Scanner entrada = new Scanner(System.in);




        while(aberto)
        {
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

            System.out.println();

            
        }
    }
}
