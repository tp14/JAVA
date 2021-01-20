package dados;

public class Mes {
	private int mes;
	private String nome;

	public Mes(int mes, String nome) {
		this.mes = mes;
		this.nome = nome;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return "" + nome;
	}
	
	public boolean equals(Object obj) {
		Mes mes = (Mes) obj;
		if(this.mes == mes.getMes())
			return true ;
		else
			return false;
	} 
}
