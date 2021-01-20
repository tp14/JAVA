import java.util.Scanner;

public class Main {
	private static Scanner in = new Scanner(System.in);
	private static Cpu cpu = new Cpu();
	
	public static void main(String[] args) {
		int op = -1;
		
		while(op != 0) {
			System.out.println("1- Adicionar Registrador\n2- Mostar Registrador de 0 a 7\n3- Operacao OR\n4- Operacao AND\n0- Sair");
			op = in.nextInt();
			in.nextLine();
			
		switch(op) {
			case 1:
				addRegistrador();
				break;
			case 2:
				getRegistradores();
				break;
			case 3:
				operacaoOr();
				break;
			case 4:
				operacaoAnd();
				break;
			case 0:
				break;
		}
		}
		in.close();
	}
	
	public static void addRegistrador() {
		Registrador registrador = new Registrador();
		
		if(cpu.getRegistradores(7) == null) {
			System.out.println("Digite os 8 valores do registrador");
			for(int i=0; i<8; i++) {
				registrador.setValor(i, in.nextInt());
				in.nextLine();
			}
		
			cpu.addRegistrador(registrador);
		}else
			System.out.println("Memoria cheia\n");
	}
	
	public static void getRegistradores(){
		int reg;
		
		System.out.println("Escolha um registrador de 0 a 7:");
		reg = in.nextInt();
		in.nextLine();
		
		System.out.println(cpu.getRegistradores(reg));
	}
	
	public static void operacaoOr() {
		int r1, r2, r3;
		
		System.out.println("Escolha tres registradores de 0 a 7, os dois primeiros para realizar a operacao e um para receber o resultado:");
		r1 = in.nextInt();
		in.nextLine();
		r2 = in.nextInt();
		in.nextLine();
		r3 = in.nextInt();
		in.nextLine();
		
		if(cpu.getRegistradores(r3) == null)
			System.out.println("Erro terceiro registrador null, iniciealize um para realizar a operacao ou escolha um registrador nao nulo:");
		else 
			cpu.operacaoOr(cpu.getRegistradores(r1), cpu.getRegistradores(r2), r3);
	}
	
	public static void operacaoAnd() {
		int r1, r2, r3;
		
		System.out.println("Escolha tres registradores de 0 a 7, os dois primeiros para realizar a operacao e um para receber o resultado:");
		r1 = in.nextInt();
		in.nextLine();
		r2 = in.nextInt();
		in.nextLine();
		r3 = in.nextInt();
		in.nextLine();
		
		if(cpu.getRegistradores(r3) == null)
			System.out.println("Erro terceiro registrador null, iniciealize um para realizar a operacao ou escolha um registrador nao nulo:");
		else 
		cpu.operacaoAnd(cpu.getRegistradores(r1), cpu.getRegistradores(r2), r3);
	}
}
