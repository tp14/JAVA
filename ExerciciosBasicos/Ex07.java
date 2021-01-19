import java.util.Scanner;
import java.util.Random;

public class Ex07{
public static void main(String [] args) {
    int i=0, j=0, y=0;
    int A[][] = new int[4][4];
    int B[][] = new int[4][4];
    int C[][] = new int[4][4];
    Random gerador = new Random();

    for(i=0;i<4;i++){
        for(j=0;j<4;j++){
            A[i][j] = gerador.nextInt(10);
        }
    }
    for(i=0;i<4;i++){
        for(j=0;j<4;j++){
            B[i][j] = gerador.nextInt(10);
        }
    } 
    for(i=0;i<4;i++){
        for(j=y;j<4;j++){
            C[i][j] = A[i][j];
        }
        y++;
    } 
    y=3;
    for(i=1;i<4;i++){
        for(j=0;j<4-y;j++){
            C[i][j] = B[i][j];
        }
        y--;
    } 
    System.out.println("Matriz A:");
    for(i=0;i<4;i++){
        for(j=0;j<4;j++){
            System.out.printf("%d ", A[i][j]);
        }
        System.out.println();
    }
    System.out.println("Matriz B:");
    for(i=0;i<4;i++){
        for(j=0;j<4;j++){
            System.out.printf("%d ", B[i][j]);
        }
        System.out.println();
    }
    System.out.println("Matriz C:");
    for(i=0;i<4;i++){
        for(j=0;j<4;j++){
            System.out.printf("%d ", C[i][j]);
        }
        System.out.println();
    }
}
}