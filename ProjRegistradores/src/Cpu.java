
public class Cpu {
	private Registrador[] cpu = new Registrador[8];
	private int quantRegistrador = 0;
	
	public void addRegistrador(Registrador registrador) {
		if(quantRegistrador < 8) {
			this.cpu[quantRegistrador] = registrador;
			quantRegistrador ++;
		}
	}
	
	public Registrador getRegistradores(int i) {
		return cpu[i];
	}
	
	public void operacaoOr(Registrador r1, Registrador r2, int j) {
		for(int i=0; i<8; i++) {
			if(r1.getRegistrador()[i] == 0 && r2.getRegistrador()[i] == 0) 
				cpu[j].setValor(i, 0);
			else
				cpu[j].setValor(i, 1);		
		}
	}
	
	public void operacaoAnd(Registrador r1, Registrador r2, int j) {
		for(int i=0; i<8; i++) {
			if(r1.getRegistrador()[i] == 1 && r2.getRegistrador()[i] == 1) 
				cpu[j].setValor(i, 1);
			else
				cpu[j].setValor(i, 0);
		}
	}
	
	public Registrador[] getCpu() {
		return cpu;
	}

	public void setCpu(Registrador[] cpu) {
		this.cpu = cpu;
	}
}
