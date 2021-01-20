package dados;

import java.util.List;

import exceptions.JaPossuiObjetoException;
import exceptions.NaoPossuiObjetoException;
import exceptions.PosicaoInvalidaException;

public interface IColecao<T> {
	
	public void adicionar(T objeto) throws JaPossuiObjetoException;
	public void remover(T objeto) throws NaoPossuiObjetoException;
	public T get(int index) throws PosicaoInvalidaException;
	public IColecao<T> intersecao(IColecao<T> conjunto2) throws JaPossuiObjetoException;
	public IColecao<T> uniao(IColecao<T> conjunto2) throws JaPossuiObjetoException;
	public void ordenar();
	public int tamanho();
	public List<T> getAll();
	public boolean possui(T objeto);
}
