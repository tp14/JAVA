package dados;

public class Ferramenta implements ICompartilhavel{
	private String nome;
	private int tamanho;
	private String material;
	private String tipo;
	private Pessoa dono;
	
	public Ferramenta() {
		this.tipo = "Ferramenta";
	}
	
	public String getEstado(Pessoa dono) {
		return "Tipo: " + tipo + " Nome: " + nome + " Dono: " + dono.getNome();
	}
	
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	public String toString() {
		return "Ferramenta [nome=" + nome + ", tamanho=" + tamanho + ", material=" + material + ", tipo=" + tipo + "]";
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
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
}
