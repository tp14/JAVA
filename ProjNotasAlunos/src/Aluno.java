

public class Aluno {
	private String nomeAluno;
	private double n1, n2, n3, n4, n5;
	private double media;
	
	public void calcularMedia() {
		media = (n1+n2+n3+n4+n5)/5.0;
	}
	
	public String toString() {
		return "Aprovado " + nomeAluno + "  " + media;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
		
	public double getN1() {
		return n1;
	}

	public void setN1(double n1) {
		this.n1 = n1;
	}

	public double getN2() {
		return n2;
	}

	public void setN2(double n2) {
		this.n2 = n2;
	}

	public double getN3() {
		return n3;
	}

	public void setN3(double n3) {
		this.n3 = n3;
	}

	public double getN4() {
		return n4;
	}

	public void setN4(double n4) {
		this.n4 = n4;
	}

	public double getN5() {
		return n5;
	}

	public void setN5(double n5) {
		this.n5 = n5;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}
}
