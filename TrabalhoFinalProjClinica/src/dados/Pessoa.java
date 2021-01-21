package dados;

public class Pessoa {
	protected int codigo;
	protected String nome;
	protected int idade;
	protected long cpf;
	protected String cidade;
	
	public String toString() {
		return "Pessoa [codigo=" + codigo + ", nome=" + nome + ", idade=" + idade + ", cpfp=" + cpf + ", cidade="
				+ cidade + "]";
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}
