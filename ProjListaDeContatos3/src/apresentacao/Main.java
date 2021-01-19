package apresentacao;

import java.util.Scanner;
import dados.*;
import exceptions.*;
import negocio.*;

public class Main {
	private static ListaTelefonica lista;
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		int op = -1;
		try {
			lista = new ListaTelefonica();
		}
		catch(ErroNaLeituraException el) {
			System.err.println(el.getMessage());
			System.err.println("Erro na leitura do arquivo no caminho: " + el.getCaminho());
		}
		
		while(op != 0) {
			System.out.println("1- Novo Contato\n2- Remover Contato\n3- Exibir Contatos\n0- Sair");
			op = in.nextInt();
			in.nextLine();
			
			switch(op) {
				case 1:
					try {
						lista.adicionarContato(novoContato());
					}
					catch(ErroNaLeituraException el) {
						System.err.println(el.getMessage());
						System.err.println("Erro na leitura do arquivo no caminho: " + el.getCaminho());
					}
					catch(ErroNaGravacaoException eg) {
						System.err.println(eg.getMessage());
						System.err.println("Erro na gravacao do arquivo no caminho: " + eg.getCaminho());
					}
					catch(ContatoJaCadastradoException cc) {
						System.err.println(cc.getMessage());
					}
					break;
				case 2:
					try {
						removeContato();
					}
					catch(ErroNaGravacaoException eg) {
						System.err.println(eg.getMessage());
						System.err.println("Erro na gravacao do arquivo no caminho: " + eg.getCaminho());
					}
					catch(ErroNaLeituraException el) {
						System.err.println(el.getMessage());
						System.err.println("Erro na leitura do arquivo no caminho: " + el.getCaminho());
					}
					catch(ContatoNaoCadastradoException cnc) {
						System.err.println(cnc.getMessage());
					}
					break;
				case 3:
					lista.buscarContatos();
					break;
				case 0:
					break;
				default:
					System.out.println("Opcao invalida.");
			}
		}
		in.close();
	}
	
	private static Contato novoContato() {
		Contato contato = new Contato();
		
		System.out.println("Digite o nome:");
		contato.setNome(in.nextLine());
		System.out.println("Digite o telefone:");
		contato.setTelefone(in.nextLine());
		
		return contato;  
	}
	
	private static void removeContato() throws ErroNaGravacaoException, ErroNaLeituraException, ContatoNaoCadastradoException{
		Contato contato = new Contato();
		int indice = 0;
		
		System.out.println("Digite a inical do nome:");
		char letra = in.next().charAt(0);
		if(lista.getListaContatos().get(letra).isEmpty())
			System.out.println("Lista Vazia.");
		else {
			lista.buscarContatoLetra(letra);
			System.out.println("Digite o indice: ");
			indice = in.nextInt();
			in.nextLine();
			if(indice < lista.getListaContatos().get(letra).size()) {
				contato = lista.getListaContatos().get(letra).get(indice);
				lista.removerContato(contato);
			}
			else
				System.out.println("Contato nao existe.");
		}
	}		
}
