package dados;

public class Main {

	public static void main(String[] args) {
		Animal animal = new Animal();
		Posicao p1 = new Posicao();
		Posicao p2 = new Posicao();
		Posicao p3 = new Posicao();
		Posicao p4 = new Posicao();
		Sensor s1 = new Sensor();
		Sensor s2 = new Sensor();
		Sensor s3 = new Sensor();
		
		p1.setX(0);
		p1.setY(0);
		p2.setX(10);
		p2.setY(10);
		p3.setX(20);
		p3.setY(20);
		p4.setX(30);
		p4.setY(30);
		
		s1.setPosicaoSensor(p2);
		s2.setPosicaoSensor(p3);
		s3.setPosicaoSensor(p4);
		
		animal.setNome("gato");
		animal.setPosicao(p1);
		animal.adicionar(s1);
		animal.adicionar(s2);
		animal.adicionar(s3);
		animal.notificar();
		
		for(int i=0; i < 5; i++) {
			System.out.println("Movimentacao " + i + ":");
			System.out.println(animal.getPosicao().toString());
			System.out.println(s1.calcularDistancia());
			System.out.println(s2.calcularDistancia());
			System.out.println(s3.calcularDistancia());
			animal.movimentar();
			System.out.println(animal.getPosicao().toString());
			System.out.println(s1.calcularDistancia());
			System.out.println(s2.calcularDistancia());
			System.out.println(s3.calcularDistancia());
		}
	}
}
