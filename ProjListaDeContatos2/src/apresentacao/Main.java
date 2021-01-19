package apresentacao;

import java.util.Scanner;

import dados.*;
import negocio.*;

public class Main {
	private static ListaTelefonica lista = new ListaTelefonica();
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		int op = -1;
		
		while(op != 0) {
			System.out.println("1- Novo Contato\n2- Remover Contato\n3- Exibir Contatos\n0- Sair");
			op = in.nextInt();
			in.nextLine();
			
			switch(op) {
				case 1:
					lista.adicionarContato(novoContato());
					break;
				case 2:
					removeContato();
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
	
	private static void removeContato() {
		Contato contato = new Contato();
		
		System.out.println("Digite a inical do nome:");
		char letra = in.next().charAt(0);
		lista.buscarContatoLetra(letra);
		System.out.println("Digite o indice: ");
		contato = lista.getListaContatos().get(letra).get(in.nextInt());
		lista.removerContato(contato);
	}	
}
