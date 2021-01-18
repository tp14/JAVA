package dados;

public class ContaBancaria {
	private int cpf;
	protected float saldo;
	
	public ContaBancaria() {
		this.saldo = 0 ;
	}
	
	public float sacar(float valor){
		saldo -= valor;
		return valor;
	}
	
	public String gerarExtrato( ){
		return "Saldo disponivel: R$" + this.saldo;
	}
	
	public String toString(){
		return "CPF : " + this.cpf;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

}
