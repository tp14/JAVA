package dados;

public class Evento {
	private int hora;
	private String descricao;
	
	public Evento(int hora, String descricao) {
		this.hora = hora;
		this.descricao = descricao;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String toString() {
		return "" + hora + "  " + descricao;
	}
}
