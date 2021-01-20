package dados;

import java.util.Random;

public class Posicao {
	Random rand = new Random();
	private int x;
	private int y;
	
	public Posicao(){
		this.x = rand.nextInt(49);
		this.y = rand.nextInt(49);
	}
	
	public Posicao(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
