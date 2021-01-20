package dados;

public class Fibonacci extends Gerador {
	
	public void gerar(int quant) {
		int novo=0; sequencia.add(0);
		int penultimo=1; sequencia.add(1);
		int ultimo=1; sequencia.add(1);
		quant-=3;
		do {
			novo = ultimo + penultimo;
			penultimo = ultimo;
			ultimo = novo;
			sequencia.add(novo);
			quant --;
		} while(quant != 0);
	}
}
