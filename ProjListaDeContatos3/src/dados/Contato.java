package dados;

public class Contato {
	private String nome;
	private String telefone;
	
	public boolean equals(Object o) {
		Contato c = (Contato) o;
		
		if(c.getNome().equals(nome)) 
			return true;
		return false;
	}
	
	public String toString() {
		return "Nome: " + nome + ", Telefone: " + telefone;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}	
}