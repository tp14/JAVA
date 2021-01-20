package composite;

public class Folha<T> extends Componente<T>{
 
	public Folha(T object) {
		this.setObjeto(object);
	}
	
	public String getDesenho() {
		return espaco() + this.getObjeto().toString() + "\n";
	}
}
