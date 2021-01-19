import java.util.Scanner;

public class Ex01{
public static void main(String [] args) {
    Scanner in = new Scanner(System.in);

    System.out.println("Defina um intervalo [a,b]:");
    int a = in.nextInt();
    int b = in.nextInt();
    int x = a, aux = 0;
    
    System.out.println("Primos nesse intervalo:");
    while(x <= b){
        for(int i = 1; i<x; i++ ){
            if(x%i == 0)
                aux++;
        }
        if(aux == 1)
            System.out.println(x);
        x++;
        aux = 0;
    }
}
}
