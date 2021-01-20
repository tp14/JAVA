package dados;

public class Retangulo extends FormaGeometrica {
	private double base;
	private double altura;
	
	public double calcularArea() {
		return base*altura;
	}
	
	public double calcularPerimetro() {
		return 2*(base+altura);
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public String toString() {
		return "Area: " + calcularArea() + " Perimetro: " + calcularPerimetro() ;
	}
}
