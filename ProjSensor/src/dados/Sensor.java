package dados;

public class Sensor implements Observador {
	private Posicao posicaoSensor;
	private Posicao posicaoAnimal;
	
	public void atualizar(Object objeto) {
		posicaoAnimal = (Posicao) objeto;	
	}
	
	public double calcularDistancia() {
		return Math.sqrt(Math.pow(posicaoAnimal.getX() - posicaoSensor.getX(),2) + Math.pow(posicaoAnimal.getY() - posicaoSensor.getY(),2));
	}

	public Posicao getPosicaoSensor() {
		return posicaoSensor;
	}

	public void setPosicaoSensor(Posicao posicaoSensor) {
		this.posicaoSensor = posicaoSensor;
	}
}
