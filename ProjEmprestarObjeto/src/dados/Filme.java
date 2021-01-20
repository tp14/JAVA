package dados;

public class Filme implements ICompartilhavel{
	private String nome;
	private String diretor;
	private String tempoDeDuracao;
	private String tipo;
	private Pessoa dono;
	
	public Filme() {
		this.tipo = "Filme";
	}
	
	public String getEstado(Pessoa dono) {
		return "Tipo: " + tipo + " Nome: " + nome + " Dono: " + dono.getNome();
	}
	
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public String toString() {
		return "Filme [nome=" + nome + ", diretor=" + diretor + ", tempoDeDuracao=" + tempoDeDuracao + ", tipo=" + tipo
				+ "]";
	}
	
	public Pessoa getDono() {
		return dono;
	}

	public void setDono(Pessoa dono) {
		this.dono = dono;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDiretor() {
		return diretor;
	}
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	public String getTempoDeDuracao() {
		return tempoDeDuracao;
	}
	public void setTempoDeDuracao(String tempoDeDuracao) {
		this.tempoDeDuracao = tempoDeDuracao;
	}
}
