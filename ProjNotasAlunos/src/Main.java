
import java.util.Scanner;

public class Main {
	private static Scanner in = new Scanner(System.in);
	private static Turma turma = new Turma();
	
	public static void main(String[] args) {
		int op = -1;
		
		while(op != 0) {
			System.out.println("1- Adicionar aluno\n2- Listar alunos aprovados\n0- Sair");
			op = in.nextInt();
			in.nextLine();
			
		switch(op) {
			case 1:
				adicionarAluno();
				break;
			case 2:
				listarAprovado();
				break;
			case 0:
				break;
		}
		}
		in.close();
	}
	
	public static void listarAprovado() {
		turma.listarAprovados();
	}
	
	public static void adicionarAluno() {
		 Aluno aluno = new Aluno();
		
		System.out.println("Nome");
		aluno.setNomeAluno(in.nextLine());
		System.out.println("Nota 1");
		aluno.setN1(in.nextDouble());
		in.nextLine();
		System.out.println("Nota 2");
		aluno.setN2(in.nextDouble());
		in.nextLine();
		System.out.println("Nota 3");
		aluno.setN3(in.nextDouble());
		in.nextLine();
		System.out.println("Nota 4");
		aluno.setN4(in.nextDouble());
		in.nextLine();
		System.out.println("Nota 5");
		aluno.setN5(in.nextDouble());
		in.nextLine();
		
		turma.adicionarAluno(aluno);
	}
	
}
