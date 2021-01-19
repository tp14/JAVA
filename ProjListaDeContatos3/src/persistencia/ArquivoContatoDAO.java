package persistencia;

import java.util.ArrayList;
import exceptions.ErroNaGravacaoException;
import exceptions.ErroNaLeituraException;
import java.util.List;
import dados.Contato;

public class ArquivoContatoDAO {
	private final String caminho = "/home/pimenta/VScode/POO/AulaPratica09/AulaPratica09Ex01/contatos.csv";
	private EditorTexto editorArquivo = new EditorTexto();
	
	private String toCSV(Contato contato) {
		String c = "";
		
		c += contato.getNome() + ",";
		c += contato.getTelefone() + "\n";
		
		return c;
	}
	
	private Contato fromCSV(String linhaCSV) {
		String atributos[] = linhaCSV.split(",");
		
		Contato contato = new Contato();
		contato.setNome(atributos[0]);
		contato.setTelefone(atributos[1]);
		
		return contato;
	}
	
	private List<String> listaContatoToString(List<Contato> contato){
		List<String> listaContatos = new ArrayList<String>();
		
		for(Contato c : contato)
			listaContatos.add(toCSV(c));
		
		return listaContatos;
	}
	
	private List<Contato> stringToListaContato(List<String> listaContatos){
		List<Contato> contatos = new ArrayList<Contato>();
		
		for(String c : listaContatos) {
			contatos.add(fromCSV(c));
		}
		return contatos;
	}
	
	public List<Contato> leContatos() throws ErroNaLeituraException{
		return stringToListaContato(editorArquivo.leTexto(caminho));
	}
	
	public void salvaContato(Contato contato) throws ErroNaGravacaoException{
		editorArquivo.gravaTexto(caminho, toCSV(contato));
	}
	
	public void salvaContatos(List<Contato> contatos) throws ErroNaGravacaoException{
		editorArquivo.gravaTexto(caminho, listaContatoToString(contatos));
	}
}
