package dados;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class Gerador implements ISequencia {
	
	protected List<Integer> sequencia = new LinkedList<Integer>();

	public abstract void gerar(int quant);
	
	public List<Integer> getSequencia() {
		return sequencia;
	}
	
	public int sortear() {
		Random rand = new Random();
		
		return sequencia.get(rand.nextInt(sequencia.size()));
	}
	
	public long somatorio() {
		long soma = 0;
		
		for(int num : sequencia)
			soma += num;
		
		return soma;
	}
	
	public long produtorio() {
		long produto = 1;
		
		for(int num : sequencia)
			produto *= num;
		
		return produto;
	}
	
	public double mediaAritmetrica() {
		return somatorio() / (double) sequencia.size();
	}
	
	public double mediaGeometrica() {
		double result = 0;
		
		result = Math.pow(produtorio(), 1.0 / (double) sequencia.size());
		
		return result;
	}
	
	public double variancia() {
		double media = mediaAritmetrica();
		double soma = 0;
		
		for(int num : sequencia)
			soma += Math.pow(num - media, 2);
		
		return soma / (double) (sequencia.size()-1);
	}
	
	public double desvioPadrao() {
		return Math.sqrt(variancia());
	}
	
	public int amplitude() {
		return Collections.max(sequencia) - Collections.min(sequencia);
	}
	
}
