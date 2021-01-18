package dados;

public class ContaCorrente extends ContaBancaria {
	
	public ContaCorrente(){
		super();
	}
	
	public boolean depositar(float valor){
		this.saldo += valor;
		return true;
	}
	
	public String gerarExtrato(){
		return "Conta Corrente:\n" + super.toString() + "\n" + super.gerarExtrato();
	}

	public String toString(){
		return "Conta Corrente:\n" + super.toString();
	}

}
