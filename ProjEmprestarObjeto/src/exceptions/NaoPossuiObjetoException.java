package exceptions;

public class NaoPossuiObjetoException extends Exception {
	
	public NaoPossuiObjetoException() {
		
	}
	
	public NaoPossuiObjetoException(String mensagem) {
		super(mensagem);
	}
}
