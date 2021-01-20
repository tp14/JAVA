package dados;

public class Circulo extends FormaGeometrica {
	private double pi = 3.14;
	private double raio;
	
	public double calcularArea() {
		return pi*(raio*raio);
	}
	
	public double calcularPerimetro() {
		return 4*pi*raio;
	}

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}
	
	public String toString() {
		return "Area: " + calcularArea() + " Perimetro: " + calcularPerimetro() ;
	}
}
