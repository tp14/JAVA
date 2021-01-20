package dados;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Animal implements Sujeito {
	Random rand = new Random();
	private String nome;
	private Posicao posicao;
	private List<Observador> observadores = new ArrayList<Observador>();
	
	public void adicionar(Observador observador) {
		observadores.add(observador);
	}

	public void remover(Observador observador) {
		observadores.remove(observador);
	}

	public void notificar() {
		for(Observador o :observadores)
			o.atualizar(posicao);
	}
	
	public void andaFrente() {
		posicao.setY( posicao.getY() + 3);
		notificar();
	}
	
	public void andaTras() {
		posicao.setY( posicao.getY() - 3);
		notificar();
	}
	
	public void andaDireita() {
		posicao.setX( posicao.getX() + 3);
		notificar();
	}
	
	public void andaEsquerda() {
		posicao.setX( posicao.getX() - 3);
		notificar();
	}
	
	public Posicao movimentar() {
		int op = rand.nextInt(3);
		if(op ==0) 
			andaFrente();
		if(op == 1)
			andaTras();
		if(op == 2)
			andaDireita();	
			else
				andaEsquerda();
		notificar();
		return posicao;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

	public List<Observador> getObservadores() {
		return observadores;
	}

	public void setObservadores(List<Observador> observadores) {
		this.observadores = observadores;
	}
}
