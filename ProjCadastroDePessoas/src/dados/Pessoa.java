package dados;

public class Pessoa {
	private String nome;
	private float idade;
	private float altura;
	private float massa;
	
	public float calculaImc() {
		return massa/(altura*altura);
	}
	
	public boolean equals(Object o) {
		Pessoa p = (Pessoa) o;
		
		if(p.getNome().equals(nome)) 
			return true;
		return false;
	}
	
	public String toString() {
		return "Nome: " + nome + "\nIdade: " + idade + "\nAltura: " + altura + "\nMassa: " + massa + "\nIMC: " + calculaImc();
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getIdade() {
		return idade;
	}
	public void setIdade(float f) {
		this.idade = f;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public float getMassa() {
		return massa;
	}
	public void setMassa(float massa) {
		this.massa = massa;
	}
}
