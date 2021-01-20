package dados;

public class Perfeitos extends Gerador{
	public void gerar(int quant) {
		int num=6;
		int soma=0;
		do {
			for(int i=1; i<num; i++) {
				if(num % i ==0)
					soma+=i;
			}
			if(soma == num) {
				sequencia.add(num);
				quant --;
			}
			num++;
			soma=0;
		} while(quant != 0);
	}
}
