import java.util.Scanner;

public class Ex02{
public static void main(String [] args) {
    Scanner in = new Scanner(System.in);
    int v[] = new int[10];
    int u[] = new int[10];
    int t[] = new int[10];
    int i=0, aux=0, j=0;

    System.out.println("Digite 20 valores:");
    for(i=0;i<10;i++)
        v[i] = in.nextInt();
    for(i=0;i<10;i++)
        u[i] = in.nextInt();

    for(i=0;i<10;i++){
        if(v[i]%2 == 0 & u[i]%2 == 0){
            t[i] = v[i]+u[i];
        }else if(v[i]%2 == 1 & u[i]%2 == 1){
            t[i] = v[i] - u[i];
        }else {
            t[i] = v[i]*u[i];
        }
     }
    
     for(i=0;i<10;i++)
        System.out.printf("%d ", t[i]);   

     for(i=0;i<9;i++){
            while(t[i]>t[i+1]){
                aux = t[i];
                t[i] = t[i+1];
                t[i+1] = aux;
                i=0;
            }
     }
     System.out.println();
     for(i=0;i<10;i++)
        System.out.printf("%d ", t[i]);
}
}