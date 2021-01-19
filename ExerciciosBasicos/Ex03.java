import java.util.Scanner;

public class Ex03{
public static void main(String [] args) {
  Scanner in = new Scanner(System.in);
  int i, x = 0, y = 1, aux, n=0;
  int soma=1;

  System.out.println("Digite um valor para n:");
  n = in.nextInt();

  System.out.println("1");
  for (i = 1; i < n; i++) {
    aux = x + y;
    x = y;
    y = aux;

    System.out.println(aux);
    soma += aux;
  }
  System.out.print("soma = ");
  System.out.println(soma);

}
}