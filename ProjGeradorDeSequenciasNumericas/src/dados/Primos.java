package dados;

public class Primos extends Gerador{
	
	public void gerar(int quant) {
		int num = 2;
		int soma = 0;
		do {
			for(int i=2; i<num; i++) {
				if(num % i == 0)
					soma ++;
			}
			if(soma == 0)
				sequencia.add(num);
			soma = 0;
			num++;
			quant--;
		}while(quant != 0);
	}
}
