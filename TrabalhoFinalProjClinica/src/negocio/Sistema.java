package negocio;

import java.sql.SQLException;
import java.util.List;

import dados.*;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;
import persistencia.ConsultaDAO;
import persistencia.MedicoDAO;
import persistencia.PacienteDAO;

public class Sistema {
		
	public void cadastrarMedico(Medico medico) throws InsertException, ClassNotFoundException, SQLException {
		MedicoDAO.getInstance().insert(medico);
	}
	
	public void cadastrarPaciente(Paciente paciente) throws InsertException, ClassNotFoundException, SQLException {
		PacienteDAO.getInstance().insert(paciente);
	}
	
	public void cadastrarConsulta(Consulta consulta) throws InsertException, ClassNotFoundException, SQLException {
		ConsultaDAO.getInstance().insert(consulta);
	}
	
	public List<Medico> buscarMedicos() throws SelectException, ClassNotFoundException, SQLException{
		return MedicoDAO.getInstance().getAll();
	}
	
	public List<Paciente> buscarPacientes() throws SelectException, ClassNotFoundException, SQLException{
		return PacienteDAO.getInstance().getAll();
	}
	
	public List<Consulta> buscarConsultas() throws SelectException, ClassNotFoundException, SQLException{
		return ConsultaDAO.getInstance().getAll();
	}
	
	public void removerMedico(Medico medico) throws DeleteException, ClassNotFoundException, SQLException {
		MedicoDAO.getInstance().delete(medico);
	}
	
	public void removerPaciente(Paciente paciente) throws DeleteException, ClassNotFoundException, SQLException {
		PacienteDAO.getInstance().delete(paciente);
	}
	
	public void removerConsulta(Consulta consulta) throws DeleteException, ClassNotFoundException, SQLException {
		ConsultaDAO.getInstance().delete(consulta);
	}
	
	public void alterarMedico(Medico medico) throws UpdateException, ClassNotFoundException, SQLException { 
		MedicoDAO.getInstance().update(medico);
	}
	
	public void alterarPaciente(Paciente paciente) throws UpdateException, ClassNotFoundException, SQLException {
		PacienteDAO.getInstance().update(paciente);
	}
	
	public void alterarConsulta(Consulta consulta) throws UpdateException, ClassNotFoundException, SQLException {
		ConsultaDAO.getInstance().update(consulta);
	}

	public Medico getMedico(int codigo) throws SelectException, ClassNotFoundException, SQLException {
		return MedicoDAO.getInstance().getMedico(codigo);
	}
	
	public Paciente getPaciente(int codigo) throws SelectException, ClassNotFoundException, SQLException {
		return PacienteDAO.getInstance().getPaciente(codigo);
	}
	
	public Consulta getConsulta(int codigo) throws SelectException, ClassNotFoundException, SQLException {
		return ConsultaDAO.getInstance().getConsulta(codigo);
	}
}
