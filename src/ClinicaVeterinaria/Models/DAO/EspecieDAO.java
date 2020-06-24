package ClinicaVeterinaria.Models.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ClinicaVeterinaria.Models.Models.DB;
import ClinicaVeterinaria.Models.Models.Especie;

public class EspecieDAO {
	private static EspecieDAO instance;

	private EspecieDAO() {
	}

	public static EspecieDAO getInstance() {
		if (instance == null) {
			instance = new EspecieDAO();
		}

		return instance;
	}

	public int addEspecie(String nomeEspecie) {
		PreparedStatement statement = null;
		Connection conn = null;
		ResultSet rs = null;
		int idEspecie = -1;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("INSERT INTO Especies(nomeEspecie) VALUES(?)",
					Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, nomeEspecie);

			statement.executeUpdate();

			rs = statement.getGeneratedKeys();

			if (rs.next())
				idEspecie = rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closePreparedStatement(statement);
		}

		return idEspecie;
	}

	public List<Especie> getAllEspecies() {
		List<Especie> result = new ArrayList<>();
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("SELECT * FROM Especies ORDER BY idEspecie");
			rs = statement.executeQuery();

			while (rs.next()) {
				result.add(buildObject(rs));
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public Especie getEspecieByIdEspecie(int idEspecie) {
		Especie result = null;
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("SELECT * FROM Especies WHERE idEspecie = ? ORDER BY idEspecie");
			statement.setInt(1, idEspecie);

			rs = statement.executeQuery();

			if (rs.next())
            	result = buildObject(rs);

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public Especie getEspecieByNome(String nomeEspecie) {
		Especie result = null;
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("SELECT * FROM Especies WHERE nomeEspecie = ? ORDER BY idEspecie");
			statement.setString(1, nomeEspecie);

			rs = statement.executeQuery();
			
			if (rs.next())
            	result = buildObject(rs);

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public void updateEspecie(int idEspecie, String nomeEspecie) {
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("UPDATE Especies SET nomeEspecie = ? WHERE idEspecie = ?");

			statement.setString(1, nomeEspecie);
			statement.setInt(2, idEspecie);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteEspecie(int idEspecie) {
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("DELETE FROM Especies WHERE idEspecie = ?");
			statement.setInt(1, idEspecie);

			statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Especie buildObject(ResultSet rs) {
		Especie especie = null;

		try {
			int idEspecie = rs.getInt("idEspecie");
			String nomeEspecie = rs.getString("nomeEspecie");

			especie = new Especie(idEspecie, nomeEspecie);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return especie;
	}
}