package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dados.Consulta;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class ConsultaDAO {
	private static ConsultaDAO instance = null;
	
	private PreparedStatement newId;
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement getAll;
	private PreparedStatement getConsulta;
	MedicoDAO medicoDAO;
	PacienteDAO pacienteDAO;
	
	private ConsultaDAO() throws ClassNotFoundException, SQLException {
		
		Connection conexao = Conexao.getConexao();
		
		newId = conexao.prepareStatement("select nextval('id_consulta')");
		insert = conexao.prepareStatement("insert into consulta values(?,?,?,?,?,?,?)");
		update = conexao.prepareStatement("update consulta set valor = ?, data = ?, hora = ?, diagnostico = ?, id_medico = ?, id_paciente = ? where id = ?");
		delete = conexao.prepareStatement("delete from consulta where id = ?");
		getAll = conexao.prepareStatement("select * from consulta"); 
		getConsulta = conexao.prepareStatement("select * from consulta where id =?");
		
		medicoDAO = MedicoDAO.getInstance();
		pacienteDAO = PacienteDAO.getInstance();
	}
	
	public static ConsultaDAO getInstance() throws ClassNotFoundException, SQLException {
		
		if(instance == null)
			instance = new ConsultaDAO();
		
		return instance;
	}
	
	public int newId() throws SelectException {
		
		try {
			ResultSet rs = newId.executeQuery();
			if(rs.next())
				return rs.getInt(1);
				
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel gerar um novo id para a consulta.");
		}
		
		return 0;
	}
	
	public void insert(Consulta consulta) throws InsertException {
		
		try {
			consulta.setCodigo(newId());
			insert.setInt(1, consulta.getCodigo());
			insert.setDouble(2, consulta.getValor());
			insert.setDate(3, consulta.getData());
			insert.setTime(4, consulta.getHorario());
			insert.setString(5, consulta.getDiagnostico());
			insert.setInt(6, consulta.getMedico().getCodigo());
			insert.setInt(7, consulta.getPaciente().getCodigo());
			insert.executeUpdate();
		} 
		catch (Exception e) {
			throw new InsertException("Nao foi possivel inserir a consulta.");
		}	
	}
	
	public void update(Consulta consulta) throws UpdateException {
		try {
			update.setDouble(1, consulta.getValor());
			update.setDate(2, consulta.getData());
			update.setTime(3, consulta.getHorario());
			update.setString(4, consulta.getDiagnostico());
			update.setInt(5, consulta.getMedico().getCodigo());
			update.setInt(6, consulta.getPaciente().getCodigo());
			update.setInt(7, consulta.getCodigo());
			update.executeUpdate();
		} 
		catch (Exception e) {
			throw new UpdateException("Nao foi possivel atualizar a consulta.");
		}	
	}
	
	public void delete(Consulta consulta) throws DeleteException {
		
		try {
			delete.setInt(1, consulta.getCodigo());
			delete.executeUpdate();
		} 
		catch (Exception e) {
			throw new DeleteException("Erro na delecao da consulta.");
		}	
	}
	
	public List<Consulta> getAll() throws SelectException {
		List<Consulta> consultas = new ArrayList<Consulta>();
		Consulta consulta = null;
		
		try {
			ResultSet rs = getAll.executeQuery();
			while(rs.next()) {
				consulta = new Consulta();
				consulta.setCodigo(rs.getInt("id"));
				consulta.setValor(rs.getFloat("valor"));
				consulta.setData(rs.getDate("data"));
				consulta.setHorario(rs.getTime("hora"));
				consulta.setDiagnostico(rs.getString("diagnostico"));
				consulta.setMedico(medicoDAO.getMedico(rs.getInt("id_medico")));
				consulta.setPaciente(pacienteDAO.getPaciente(rs.getInt("id_paciente")));
				
				consultas.add(consulta);
			}
			
			return consultas;
		} 
		catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar a consulta.");
		}
	}
	
	public Consulta getConsulta(int codigo) throws SelectException {
		Consulta consulta = null;
		
		try {
			getConsulta.setInt(1, codigo);
			ResultSet rs = getConsulta.executeQuery();
			while(rs.next()) {
				consulta = new Consulta();
				consulta.setCodigo(rs.getInt("id"));
				consulta.setValor(rs.getFloat("valor"));
				consulta.setData(rs.getDate("data"));
				consulta.setHorario(rs.getTime("hora"));
				consulta.setDiagnostico(rs.getString("diagnostico"));
				consulta.setMedico(medicoDAO.getMedico(rs.getInt("id_medico")));
				consulta.setPaciente(pacienteDAO.getPaciente(rs.getInt("id_paciente")));
			}
			
			return consulta;
		} 
		catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar a consulta.");
		}
	}
}
