
import java.util.Random;

public class Baralho {
	private Carta[] baralho = new Carta[10];
	Random gerador = new Random();
	private int quantCarta = 0;
	
	public void adicionarCarta(Carta carta) {
		this.baralho[quantCarta] = carta;
		quantCarta ++;
	}
	
	public void mostrarCartas() {
		for(int i=0; i<9; i++){
			 System.out.println(baralho[i].toString());
		}
	}

	public void embaralhar() {
		int ran = 0, rand =0, aux =0;
		
		for(int i=0; i<10; i++) {
			ran = gerador.nextInt(9);
			rand = gerador.nextInt(9);
			aux = baralho[ran].getNumCarta();
			baralho[ran].setNumCarta(baralho[rand].getNumCarta());
			baralho[rand].setNumCarta(aux);
		}
	}
	
	public Carta[] getBaralho() {
		return baralho;
	}

	public void setBaralho(Carta[] baralho) {
		this.baralho = baralho;
	}
}


