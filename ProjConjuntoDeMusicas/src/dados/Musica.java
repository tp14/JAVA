package dados;

public class Musica implements Comparable<Musica>{
	private String nome;
	private String autor;
	private Integer duracao;
	
	public int compareTo(Musica outraMusica) {
        return nome.compareTo(outraMusica.nome);
    }
	
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public String toString() {
		return "Nome: " + nome + "  Autor: " + autor + "  Duracao: " + duracao;
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
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
}
