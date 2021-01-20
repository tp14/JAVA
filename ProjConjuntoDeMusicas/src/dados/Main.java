package dados;

import java.util.List;

import exceptions.JaPossuiObjetoException;
import exceptions.NaoPossuiObjetoException;

public class Main {
	
	public static void main(String[] args) throws JaPossuiObjetoException {
		Conjunto<Musica> conjunto1 = new Conjunto<Musica>();
		
		Musica m1 = new Musica();
		m1.setNome("m3");
		m1.setAutor("a1");
		m1.setDuracao(190);
		
		Musica m2 = new Musica();
		m2.setNome("m5");
		m2.setAutor("a2");
		m2.setDuracao(182);
		
		Musica m3 = new Musica();
		m3.setNome("m1");
		m3.setAutor("a3");
		m3.setDuracao(205);
		
		Musica m4 = new Musica();
		m4.setNome("m2");
		m4.setAutor("a4");
		m4.setDuracao(184);
		
		Musica m5 = new Musica();
		m5.setNome("m4");
		m5.setAutor("a5");
		m5.setDuracao(185);	
		
		adicionarElemento(m1, conjunto1);
		adicionarElemento(m2, conjunto1);
		adicionarElemento(m3, conjunto1);
		adicionarElemento(m4, conjunto1);
		adicionarElemento(m5, conjunto1);
		
		System.out.println("Antes de ordenar: ");
		for(Musica e : conjunto1.getAll())
			 System.out.println(e.toString());
		conjunto1.ordenar();
		System.out.println("Depois de ordenar: ");
		for(Musica e : conjunto1.getAll())
			 System.out.println(e.toString());
		
		Conjunto<Musica> conjunto2 = new Conjunto<Musica>();
		
		Musica m6 = new Musica();
		m6.setNome("m6");
		m6.setAutor("a6");
		m6.setDuracao(186);
		
		Musica m7 = new Musica();
		m7.setNome("m7");
		m7.setAutor("a7");
		m7.setDuracao(187);
		
		Musica m8 = new Musica();
		m8.setNome("m8");
		m8.setAutor("a8");
		m8.setDuracao(188);
		
		Musica m9 = new Musica();
		m9.setNome("m9");
		m9.setAutor("a9");
		m9.setDuracao(189);
		
		Musica m10 = new Musica();
		m10.setNome("m10");
		m10.setAutor("a10");
		m10.setDuracao(190);
		
		adicionarElemento(m6, conjunto2);
		adicionarElemento(m7, conjunto2);
		adicionarElemento(m3, conjunto2);
		adicionarElemento(m9, conjunto2);
		adicionarElemento(m1, conjunto2);
		
		System.out.println("Conjunto 1: ");
		for(Musica e : conjunto1.getAll())
			 System.out.println(e.toString());
		System.out.println("Conjunto 2: ");
		for(Musica e : conjunto2.getAll())
			 System.out.println(e.toString());
		intersecaoElementos(conjunto1, conjunto2);
		uniaoElementos(conjunto1, conjunto2);
	}
	
	public static <T> void adicionarElemento(T elemento, Conjunto<T> conj) throws JaPossuiObjetoException {
		try {
			conj.adicionar(elemento);
		}
		catch(JaPossuiObjetoException e){
			System.out.println(e);
		}
	}
	
	public static <T> void removerrElemento(T elemento, Conjunto<T> conj) throws NaoPossuiObjetoException {
		try {
			conj.remover(elemento);
		}
		catch(NaoPossuiObjetoException e){
			System.out.println(e);
		}
	}
	
	public static <T> void intersecaoElementos(Conjunto<T> conj1, Conjunto<T> conj2) throws JaPossuiObjetoException {
		List<T> conjInter;
		
		conjInter = conj1.intersecao(conj2).getAll();
		
		System.out.println("Conjunto1 intersecao Conjunto2: ");
		for(T e : conjInter)
		 System.out.println(e.toString());
	}
	
	public static <T> void uniaoElementos(Conjunto<T> conj1, Conjunto<T> conj2) throws JaPossuiObjetoException {
		List<T> conjUniao;
		
		conjUniao = conj1.uniao(conj2).getAll();
		
		System.out.println("Conjunto1 uniao Conjunto2: ");
		for(T e : conjUniao)
			 System.out.println(e.toString());
	}
	
}
