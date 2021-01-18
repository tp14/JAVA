package dados;

public class Quadrados extends Gerador{
	
	public void gerar(int quant) {
		int i=4; 
		int teste=0;
		double numDouble=0;
		sequencia.add(0);
		sequencia.add(1);
		quant-=2;
		do {
			numDouble = Math.pow(i, 0.5); 
			for(int j=1; j<=numDouble; j++) {
				if(numDouble % j == 0)
					teste++;
			}
			if(teste > 1) {
				sequencia.add(i);
				quant --;
			}
			i++;
			teste=0;
		} while(quant != 0);
	}
}
