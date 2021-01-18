package dados;

public class Abundantes extends Gerador {
	
	public void gerar(int quant) {
		int num = 12;
		int soma = 0;
		do {
			for(int i=1; i<num; i++) {
				if(num % i == 0)
					soma += i;
			}
			if(soma > num) {
				sequencia.add(num);
				quant --;
			}
			soma = 0;
			num ++;
		} while(quant != 0);
	}
}
