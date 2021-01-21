package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static Connection conexao = null;
	
	private Conexao() {
		
	}
	
	public static Connection getConexao() throws ClassNotFoundException , SQLException {
		if( conexao == null ) {
			String url = "jdbc:postgresql://localhost:5432/clinica";
			String username = "postgres";
			String password = "12345";
			try {
				Class.forName("org.postgresql.Driver");
				conexao = DriverManager.getConnection(url, username, password);
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		
		return conexao;
	}
}
