package negocio;

import java.util.List;

import dados.Pessoa;
import persistencia.PessoaDAO;

public class Sistema {
	private PessoaDAO pessoaDAO = new PessoaDAO();
	
	public void adicionarPessoa(Pessoa p) {
		int i = 0;
		for(Pessoa pessoa : getList()) {
			if(p.equals(pessoa)) {
				System.out.println("Pessoa ja existe.");
				i++;
			}
		}
		if(i == 0)
			pessoaDAO.insert(p);
	}
	
	public void removerPessoa(Pessoa p) {
		pessoaDAO.delete(p);
	}
	
	public List<Pessoa> getList(){
		return pessoaDAO.getAll();
	}
}
