package ClinicaVeterinaria.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	private final static String url = "jdbc:postgresql://ec2-52-202-22-140.compute-1.amazonaws.com:5432/dkq634i2hl99o";
	private final static String user = "glikmsysebgpaw";
	private final static String password = "2ebd0404aca7bb90690b787e16a61d47e25cbc53cbdb076c99e65607a87da66c";
	private static Connection conn = null;
	private final static boolean APAGAR_DADOS = false;

	public static Connection getConnection() {
		if (conn == null) {
			Statement statement = null;
			try {
				conn = DriverManager.getConnection(url, user, password);

				statement = conn.createStatement();

				if (APAGAR_DADOS) {
					statement.execute("DELETE FROM Animais");
					statement.execute("DELETE FROM Clientes");
					
					statement.execute("DROP TABLE Animais");
					statement.execute("DROP TABLE Clientes");
				}

				statement.execute(
						"CREATE TABLE IF NOT EXISTS Clientes(idCliente SERIAL PRIMARY KEY, nomCli VARCHAR(100), endCli VARCHAR(100), telCli VARCHAR(100), cepCli VARCHAR(100), emailCli VARCHAR(100))");
				statement.execute(
						"CREATE TABLE IF NOT EXISTS Animais(idAnimal SERIAL PRIMARY KEY, nomeAnimal VARCHAR(100), idadeAnimal INTEGER, sexoAnimal VARCHAR(1), idEspecie INTEGER, nomeEspecie VARCHAR(100), idCliente INTEGER, FOREIGN KEY(idCliente) REFERENCES Clientes(idCliente))");

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return conn;
	}

	public static void closeConnection() {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
		}
	}

	public static void closePreparedStatement(PreparedStatement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
			}
		}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
	}
}
