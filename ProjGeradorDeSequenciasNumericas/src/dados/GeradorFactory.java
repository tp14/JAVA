package dados;

public class GeradorFactory {
	
	private static GeradorFactory gerador;
	
	private GeradorFactory() {
		
	}
	
	public static GeradorFactory getInstance() {
		if(gerador == null) {
			gerador = new GeradorFactory();
		}
		return gerador;
	}
	
	public Gerador criaGerador(TipoGerador tipo){
		 
		switch(tipo) {
		case ABUNDANTE:
			return new Abundantes();
		case 	NATURAL:
			return new Naturais();
		case 	FATORIAL:
			return new Fatoriais();
		case 	FIBONACCI:
			return new Fibonacci();
		case 	PERFEITO:
			return new Perfeitos();
		case 	PRIMO:
			return new Primos();
		case 	QUADRADO:
			return new Quadrados();
		default:
			return null;
		}
	}
}
