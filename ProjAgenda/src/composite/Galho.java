package composite;

import java.util.LinkedList;
import java.util.List;

public class Galho<T> extends Componente<T> {
		List<Componente> componentes = new LinkedList<Componente>();
		
		public Galho() {
			
		}
		
		public Galho(T objeto) {
			this.setObjeto(objeto);
		}
		
		public void adiciona(Componente c) {
			c.setNivel(this.getNivel()+1);
			componentes.add(c); 
		}
		
		public String getDesenho() {
			StringBuilder desenho = new StringBuilder();
			
			desenho.append(espaco()+getObjeto().toString()+"\n");
			
			for(Componente c : componentes) 
				desenho.append(c.getDesenho());
			
			return desenho.toString();
		}

		public List<Componente> getComponentes() {
			return componentes;
		}

		public void setComponentes(List<Componente> componentes) {
			this.componentes = componentes;
		}
}