package exceptions;

public class PosicaoInvalidaException extends Exception {
	
	public PosicaoInvalidaException() {
		
	}
	
	public PosicaoInvalidaException(String mensagem) {
		super(mensagem);
	}

}
