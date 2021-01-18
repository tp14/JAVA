package dados;

public class Naturais extends Gerador {
	
	public void gerar(int quant) {
		int i=1;
		do {
			sequencia.add(i);
			i++;
			quant --;
		} while(quant != 0);
	}
}
