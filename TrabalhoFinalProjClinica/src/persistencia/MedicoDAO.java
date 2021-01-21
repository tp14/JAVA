package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dados.Medico;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class MedicoDAO {
	private static MedicoDAO instance = null;
	
	private PreparedStatement newId;
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement getMedico;
	private PreparedStatement getAll;
	
	private MedicoDAO() throws ClassNotFoundException, SQLException {
		
		Connection conexao = Conexao.getConexao();
		
		newId = conexao.prepareStatement("select nextval('id_medico')");
		insert = conexao.prepareStatement("insert into medico values(?,?,?,?,?,?)");
		update = conexao.prepareStatement("update medico set nome = ?, idade = ?, cpf = ?, cidade = ?, especialidade = ? where id = ?");
		delete = conexao.prepareStatement("delete from medico where id = ?");
		getAll = conexao.prepareStatement("select * from medico"); 
		getMedico = conexao.prepareStatement("select * from medico where id =?");
		
	}
	
	public static MedicoDAO getInstance() throws ClassNotFoundException, SQLException {
		
		if(instance == null)
			instance = new MedicoDAO();
		
		return instance;
	}
	
	public int newId() throws SelectException {
		
		try {
			ResultSet rs = newId.executeQuery();
			if(rs.next())
				return rs.getInt(1);
				
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel gerar um novo id para o medico.");
		}
		
		return 0;
	}
	
	public void insert(Medico medico) throws InsertException {
		
		try {
			medico.setCodigo(newId());
			insert.setInt(1, medico.getCodigo());
			insert.setString(2, medico.getNome());
			insert.setInt(3, medico.getIdade());
			insert.setLong(4, medico.getCpf());
			insert.setString(5, medico.getCidade());
			insert.setString(6, medico.getEspecialidade());
			insert.executeUpdate();
		} 
		catch (Exception e) {
			throw new InsertException("Nao foi possivel inserir o medico.");
		}	
	}
	
	public void update(Medico medico) throws UpdateException {
		
		try {
			update.setString(1, medico.getNome());
			update.setInt(2, medico.getIdade());
			update.setLong(3, medico.getCpf());
			update.setString(4, medico.getCidade());
			update.setString(5, medico.getEspecialidade());
			update.setInt(6, medico.getCodigo());
			update.executeUpdate();
		} 
		catch (Exception e) {
			throw new UpdateException("Nao foi possivel atualizar o medico.");
		}	
	}
	
	public void delete(Medico medico) throws DeleteException {
		
		try {
			delete.setInt(1, medico.getCodigo());
			delete.executeUpdate();
		} 
		catch (Exception e) {
			throw new DeleteException("Erro na delecao do medico.");
		}	
	}
	
	public List<Medico> getAll() throws SelectException {
		List<Medico> medicos = new ArrayList<Medico>();
		Medico medico = null;
		
		try {
			ResultSet rs = getAll.executeQuery();
			while(rs.next()) {
				medico = new Medico();
				medico.setCodigo(rs.getInt("id"));
				medico.setNome(rs.getString("nome"));
				medico.setIdade(rs.getInt("idade"));
				medico.setCpf(rs.getLong("cpf"));
				medico.setCidade(rs.getString("cidade"));
				medico.setEspecialidade(rs.getString("especialidade"));
				
				medicos.add(medico);
			}
			return medicos;
		} 
		catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar o medico.");
		}
	}
	
	public Medico getMedico(int codigo) throws SelectException {
		Medico medico = null;
		
		try {
			getMedico.setInt(1, codigo);
			ResultSet rs = getMedico.executeQuery();
			while(rs.next()) {
				medico = new Medico();
				medico.setCodigo(rs.getInt("id"));
				medico.setNome(rs.getString("nome"));
				medico.setIdade(rs.getInt("idade"));
				medico.setCpf(rs.getLong("cpf"));
				medico.setCidade(rs.getString("cidade"));
				medico.setEspecialidade(rs.getString("especialidade"));
			}
			
			return medico;
		} 
		catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar o medico.");
		}
	}
}
