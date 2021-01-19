package persistencia;

import java.util.List;
import dados.Contato;
import exceptions.ContatoJaCadastradoException;
import exceptions.ContatoNaoCadastradoException;
import exceptions.ErroNaGravacaoException;
import exceptions.ErroNaLeituraException;

public class ContatoDAO {
	private ArquivoContatoDAO arquivoContatoDAO = new ArquivoContatoDAO();
	
	public void insert(Contato contato) throws ErroNaLeituraException, ErroNaGravacaoException, ContatoJaCadastradoException{
		List<Contato> contatos = arquivoContatoDAO.leContatos();
		
		if(!contatos.contains(contato))  // Sem o metodo equals ele nao verifica de forma correta
			arquivoContatoDAO.salvaContato(contato); 
		else
			throw new ContatoJaCadastradoException("Contato ja esta cadastrado.");
	}
	
	public void delete(Contato contato) throws ErroNaLeituraException, ErroNaGravacaoException, ContatoNaoCadastradoException{
		List<Contato> contatos = arquivoContatoDAO.leContatos();

		if(!contatos.contains(contato)) {
			contatos.remove(contato);
			arquivoContatoDAO.salvaContatos(contatos);
		}
		else
			throw new ContatoNaoCadastradoException("Contato nao estava cadastrado.");

		arquivoContatoDAO.salvaContatos(contatos);
	}
	
	public List<Contato> getAll() throws ErroNaLeituraException{
		return arquivoContatoDAO.leContatos();
	}
}
