package dados;

import java.util.Random;

public class Complexo {
	private int real;
	private int imaginario;
	
	public Complexo() {
		Random rand = new Random();
		this.real = rand.nextInt(100);
		this.imaginario = rand.nextInt(100);
	}
	
	public Complexo(int real, int imaginario) {
		this.real = real;
		this.imaginario = imaginario;
	}
	
	public String toString() {
		return "(" + this.real + " + " + this.imaginario + "i)\n";
	}

	public int getReal() {
		return real;
	}
	public void setReal(int real) {
		this.real = real;
	}
	public int getImaginario() {
		return imaginario;
	}
	public void setImaginario(int imaginario) {
		this.imaginario = imaginario;
	}
}
