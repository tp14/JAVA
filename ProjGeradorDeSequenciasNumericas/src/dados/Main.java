package dados;

import java.util.List;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		
		Random rand = new Random();
		Gerador gerador;
		GeradorFactory factory = GeradorFactory.getInstance();
		List<Integer> result;
		
		gerador = factory.criaGerador(TipoGerador.NATURAL);
		gerador.gerar(rand.nextInt(49)+1);
		result = gerador.getSequencia();
		System.out.print("Naturais de " + result.size() + ": [" );
		for(int i=0; i<result.size()-1; i++) {
			System.out.print(result.get(i) + ", ");
		}
		System.out.print(result.get(result.size()-1) + "]\n");
		
		gerador = new Abundantes();
		gerador.gerar(rand.nextInt(49)+1);
		result = gerador.getSequencia();
		System.out.print("Abundantes de " + result.size() + ": [" );
		for(int i=0; i<result.size()-1; i++) {
			System.out.print(result.get(i) + ", ");
		}
		System.out.print(result.get(result.size()-1) + "]\n");
		
		gerador = new Fibonacci();
		gerador.gerar(rand.nextInt(49)+1);
		result = gerador.getSequencia();
		System.out.print("Fibonacci de " + result.size() + ": [" );
		for(int i=0; i<result.size()-1; i++) {
			System.out.print(result.get(i) + ", ");
		}
		System.out.print(result.get(result.size()-1) + "]\n");
		
		gerador = new Fatoriais();
		gerador.gerar(rand.nextInt(49)+1);
		result = gerador.getSequencia();
		System.out.print("Fatoriais de " + result.size() + ": [" );
		for(int i=0; i<result.size()-1; i++) {
			System.out.print(result.get(i) + ", ");
		}
		System.out.print(result.get(result.size()-1) + "]\n");
		
		gerador = new Primos();
		gerador.gerar(rand.nextInt(49)+1);
		result = gerador.getSequencia();
		System.out.print("Primos de " + result.size() + ": [" );
		for(int i=0; i<result.size()-1; i++) {
			System.out.print(result.get(i) + ", ");
		}
		System.out.print(result.get(result.size()-1) + "]\n");
		
		gerador = new Quadrados();
		gerador.gerar(rand.nextInt(9)+1);
		result = gerador.getSequencia();
		System.out.print("Quadrados de " + result.size() + ": [" );
		for(int i=0; i<result.size()-1; i++) {
			System.out.print(result.get(i) + ", ");
		}
		System.out.print(result.get(result.size()-1) + "]\n");
		
		gerador = new Perfeitos();
		gerador.gerar(rand.nextInt(2)+1);
		result = gerador.getSequencia();
		System.out.print("Perfeitos de " + result.size() + ": [" );
		for(int i=0; i<result.size()-1; i++) {
			System.out.print(result.get(i) + ", ");
		}
		System.out.print(result.get(result.size()-1) + "]\n");
	}
}
