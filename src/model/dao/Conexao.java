package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Conexão no MYSQL
 * @author Matheus Eloy
 */
public class Conexao {
	private static String user = "root";
    private static String senha = "!bolsa*123";
    private static String url = "jdbc:mysql://localhost:3306/tinnova";

	public static Connection getConexao() {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, user, senha);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
}
