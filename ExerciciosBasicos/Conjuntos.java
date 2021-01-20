import java.util.Scanner;
import java.util.Random;

public class Conjuntos{
public static void main(String [] args) {
Scanner in = new Scanner(System.in);
Random gerador = new Random();
System.out.println("Digite um valor de n");
 int n = in.nextInt();

 int A[] = new int[n];
 int B[] = new int[n];
 int x;

    for(int i=0;i<n;i++)
    {
      A[i] = gerador.nextInt(50);
    }
    for(int i=0;i<n;i++){
      B[i] = gerador.nextInt(50);
    }
    
 
  System.out.println("A ∩ B");
  for (int i = 0; i< n; i++){
    for (int j = 0; j< n;j++){
      if (A[i] == B[j]){
        System.out.printf("%d ", A[i]);
       
      }
    }
  }
  System.out.println();

  System.out.println(" A ∪ B ");
  for (int i = 0; i< n; i++){
    System.out.printf("%d ", A[i]);
    System.out.printf("%d ", B[i]);
}
System.out.println();

System.out.println(" A + B ");
  for (int i = 0; i< n; i++){
    x = A[i] + B[i];
    System.out.printf("%d ", x);
}
System.out.println();

System.out.println(" A - B ");
  for (int i = 0; i< n; i++){
    x = A[i] - B[i];
    System.out.printf("%d ", x);
}
System.out.println();

System.out.println(" B - A ");
  for (int i = 0; i< n; i++){
    x = B[i] - A[i];
    System.out.printf("%d ", x);
    }
    System.out.println();

}
}
