package dados;

public class Paciente extends Pessoa{
	private String descricao;
	
	public Paciente() {
		super();
	}
	
	public String toString() {
		return "\n   Codigo: " + codigo + "\n   Nome: " + nome + "\n   Idade: " + idade + "\n   Cpf: " + cpf + "\n   Cidade: "
				+ cidade + "\n   Descricao: " + descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
