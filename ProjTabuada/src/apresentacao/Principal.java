package apresentacao;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Principal {
	
	public static void main(String[] args) {
		Map<Integer, List<Integer>> todasTabuadas = new HashMap<Integer, List<Integer>>();
		
		for(int i=1; i<=10; i++) {
			todasTabuadas.put(i,tabuada(i));
		}
		
		todasTabuadas.forEach(
				(chave, tabuada) -> {
					System.out.print("\nTabuada de " + chave + ": ");
					for(int x: tabuada) {
						System.out.print(x + " ");
					}
				}
		);
	}
	
	public static List<Integer> tabuada(int n){
		List<Integer> tabuada = new ArrayList<Integer>();
		
		for(int i=1; i<=10; i++) {
			tabuada.add(i*n);
		}
		return tabuada;
	}	
}

