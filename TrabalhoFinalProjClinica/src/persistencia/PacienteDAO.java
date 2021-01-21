package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dados.Paciente;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class PacienteDAO {
	private static PacienteDAO instance = null;
	
	private PreparedStatement newId;
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement getAll;
	private PreparedStatement getPaciente;
	
	private PacienteDAO() throws ClassNotFoundException, SQLException {
		
		Connection conexao = Conexao.getConexao();
		
		newId = conexao.prepareStatement("select nextval('id_paciente')");
		insert = conexao.prepareStatement("insert into paciente values(?,?,?,?,?,?)");
		update = conexao.prepareStatement("update paciente set nome = ?, idade = ?, cpf = ?, cidade = ?, descricao = ? where id = ?");
		delete = conexao.prepareStatement("delete from paciente where id = ?");
		getAll = conexao.prepareStatement("select * from paciente"); 
		getPaciente = conexao.prepareStatement("select * from paciente where id =?");
		
	}
	
	public static PacienteDAO getInstance() throws ClassNotFoundException, SQLException {
		
		if(instance == null)
			instance = new PacienteDAO();
		
		return instance;
	}
	
	public int newId() throws SelectException {
		
		try {
			ResultSet rs = newId.executeQuery();
			if(rs.next())
				return rs.getInt(1);
				
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel gerar um novo id para o paciente.");
		}
		
		return 0;
	}
	
	public void insert(Paciente paciente) throws InsertException {
		
		try {
			paciente.setCodigo(newId());
			insert.setInt(1, paciente.getCodigo());
			insert.setString(2, paciente.getNome());
			insert.setInt(3, paciente.getIdade());
			insert.setLong(4, paciente.getCpf());
			insert.setString(5, paciente.getCidade());
			insert.setString(6, paciente.getDescricao());
			insert.executeUpdate();
		} 
		catch (Exception e) {
			throw new InsertException("Nao foi possivel inserir o paciente.");
		}	
	}
	
	public void update(Paciente paciente) throws UpdateException {
		
		try {
			update.setString(1, paciente.getNome());
			update.setInt(2, paciente.getIdade());
			update.setLong(3, paciente.getCpf());
			update.setString(4, paciente.getCidade());
			update.setString(5, paciente.getDescricao());
			update.setInt(6, paciente.getCodigo());
			update.executeUpdate();
		} 
		catch (Exception e) {
			throw new UpdateException("Nao foi possivel atualizar o paciente.");
		}	
	}
	
	public void delete(Paciente paciente) throws DeleteException {
		try {
			delete.setInt(1, paciente.getCodigo());
			delete.executeUpdate();
		} 
		catch (Exception e) {
			throw new DeleteException("Erro na delecao do paciente.");
		}	
	}
	
	public List<Paciente> getAll() throws SelectException {
		List<Paciente> pacientes = new ArrayList<Paciente>();
		Paciente paciente = null;
		
		try {
			ResultSet rs = getAll.executeQuery();
			while(rs.next()) {
				paciente = new Paciente();
				paciente.setCodigo(rs.getInt("id"));
				paciente.setNome(rs.getString("nome"));
				paciente.setIdade(rs.getInt("idade"));
				paciente.setCpf(rs.getLong("cpf"));
				paciente.setCidade(rs.getString("cidade"));
				paciente.setDescricao(rs.getString("descricao"));
				
				pacientes.add(paciente);
			}
			
			return pacientes;
		} 
		catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar o paciente.");
		}
	}
	
	public Paciente getPaciente(int codigo) throws SelectException {
		Paciente paciente = null;
		
		try {
			getPaciente.setInt(1, codigo);
			ResultSet rs = getPaciente.executeQuery();
			while(rs.next()) {
				paciente = new Paciente();
				paciente.setCodigo(rs.getInt("id"));
				paciente.setNome(rs.getString("nome"));
				paciente.setIdade(rs.getInt("idade"));
				paciente.setCpf(rs.getLong("cpf"));
				paciente.setCidade(rs.getString("cidade"));
				paciente.setDescricao(rs.getString("descricao"));
			}
			
			return paciente;
		} 
		catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar o paciente.");
		}
	}
}

