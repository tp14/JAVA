package dados;

public class Ano {
	private int ano;
	
	public Ano(int ano) {
		this.ano = ano;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String toString() {
		return "" + ano;
	}

	public boolean equals(Object obj) {
		Ano ano = (Ano) obj;
		if(this.ano == ano.getAno())
			return true ;
		else
			return false;
	}
}
