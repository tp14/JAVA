package negocio;

import java.util.LinkedList;
import java.util.List;

import composite.Componente;
import composite.Folha;
import composite.Galho;
import dados.Ano;
import dados.Dia;
import dados.Evento;
import dados.Mes;

public class AgendaComposite {
	private List<Componente<Ano>> anos = new LinkedList<Componente<Ano>>();
	
	public void adicionarAno(Ano ano) {
		Componente<Ano> compAno = new Galho<Ano>();
		compAno.setObjeto(ano); 
		compAno.setNivel(0);
		anos.add(compAno);
	}
	
	public void adicionaMes(Mes mes, Ano ano) {
		for(Componente<Ano> comp : anos) {
			if(comp.getObjeto().equals(ano)) {
				Galho<Ano> compAno = (Galho<Ano>) comp;
				compAno.adiciona(new Galho<Mes>(mes));
			}	
		}
	}
	
	public void adicionaDia(Dia dia, Mes mes, Ano ano) {
		for(Componente<Ano> comp : anos) {
			if(comp.getObjeto().equals(ano)) {
				Galho<Ano> compAno = (Galho<Ano>) comp;
				for(Componente comp2 : compAno.getComponentes()) {
					if(comp2.getObjeto().equals(mes)) {
						Galho<Mes> compMes = (Galho<Mes>) comp2;
						compMes.adiciona(new Galho<Dia>(dia));
					}
				}
			}	
		}
	}
	
	public void adicionaEvento(Evento evento, Dia dia, Mes mes, Ano ano) {
		for(Componente<Ano> comp : anos) {
			if(comp.getObjeto().equals(ano)) {
				Galho<Ano> compAno = (Galho<Ano>) comp;
				for(Componente comp2 : compAno.getComponentes()) {
					if(comp2.getObjeto().equals(mes)) {
						Galho<Mes> compMes = (Galho<Mes>) comp2;
						for(Componente comp3 : compMes.getComponentes()) {
							if(comp3.getObjeto().equals(dia)) {
								Galho<Dia> compDia = (Galho<Dia>) comp3;
								compDia.adiciona(new Folha<Evento>(evento));
							}
						}
					}
				}
			}	
		}			
	}

	public String toString() {
		StringBuilder desenho = new StringBuilder();
		
		for(int i=0; i < anos.size(); i++) {
			desenho.append(anos.get(i).getDesenho());
		}
		
		return desenho.toString();
	}

	public List<Componente<Ano>> getAnos() {
		return anos;
	}

	public void setAnos(List<Componente<Ano>> anos) {
		this.anos = anos;
	}	
}
