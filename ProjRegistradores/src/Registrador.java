import java.util.Arrays;

public class Registrador {
	private int[] registrador = new int[8];

	public void setValor(int i, int valor) {
		this.registrador[i] = valor;
	}
	
	public String toString() {
		return "Registrador [registrador=" + Arrays.toString(registrador) + "]";
	}

	public int[] getRegistrador() {
		return registrador;
	}

	public void setRegistrador(int[] registrador) {
		this.registrador = registrador;
	}
}
