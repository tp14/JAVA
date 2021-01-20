package apresentacao;

import dados.*;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main {
    private static Scanner in = new Scanner(System.in);
    private static Random rand = new Random();
    private static ArrayList<FormaGeometrica> formas = new ArrayList<FormaGeometrica>();
    
	public static void main(String[] args) {
		int op = -1;
		
		while(op != 0) {
			System.out.println("1- Criar Circulo\n2- Criar Retangulo\n3- Criar Triangulo\n"
					+ "4- Criar Pentagono\n5- Criar Cilindro\n6- Mostrar perimetros\n"
					+ "7- Mostar areas\n0- Sair");
			op = in.nextInt();
			in.nextLine();
			
			switch (op) {
			 case 1:
				 adicionarFormaGeometrica(criarForma(op));
				 break;
			 case 2:
				 adicionarFormaGeometrica(criarForma(op));
				 break;
			 case 3:
				 adicionarFormaGeometrica(criarForma(op));
				 break;
			 case 4:
				 adicionarFormaGeometrica(criarForma(op));
				 break;
			 case 5:
				 adicionarFormaGeometrica(criarForma(op));
				 break;
			 case 6:
				 mostrarPerimetro();
				 break;
			 case 7:
				 mostrarArea();
				 break;
			 case 0:
				 break; 	
			}
		}
		in.close();
	}
	
	private static void adicionarFormaGeometrica(FormaGeometrica forma) {
		formas.add(forma);
		System.out.println(forma.toString());
	}
	
	private static void mostrarPerimetro() {
		for(FormaGeometrica forma: formas) {
			if(true == isCirculo(forma))
				System.out.println("Circulo com perimetro: " + forma.calcularPerimetro());
			if(true == isRetangulo(forma))
				System.out.println("Retangulo com perimetro: " + forma.calcularPerimetro());
			if(true == isTriangulo(forma))
				System.out.println("Triangulo com perimetro:" + forma.calcularPerimetro());
			if(true == isPentagono(forma))
				System.out.println("Pentagono com perimetro: " + forma.calcularPerimetro());
		}
	}
	
	private static void mostrarArea() {
		for(FormaGeometrica forma: formas) {
			if(true == isCirculo(forma))
				System.out.println("Circulo com area: " + forma.calcularArea());
			if(true == isRetangulo(forma))
				System.out.println("Retangulo com area: " + forma.calcularArea());
			if(true == isTriangulo(forma))
				System.out.println("Triangulo com area:" + forma.calcularArea());
			if(true == isPentagono(forma))
				System.out.println("Pentagono com area: " + forma.calcularArea());
			if(true == isCilindro(forma))
				System.out.println("Cilindro com area: " + forma.calcularArea());
		}
	}
	
	private static FormaGeometrica criarForma(int tipo) {
		if(tipo == 1) {
			Circulo circulo = new Circulo();
			
			circulo.setRaio(rand.nextDouble()*100);
	
			return circulo;
		}
		if(tipo == 2) {
			Retangulo retangulo = new Retangulo();
			
			retangulo.setBase(rand.nextDouble()*100);
			retangulo.setAltura(rand.nextDouble()*100);
			
			return retangulo;
		}
		if(tipo == 3) {
			Triangulo triangulo = new Triangulo();
			
			triangulo.setL1(rand.nextDouble()*100);
			triangulo.setL2(rand.nextDouble()*100);
			triangulo.setL3(rand.nextDouble()*100);
		
			return triangulo;
		}
		if(tipo == 4) {
			PentagonoRegular pentagono = new PentagonoRegular();
			
			pentagono.setLado(rand.nextDouble()*100);
			
			return pentagono;
		}
		if(tipo == 5) {
			Circulo circulo = new Circulo();
			Retangulo retangulo = new Retangulo();
			Cilindro cilindro = new Cilindro();
			
			circulo.setRaio(rand.nextDouble()*100);
			
			retangulo.setBase(rand.nextDouble()*100);
			retangulo.setAltura(rand.nextDouble()*100);
			
			cilindro.setBase(circulo);
			cilindro.setLateral(retangulo);
			
			return cilindro;
		}
		
		return null;
	}
	
	private static boolean isCirculo(FormaGeometrica forma) {
		if(forma instanceof Circulo)
			return true;
		return false;
	}
	
	private static boolean isRetangulo(FormaGeometrica forma) {
		if(forma instanceof Retangulo)
			return true;
		return false;
	}
	
	private static boolean isTriangulo(FormaGeometrica forma) {
		if(forma instanceof Triangulo)
			return true;
		return false;
	}
	
	private static boolean isPentagono(FormaGeometrica forma) {
		if(forma instanceof PentagonoRegular)
			return true;
		return false;
	}
	
	private static boolean isCilindro(FormaGeometrica forma) {
		if(forma instanceof Cilindro)
			return true;
		return false;
	}
}

