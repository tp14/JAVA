package dados;

public class Dia {
	private int dia;
	private String nome;
	
	public Dia(int dia, String nome) {
		this.dia = dia;
		this.nome = nome;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return nome + " " + dia;
	}
	
	public boolean equals(Object obj) {
		Dia dia = (Dia) obj;
		if(this.dia == dia.getDia())
			return true ;
		else
			return false;
	}
}
