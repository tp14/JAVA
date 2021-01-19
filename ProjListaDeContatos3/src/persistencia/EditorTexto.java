package persistencia;

import java.io.BufferedReader;
import exceptions.ErroNaGravacaoException;
import exceptions.ErroNaLeituraException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class EditorTexto {
	
	public void gravaTexto(String caminho, List<String> dados) throws ErroNaGravacaoException{
		Writer arquivo;
		
		try {
			arquivo = new FileWriter(caminho);
			
			for(String i : dados)
				arquivo.write(i);
			
			arquivo.close();
		}
		catch(IOException e) {
			ErroNaGravacaoException erro = new ErroNaGravacaoException("Erro na gravacao dos contatos no arquivo.");
			erro.setCaminho(caminho);
			throw erro; 
		}
	}
	
	public void gravaTexto(String caminho, String linha) throws ErroNaGravacaoException {
		Writer arquivo;
		
		try {
			arquivo = new FileWriter(caminho, true); // coloca o true para adicionar no final do arquivo em vez de sobrescrever
			arquivo.write(linha);
			arquivo.close();
		}
		catch(IOException e) {
			ErroNaGravacaoException erro = new ErroNaGravacaoException("Erro na gravacao do contato no aquivo.");
			erro.setCaminho(caminho);
			throw erro;
		}
	}
	
	public List<String> leTexto(String caminho) throws ErroNaLeituraException {
		List<String> dados = new ArrayList<String>();
		Reader arquivo;
		BufferedReader r;
		
		try {
			arquivo = new FileReader(caminho);
			r = new BufferedReader(arquivo);
			String s = r.readLine();
			
			while(s != null) {
				dados.add(s);
				s = r.readLine();
			}
			
			arquivo.close();
		}
		catch(IOException e) {
			ErroNaLeituraException  erro = new ErroNaLeituraException("Erro na leitura do arquivo de contatos.");
			erro.setCaminho(caminho);
			throw erro;
		}
		
		return dados;
	}
}
