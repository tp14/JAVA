package dados;

public class Medico extends Pessoa{
	private String especialidade;
	
	public Medico() {
		super();
	}
	
	public String toString() {
		return "\n   Codigo: " + codigo + "\n   Nome: " + nome + "\n   Idade: " + idade + "\n   Cpf: " + cpf + "\n   Cidade: "
				+ cidade + "\n   Especialidade: " + especialidade;
	}
	
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
}
