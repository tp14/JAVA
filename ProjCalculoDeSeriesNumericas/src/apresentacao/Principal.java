package apresentacao;

import java.util.ArrayList;
import java.util.List;
import dados.*;
import java.util.Collections;

public class Principal {
	private static ArrayList<Gerador> sequencias = new ArrayList<Gerador>();
	
	public static void main(String[] args) {
		Gerador gerador;
		
		gerador = new Naturais();
		gerador.gerar(10);
		sequencias.add(gerador);
		imprimir("Naturais", gerador);
		
		gerador = new Abundantes();
		gerador.gerar(10);
		sequencias.add(gerador);
		imprimir("Abundantes", gerador);
		
		gerador = new Fibonacci();
		gerador.gerar(10);
		sequencias.add(gerador);
		imprimir("Fibonacci", gerador);
		
		gerador = new Fatoriais();
		gerador.gerar(10);
		sequencias.add(gerador);
		imprimir("Fatoriais", gerador);
		
		gerador = new Primos();
		gerador.gerar(10);
		sequencias.add(gerador);
		imprimir("Primos", gerador);
		
		gerador = new Quadrados();
		gerador.gerar(10);
		sequencias.add(gerador);
		imprimir("Quadrados", gerador);
		
		gerador = new Perfeitos();
		gerador.gerar(3);
		sequencias.add(gerador);
		System.out.print("\nObs: Deixei so tres porque demora muito pra achar 10.");
		imprimir("Perfeitos", gerador);
		
		maiorSomatorio();
		maiorMediaAritmetica();
		maiorMediaGeometrica();
		maiorVariancia();
		maiorDesvioPadrao();
		maiorAmplitude();
	}
	
	public static void imprimir(String tipo, Gerador g) {
		List<Integer> seq = g.getSequencia();
		
		if(seq.size() < 1)
			System.out.print("\n" + tipo + " de " + seq.size() + ": []\n");
		else {
			System.out.print("\n" + tipo + " de " + seq.size() + ": [");
			for(int i=0; i<seq.size()-1; i++)
				System.out.print(seq.get(i) + ", ");
			System.out.print(seq.get(seq.size()-1) + "]\n");	
		}
		System.out.println("Numero sorteado: " + g.sortear());
		System.out.println("Somatorio: " + g.somatorio());
		System.out.println("Media Aritmetica: " + g.mediaAritmetrica());
		System.out.println("Media Geometrica: " + g.mediaGeometrica());
		System.out.println("Variancia: " + g.variancia());
		System.out.println("Desvio Padrao: " + g.desvioPadrao());
		System.out.println("Amplitude: " + g.amplitude());
		System.out.println("____________________________________________________________________________________________");
	}
	
	public static void maiorSomatorio() {
		ArrayList<Long> somatorio = new ArrayList<Long>();
		
		for(Gerador g : sequencias)
			somatorio.add(g.somatorio());
		
		System.out.println("\nMaior Somatorio: " + Collections.max(somatorio));
	}
	
	public static void maiorMediaAritmetica() {
		ArrayList<Double> mediaAritmetrica = new ArrayList<Double>();
		
		for(Gerador g : sequencias)
			mediaAritmetrica.add(g.mediaAritmetrica());
		
		System.out.println("Maior Media Aritmetrica: " + Collections.max(mediaAritmetrica));
	}
	
	public static void maiorMediaGeometrica() {
		ArrayList<Double> mediaGeometrica = new ArrayList<Double>();
		
		for(Gerador g : sequencias)
			mediaGeometrica.add(g.mediaGeometrica());
		
		System.out.println("Maior Media Geometrica: " + Collections.max(mediaGeometrica));
	}
	
	public static void maiorVariancia() {
		ArrayList<Double> variancia = new ArrayList<Double>();
		
		for(Gerador g : sequencias)
			variancia.add(g.variancia());
		
		System.out.println("Maior Variancia: " + Collections.max(variancia));
	}
	
	public static void maiorDesvioPadrao() {
		ArrayList<Double> desvioPadrao = new ArrayList<Double>();
		
		for(Gerador g : sequencias)
			desvioPadrao.add(g.desvioPadrao());
		
		System.out.println("Maior Desvio Padrao: " + Collections.max(desvioPadrao));
	}
	 
	public static void maiorAmplitude() {
		ArrayList<Integer> amplitude = new ArrayList<Integer>();
		
		for(Gerador g : sequencias)
			amplitude.add(g.amplitude());
		
		System.out.println("Maior Amplitude: " + Collections.max(amplitude));
	}		
}

