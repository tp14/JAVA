package dados;

public class Fatoriais extends Gerador{
	
	public void gerar(int quant) {
		int fat = 1, result = 1;
		do {
			for(int i=fat; i>0; i--)
				result = result*i;
			sequencia.add(result);
			fat++;
			result = 1;
			quant --;
		} while(quant != 0);
	}
}
