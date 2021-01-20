package dados;

public class Triangulo extends FormaGeometrica{
	private double p, l1, l2, l3;
	
	public double calcularArea() {
		p = (l1+l2+l3)/2;
		return Math.pow(p*(p-l1)*(p-l2)*(p-l3),0.5);
	}
	
	public double calcularPerimetro() {
		return l1+l2+l3;
	}

	public double getP() {
		return p;
	}

	public void setP(double p) {
		this.p = p;
	}

	public double getL1() {
		return l1;
	}

	public void setL1(double l1) {
		this.l1 = l1;
	}

	public double getL2() {
		return l2;
	}

	public void setL2(double l2) {
		this.l2 = l2;
	}

	public double getL3() {
		return l3;
	}

	public void setL3(double l3) {
		this.l3 = l3;
	}

	public String toString() {
		return "Area: " + calcularArea() + " Perimetro: " + calcularPerimetro() ;
	}
}
