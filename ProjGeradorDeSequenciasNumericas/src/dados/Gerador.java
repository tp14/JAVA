package dados;

import java.util.LinkedList;
import java.util.List;

public abstract class Gerador {
	
	protected List<Integer> sequencia = new LinkedList<Integer>();

	public abstract void gerar(int quant);
	
	public List<Integer> getSequencia() {
		return sequencia;
	}
}
