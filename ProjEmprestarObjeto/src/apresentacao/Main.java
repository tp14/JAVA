package apresentacao;


import java.util.Scanner;
import dados.*;
import exceptions.JaPossuiObjetoException;
import exceptions.NaoPossuiObjetoException;

public class Main {
	
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) throws JaPossuiObjetoException, NaoPossuiObjetoException {
		Pessoa p1 = new Pessoa();
		
		p1.setNome("Thiago Pimenta");
		p1.setIdade(20);
		p1.setCpf(123);
		
		Livro livro1 = new Livro();
		
		livro1.setNome("O poder do habito");
		livro1.setAutor("Charles");
		livro1.setNumeroPaginas(450);
		livro1.setDono(p1);
		
		Ferramenta ferramenta = new Ferramenta();
		
		ferramenta.setNome("Martelo");
		ferramenta.setTamanho(4);
		ferramenta.setMaterial("Ferro");
		ferramenta.setDono(p1);
		
		adicionarObjeto( p1, livro1);
		adicionarObjeto( p1, ferramenta);
		
		Pessoa p2 = new Pessoa();
		
		p2.setNome("Vitoria Bergmann");
		p2.setIdade(21);
		p2.setCpf(456);
		
		Livro livro2 = new Livro();
		
		livro2.setNome("Romeu e Julieta");
		livro2.setAutor("William");
		livro2.setNumeroPaginas(300);
		livro2.setDono(p2);
		
		Filme filme = new Filme();
		
		filme.setNome("A origem");
		filme.setDiretor("Christopher Nolan");
		filme.setTempoDeDuracao("2h30m");
		filme.setDono(p2);
		
		adicionarObjeto( p2, livro2);
		adicionarObjeto( p2, filme);
		
		System.out.println(livro1.getEstado(livro1.getDono()));
		System.out.println(ferramenta.getEstado(ferramenta.getDono()));
		System.out.println(livro2.getEstado(livro2.getDono()));
		System.out.println(filme.getEstado(filme.getDono()));
		emprestarObjetoPara(p1, p2, livro1);
		emprestarObjetoPara(p1, p2, ferramenta);
		emprestarObjetoPara(p2, p1, livro2);
		emprestarObjetoPara(p2, p1, filme);
		System.out.println(livro1.getEstado(livro1.getDono()));
		System.out.println(ferramenta.getEstado(ferramenta.getDono()));
		System.out.println(livro2.getEstado(livro2.getDono()));
		System.out.println(filme.getEstado(filme.getDono()));
		
		in.close();
	}
	
	public static void adicionarObjeto(Pessoa pessoa, ICompartilhavel objeto) {
		
		try {
			pessoa.adicionarObjeto(objeto);
			
		} catch (JaPossuiObjetoException e) {
			System.out.println(e);
		}
		
	}

	public static void removerObjeto (Pessoa pessoa, ICompartilhavel objeto) {
	
		try {
			pessoa.removerObjeto(objeto);
		} catch (NaoPossuiObjetoException e) {
			System.out.println(e);
		}
	}

	public static void emprestarObjetoPara (Pessoa p1, Pessoa p2, ICompartilhavel objeto) {
	
		try {
			p1.emprestarObjetoPara(objeto, p2);
		} catch (NaoPossuiObjetoException e) {
			System.out.println(e);
			
		} catch (JaPossuiObjetoException e) {
			System.out.println(e);
		}
	}
}
