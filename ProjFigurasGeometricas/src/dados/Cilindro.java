package dados;

public class Cilindro extends FormaGeometrica {
	Circulo base = new Circulo();
	Retangulo lateral = new Retangulo();
	
	public double calcularPerimetro() {
		return 0;
	}
	
	public double calcularArea() {
		return lateral.calcularArea() + 2*base.calcularArea();
	}
	
	public double calcularVolume() {
		return base.calcularArea()* lateral.getAltura();
	}
	
	public String toString() {
		return "Area: " + calcularArea() + " Volume: " + calcularVolume();
	}
	public Circulo getBase() {
		return base;
	}
	public void setBase(Circulo base) {
		this.base = base;
	}

	public Retangulo getLateral() {
		return lateral;
	}

	public void setLateral(Retangulo lateral) {
		this.lateral = lateral;
	}
}
