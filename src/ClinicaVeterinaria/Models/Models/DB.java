package ClinicaVeterinaria.Models.Models;

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
					
					statement.execute("DROP TABLE Tratamentos CASCADE");
					statement.execute("DROP TABLE Consultas CASCADE");
					statement.execute("DROP TABLE Exames CASCADE");
					statement.execute("DROP TABLE Veterinarios CASCADE");
					statement.execute("DROP TABLE Especies CASCADE");
					statement.execute("DROP TABLE Animais CASCADE");
					statement.execute("DROP TABLE Clientes CASCADE");
				}

				statement.execute(
						"CREATE TABLE IF NOT EXISTS Clientes(idCliente SERIAL PRIMARY KEY, nomCli VARCHAR(100), endCli VARCHAR(100), telCli VARCHAR(100), cepCli VARCHAR(100), emailCli VARCHAR(100))");
				statement.execute(
						"CREATE TABLE IF NOT EXISTS Especies(idEspecie SERIAL PRIMARY KEY, nomeEspecie VARCHAR(100))");
				statement.execute(
						"CREATE TABLE IF NOT EXISTS Animais(idAnimal SERIAL PRIMARY KEY, nomeAnimal VARCHAR(100), idadeAnimal INTEGER, sexoAnimal VARCHAR(1), idEspecie INTEGER, idCliente INTEGER, FOREIGN KEY(idCliente) REFERENCES Clientes(idCliente), FOREIGN KEY(idEspecie) REFERENCES Especies(idEspecie))");				
				statement.execute(
						"CREATE TABLE IF NOT EXISTS Veterinarios(idVeterinario SERIAL PRIMARY KEY, nomeVeterinario VARCHAR(100), enderecoVeterinario VARCHAR(100), telefoneVeterinario VARCHAR(15))");
				statement.execute(
						"CREATE TABLE IF NOT EXISTS Tratamentos(idTratamento SERIAL PRIMARY KEY, dataInicial TIMESTAMP, dataFinal TIMESTAMP, idAnimal INTEGER, FOREIGN KEY(idAnimal) REFERENCES Animais(idAnimal))");
				statement.execute(
						"CREATE TABLE IF NOT EXISTS Consultas(idConsulta SERIAL PRIMARY KEY, dataConsulta TIMESTAMP, idVeterinario INTEGER, historicoConsulta VARCHAR(1000), idTratamento INTEGER, FOREIGN KEY(idTratamento) REFERENCES Tratamentos(idTratamento), FOREIGN KEY(idVeterinario) REFERENCES Veterinarios(idVeterinario))");
				statement.execute(
						"CREATE TABLE IF NOT EXISTS Exames(idExame SERIAL PRIMARY KEY, descricaoExame VARCHAR(100), idConsulta INTEGER, FOREIGN KEY(idConsulta) REFERENCES Consultas(idConsulta))");

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
