
 
public class Turma {
	private Aluno[] turma = new Aluno[5];
	private Aluno[] aprovados = new Aluno[5];
	private int quantAluno = 0;
	
	public void adicionarAluno(Aluno aluno) {
		this.turma[quantAluno] = aluno;
		quantAluno++;
	}
	
	public void listarAprovados() {
		for(int i=0; i<quantAluno; i++) {
			turma[i].calcularMedia();
			if(turma[i].getMedia() >= 7.0) { 
				System.out.println(turma[i].toString());
			}
		} 
	}

	public Aluno[] getTurma() {
		return turma;
	}

	public void setTurma(Aluno[] turma) {
		this.turma = turma;
	}

	public Aluno[] getAprovados() {
		return aprovados;
	}

	public void setAprovados(Aluno[] aprovados) {
		this.aprovados = aprovados;
	}

	public int getQuantAluno() {
		return quantAluno;
	}

	public void setQuantAluno(int quantAluno) {
		this.quantAluno = quantAluno;
	}
	
	
}
