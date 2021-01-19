package negocio;

import dados.Contato;
import exceptions.ContatoJaCadastradoException;
import exceptions.ContatoNaoCadastradoException;
import exceptions.ErroNaGravacaoException;
import exceptions.ErroNaLeituraException;
import persistencia.ContatoDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaTelefonica {
	private ContatoDAO contatoDAO = new ContatoDAO();
	private List<Contato> contatos = new ArrayList<Contato>();
	private Map<Character,List<Contato>> mapContatos = new HashMap<Character,List<Contato>>();
	private ArrayList<Character> iniciais = new ArrayList<Character>(Arrays.asList('A','B','C','D','E',
			'F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'));
	
	public ListaTelefonica() throws ErroNaLeituraException {
		this.contatos = contatoDAO.getAll();
		criarMapLista ();
	}
	
	public void adicionarContato(Contato contato) throws ErroNaGravacaoException, ContatoJaCadastradoException, ErroNaLeituraException{
		contatoDAO.insert(contato);
		this.contatos = contatoDAO.getAll();
		criarMapLista ();
	}
	
	public void removerContato(Contato contato) throws ErroNaGravacaoException, ContatoNaoCadastradoException, ErroNaLeituraException{
		contatoDAO.delete(contato);
		this.contatos = contatoDAO.getAll();
		criarMapLista ();
	}
	
	public void buscarContatos(){
		for(int i=0; i <=25; i++) {
			System.out.println(iniciais.get(i) + ": ");
			buscarContatoLetra(iniciais.get(i));
		}
	}
	
	public void buscarContatoLetra(char letra){
		int ind = 0;
	
		for(Contato contato : mapContatos.get(letra)) {
			System.out.println("  " + ind + ": " + contato.toString());
			ind++;	
		}
	}
	
	public void criarMapLista () {
		ArrayList<Contato> contatos;
		for(int i=0; i <=25; i++) {
			contatos = new ArrayList<Contato>();
			mapContatos.put(iniciais.get(i),contatos);
		}
		
		for(Contato contato : this.contatos) {
			char aux = contato.getNome().charAt(0);
			for (Character atual: iniciais) {
				if (aux == atual) {
					mapContatos.get(aux).add(contato);
				}
			}
		}
	}

	public Map<Character, List<Contato>> getListaContatos() {
		return mapContatos;
	}

	public void setListaContatos(Map<Character, List<Contato>> listaContatos) {
		this.mapContatos = listaContatos;
	}

	public ArrayList<Character> getIniciais() {
		return iniciais;
	}

	public void setIniciais(ArrayList<Character> iniciais) {
		this.iniciais = iniciais;
	}
}