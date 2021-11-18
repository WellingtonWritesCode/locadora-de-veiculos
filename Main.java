import java.util;
import java.util.Scanner;
public class Main {
    public static void main(String [] args)
    {
        boolean aberto = true;
        Scanner entrada = new Scanner(System.in);




        while(aberto)
        {
            System.out.println("informe a identificação:");
            int id = entrada.nextInt();
            System.out.println("informe o nome:");
            entrada.nextLine();
            String nome = entrada.nextLine();
            System.out.println("informe seu cpf:");
            float cpf = entrada.nextFloat();
            System.out.println("informe o gênero:");
            char genero = entrada.next().charAt(0);
            System.out.println("informe o modelo:");
            entrada.nextLine();
            String modelo = entrada.nextLine();
            System.out.println("informe a quilometragem:");
            int quilometragem = entrada.nextInt();


            
        }
    }
}
