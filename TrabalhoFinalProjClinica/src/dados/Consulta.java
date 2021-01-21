package dados;

import java.sql.Date;
import java.sql.Time;

public class Consulta {
	private int codigo;
	private double valor;
	private Date data;
	private Time horario;
	private String diagnostico;
	private Medico medico;
	private Paciente paciente;
	
	public String toString() {
		return "\n   Codigo: " + codigo + "\n   Valor: " + valor + "\n   Data: " + data + "\n   Horario: " + horario
				+ "\n   Diagnostico: " + diagnostico + "\n   Nome do Medico: " + medico.getNome() + "\n   Codigo do Medico: " + medico.getCodigo() 
				+ "\n   Nome do Paciente: " + paciente.getNome() + "\n   Codigo do Paciente: " + paciente.getCodigo();
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Time getHorario() {
		return horario;
	}
	public void setHorario(Time horario) {
		this.horario = horario;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}
