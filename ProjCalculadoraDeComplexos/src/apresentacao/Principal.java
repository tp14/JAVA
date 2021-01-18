package apresentacao;

import java.util.Random;
import java.util.Scanner;
import dados.*;

public class Principal {
	
	private static Scanner in = new Scanner(System.in);
	private static Random rand = new Random();
	
	private static CalculadoraInteiros c1 = new CalculadoraInteiros();
	private static CalculadoraComplexo c2 = new CalculadoraComplexo();
	
	public static void main(String[] args) {
		int op = -1;
		
		do {
			if(rand.nextInt(2) == 1) {
				Integer v1 = rand.nextInt(100); 
				Integer v2 = rand.nextInt(100);
			
				if(rand.nextInt(2) == 1) {
					System.out.println(v1 + " + " + v2 + " = " + c1.soma( v1, v2));
				}
				else {
					System.out.println(v1 + " - " + v2 + " = " + c1.subtracao( v1, v2));
				}
			}
			else {
				Complexo a = new Complexo();
				Complexo b = new Complexo();
				
				if(rand.nextInt(2) == 1) {
					System.out.println(a + " + " + b + " = " + c2.soma( a, b));
				}
				else {
					System.out.println(a + " - " + b + " = " + c2.subtracao( a, b));
				}
			}
			
			System.out.println("Digite 0 para encerrar o programa:");
			op = in.nextInt();
			in.nextLine();
			
		}while(op != 0);
		in.close();
	}

}
