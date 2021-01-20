import java.util.Scanner;
import java.util.Random;

public class Matrizes{
public static void main(String [] args) {
    Random gerador = new Random();
    int i=0, j=0;
    int A[][] = new int[3][2];
    int B[][] = new int[3][2];
    int C[][] = new int[3][2];
    int CT[][] = new int[2][3];

    for(i=0;i<3;i++){
        for(j=0;j<2;j++){
            A[i][j] = gerador.nextInt(100);
        }
    }
    for(i=0;i<3;i++){
        for(j=0;j<2;j++){
            B[i][j] = gerador.nextInt(100);
        }
    } 
    for(i=0;i<3;i++){
        for(j=0;j<2;j++){
            C[i][j] = A[i][j] + B[i][j];
        }
    } 
    System.out.println("Matriz A:");
    for(i=0;i<3;i++){
        for(j=0;j<2;j++){
            System.out.printf("%d ", A[i][j]);
        }
        System.out.println();
    }
    System.out.println("Matriz B:");
    for(i=0;i<3;i++){
        for(j=0;j<2;j++){
            System.out.printf("%d ", B[i][j]);
        }
        System.out.println();
    }
    System.out.println("Matriz C:");
    for(i=0;i<3;i++){
        for(j=0;j<2;j++){
            System.out.printf("%d ", C[i][j]);
        }
        System.out.println();
    }
    for(i=0;i<3;i++){
        for(j=0;j<2;j++){
            CT[j][i] = C[i][j];
        }
    }
    System.out.println("Matriz C transposta:");
    for(i=0;i<2;i++){
        for(j=0;j<3;j++){
            System.out.printf("%d ", CT[i][j]);
        }
        System.out.println();
    }
}
}
