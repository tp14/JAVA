package dados;

import java.util.ArrayList;
import java.util.List;

import exceptions.JaPossuiObjetoException;
import exceptions.NaoPossuiObjetoException;
import exceptions.PosicaoInvalidaException;


public class Conjunto<T> implements IColecao<T>{
	private List<T> conjunto = new ArrayList<T>();

	public void adicionar(T elemento) throws JaPossuiObjetoException {
		if(!conjunto.contains(elemento))
			conjunto.add(elemento);
		else
			throw new JaPossuiObjetoException("Objeto ja existe na lista.");
	}

	public void remover(T elemento) throws NaoPossuiObjetoException {
		if(conjunto.contains(elemento))
			conjunto.remove(elemento);
		else
			throw new NaoPossuiObjetoException("Objeto nao existe na lista.");
	}

	public T get(int index) throws PosicaoInvalidaException{
		
		if(conjunto.contains(conjunto.get(index)))
			return conjunto.get(index);
		else
			throw new PosicaoInvalidaException("Posicao invalida.");
	}

	public IColecao<T> intersecao(IColecao<T> conjunto2) throws JaPossuiObjetoException {
		IColecao<T> conjInter = new Conjunto<T>();
		
		for(T elemento : conjunto) {
			if(conjunto2.possui(elemento))
				conjInter.adicionar(elemento);
		}
		
		return conjInter;
	}

	public IColecao<T> uniao(IColecao<T> conjunto2) throws JaPossuiObjetoException {
		IColecao<T> conjUniao = conjunto2;
		
		for(T elemento : conjunto) {
			if(!conjunto2.possui(elemento))
				conjUniao.adicionar(elemento);
		}
		
		return conjUniao;
	}

	public void ordenar() {
		conjunto.sort(null);
	}

	public int tamanho() {
		return conjunto.size();
	}

	public List<T> getAll() {
		return  conjunto;
	}

	public boolean possui(T elemento) {
		if(conjunto.contains(elemento))
			return true;
		
		return false;
	}

	public void setConjunto(List<T> conjunto) {
		this.conjunto = conjunto;
	}
}
