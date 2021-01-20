package dados;

public class PentagonoRegular extends FormaGeometrica {
	private double lado;
	
	public double calcularArea() {
		return ((lado*lado)*Math.pow(25+10*Math.pow(5, 0.5), 0.5))/4;
	}
	
	public double calcularPerimetro() {
		return 5*lado;
	}
	
	public String toString() {
		return "Area: " + calcularArea() + " Perimetro: " + calcularPerimetro() ;
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}
}
