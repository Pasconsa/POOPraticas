//Exemplo pratico de aplicacao tratamento de excecao.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex01TratamentoExcecaoPratica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {                                                  //Try local onde o código será verificado
            String[] vect = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(vect[position]);
        } catch (ArrayIndexOutOfBoundsException e) {            // captura do erro demonstra menssagem do erro
            System.out.println("Invalid position!");
        } catch (InputMismatchException e) {
            System.out.println("Input error");
        }
        System.out.println("End of program");              // Programa continua
    }
}

