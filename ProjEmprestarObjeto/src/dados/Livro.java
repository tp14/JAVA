package dados;

public class Livro implements ICompartilhavel{
	private String nome;
	private String autor;
	private String tipo;
	private int numeroPaginas;
	private Pessoa dono;
	
	public Livro() {
		this.tipo = "Livro";
	}
	
	public String getEstado(Pessoa dono) {
		return "Tipo: " + tipo + " Nome: " + nome + " Dono: " + dono.getNome();
	}
	
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public String toString() {
		return "Livro [nome=" + nome + ", autor=" + autor + ", tipo=" + tipo + ", numeroPaginas=" + numeroPaginas + "]";
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
}
