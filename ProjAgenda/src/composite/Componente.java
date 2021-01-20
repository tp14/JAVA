package composite;

public abstract class Componente<T> {
	private int nivel;
	private T objeto;
	
	public abstract String getDesenho();

	protected String espaco() {
		StringBuilder espaco = new StringBuilder();
		for(int i=0; i < this.getNivel(); i++)
			espaco.append("    ");  
		return espaco.toString(); 
	}
	
	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public T getObjeto() {
		return objeto;
	}

	public void setObjeto(T objeto) {
		this.objeto = objeto;
	}
}
