package dados;

public class ContaSalario extends ContaBancaria{
	private int cpnjEmpresa;
	
	public ContaSalario(){
		super();
	}
	
	public boolean depositar(float valor , int cpnjEmpresa){
		if(cpnjEmpresa == this.cpnjEmpresa ) {
			this.saldo += valor;
			return true;
		}
		return false;
	}
	
	public String gerarExtrato(){
		return "Conta Salario:\n" + "CNPJ da Empresa: " + this.cpnjEmpresa + " \n" + super.gerarExtrato();
	}
	
	public String toString(){
		return "Conta Salario:\n" + super.toString() + "\n" + "CNPJ: " + this.cpnjEmpresa;
	}

	public int getCpnjEmpresa() {
		return cpnjEmpresa;
	}

	public void setCpnjEmpresa(int cpnjEmpresa) {
		this.cpnjEmpresa = cpnjEmpresa;
	}
	
	
}
