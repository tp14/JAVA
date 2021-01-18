package apresentacao;

import java.util.Scanner;

import dados.Pessoa;
import negocio.Sistema;

public class Main {
	private static Sistema sistema = new Sistema();
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		int op = -1;
		
		while(op != 0) {
			
			System.out.println("1- Adicionar pessoa\n2- Remover pessoa\n3- Mostrar pessoas\n0- Sair");
			
			op = in.nextInt();
			in.nextLine();
			
			switch(op) {
				case 1:
					sistema.adicionarPessoa(novaPessoa());
					break;
				case 2:
					sistema.removerPessoa(escolherPessoa());
					break;
				case 3:
					mostrarPessoas();
					break;
				default:
					if(op != 0)
					System.out.println("Opcao invalida.\n");
					break;
			}
		}
		
		in.close();
	}
	
	private static Pessoa novaPessoa() {
		Pessoa p = new Pessoa();
		
		System.out.println("Nome: ");
		p.setNome(in.nextLine());
		System.out.println("Idade: ");
		p.setIdade(Integer.parseInt(in.nextLine()));
		System.out.println("Altura: ");
		p.setAltura(Float.parseFloat(in.nextLine()));
		System.out.println("Massa: ");
		p.setMassa(Float.parseFloat(in.nextLine()));
			
		return p;
	}
	
	private static void mostrarPessoas() {
		int i = 0;
		
		for(Pessoa p : sistema.getList()) {
			System.out.println("Pessoa " + i + " ");
			System.out.println(p + "\n");
			i++;
		}
	}
	
	private static Pessoa escolherPessoa() {
		
		mostrarPessoas();
		
		System.out.println("Escolha o numero da pessoa que quer excluir:");
		int escolha = in.nextInt();
		in.nextLine();
		
		if(escolha < sistema.getList().size())
			return sistema.getList().get(escolha);
		
		return null;
	}
}
