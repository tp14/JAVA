package dados;

public class Contato {
	private String nome;
	private int telefone;
	
	public String toString() {
		return "Nome: " + nome + ", Telefone: " + telefone;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}	
}
