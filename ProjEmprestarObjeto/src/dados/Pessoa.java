package dados;

import java.util.ArrayList;
import exceptions.JaPossuiObjetoException;
import exceptions.NaoPossuiObjetoException;

public class Pessoa {
	private String nome;
	private int cpf;
	private int idade;
	private ArrayList<ICompartilhavel> compartilhaveis = new ArrayList<ICompartilhavel>();
	
   	public void adicionarObjeto(ICompartilhavel objeto) throws JaPossuiObjetoException{
		
		if(!compartilhaveis.contains(objeto))
			compartilhaveis.add(objeto);
		else
		    throw new JaPossuiObjetoException("Objeto ja existe na lista.");
	} 
	
	public void removerObjeto(ICompartilhavel objeto) throws NaoPossuiObjetoException{
		
		if(compartilhaveis.contains(objeto))
			compartilhaveis.remove(objeto);
		else
		 throw new NaoPossuiObjetoException("Objeto nao existe na lista.");
	}
	
	public boolean possuiObjeto(ICompartilhavel objeto) {
		if(compartilhaveis.contains(objeto))
			return true;
		
		return false;
	}
	
	public void emprestarObjetoPara(ICompartilhavel objeto, Pessoa pessoa) throws JaPossuiObjetoException, NaoPossuiObjetoException {
		
		pessoa.adicionarObjeto(objeto);
		removerObjeto(objeto);
		objeto.setDono(pessoa);
	}
	
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + "]";
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}

	public ArrayList<ICompartilhavel> getCompartilhaveis() {
		return compartilhaveis;
	}

	public void setCompartilhaveis(ArrayList<ICompartilhavel> compartilhaveis) {
		this.compartilhaveis = compartilhaveis;
	}
	
}
