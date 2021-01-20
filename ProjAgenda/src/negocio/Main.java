package negocio;

import dados.*;

public class Main {

	public static void main(String[] args) {
		AgendaComposite agenda = new AgendaComposite();
		
		Ano ano20 = new Ano(2020);
		Ano ano21 = new Ano(2021);
		Ano ano22 = new Ano(2022);
		Ano ano23 = new Ano(2023);
		Ano ano24 = new Ano(2024);
		
		Mes mes1 = new Mes(1,"Janeiro");
		Mes mes2 = new Mes(2,"Fevereiro");
		Mes mes3 = new Mes(3,"Marco");
		Mes mes4 = new Mes(4,"Abril");
		Mes mes5 = new Mes(5,"Maio");
		
		Dia dia1 = new Dia(01, "Segunda");
		Dia dia2 = new Dia(02, "Terca");
		Dia dia3 = new Dia(03, "Quarta");
		Dia dia4 = new Dia(04, "Quinta");
		Dia dia5 = new Dia(05, "Sexta");
		
		Evento evento1 = new Evento(20, "Aniversario");
		Evento evento2 = new Evento(17, "Cafe");
		Evento evento3 = new Evento(15, "Reuniao");
		Evento evento4 = new Evento(21, "Show");
		Evento evento5 = new Evento(12, "Almoco");

		agenda.adicionarAno(ano20);
		agenda.adicionaMes(mes3,ano20);
		agenda.adicionaDia(dia2, mes3, ano20);
		agenda.adicionaEvento(evento1, dia2, mes3, ano20);
		
		agenda.adicionarAno(ano22);
		agenda.adicionaMes(mes4,ano22);
		agenda.adicionaDia(dia3, mes4, ano22);
		agenda.adicionaEvento(evento2, dia3, mes4, ano22);
		
		agenda.adicionarAno(ano21);
		agenda.adicionaMes(mes2,ano21);
		agenda.adicionaDia(dia1, mes2, ano21);
		agenda.adicionaEvento(evento5, dia1, mes2, ano21);
		
		agenda.adicionarAno(ano23);
		agenda.adicionaMes(mes5,ano23);
		agenda.adicionaDia(dia4, mes5, ano23);
		agenda.adicionaEvento(evento3, dia4, mes5, ano23);
		
		agenda.adicionarAno(ano24);
		agenda.adicionaMes(mes1,ano24);
		agenda.adicionaDia(dia5, mes1, ano24);
		agenda.adicionaEvento(evento4, dia5, mes1, ano24);
		
		System.out.println(agenda);
	}

}
