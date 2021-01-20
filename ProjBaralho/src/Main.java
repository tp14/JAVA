
import java.util.Scanner;

public class Main {
	private static Scanner in = new Scanner(System.in);
	private static Baralho baralho = new Baralho();
	
	
	public static void main(String[] args) {
		int op = -1;
		
		iniciarBaralho();
		while(op != 0) {
			System.out.println("1- Embaralhar\n2- Mostar Cartas\n0- Sair");
			op = in.nextInt();
			in.nextLine();
			
		switch(op) {
			case 1:
				embaralhar();
				break;
			case 2:
					baralho.mostrarCartas();
				break;
			case 0:
				break;
		}
		}
		in.close();
	}
	
	public static void iniciarBaralho() {
		int i = 1;

		for(i=1;i<11;i++) {
			Carta carta = new Carta();
			carta.setNumCarta(i);
			baralho.adicionarCarta(carta);
		}
	
	}
	
	public static void embaralhar() {
		baralho.embaralhar();;
	}
}
	
	
