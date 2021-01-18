package negocio;

import dados.Contato;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaTelefonica {
	private Map<Character,List<Contato>> listaContatos = new HashMap<Character,List<Contato>>();
	private ArrayList<Character> iniciais = new ArrayList<Character>(Arrays.asList('A','B','C','D','E',
			'F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'));
	
	public void criarLista () {
		ArrayList<Contato> contatos;
		for(int i=0; i <=25; i++) {
			contatos= new ArrayList<Contato>();
			listaContatos.put(iniciais.get(i),contatos);
		}
	}
	
	public void adicionarContato(Contato contato) {
		char aux = contato.getNome().charAt(0);
		for (Character atual: iniciais) {
			if (aux == atual) {
				listaContatos.get(aux).add(contato);
			}
		}
	}
	
	public void removerContato(Contato contato) {
		char aux = contato.getNome().charAt(0);
		listaContatos.get(aux).remove(contato);
	}
	
	public void buscarContatos(){
		for(int i=0; i <=25; i++) {
			System.out.println(iniciais.get(i) + ": ");
			buscarContatoLetra(iniciais.get(i));
		}
	}
	
	public void buscarContatoLetra(char letra){
		int ind = 0;
		
		for(Contato contato : listaContatos.get(letra)) {
			System.out.println("  " + ind + ": " + contato.toString());
			ind++;
			
		}
	}

	public Map<Character, List<Contato>> getListaContatos() {
		return listaContatos;
	}

	public void setListaContatos(Map<Character, List<Contato>> listaContatos) {
		this.listaContatos = listaContatos;
	}

	public ArrayList<Character> getIniciais() {
		return iniciais;
	}

	public void setIniciais(ArrayList<Character> iniciais) {
		this.iniciais = iniciais;
	}
}
