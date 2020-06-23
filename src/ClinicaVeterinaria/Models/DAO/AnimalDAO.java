package ClinicaVeterinaria.Models.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import ClinicaVeterinaria.Models.Animal;
import ClinicaVeterinaria.Models.DB;
import ClinicaVeterinaria.Models.Especie;
import ClinicaVeterinaria.Models.SexoAnimal;

public class AnimalDAO {
	private static AnimalDAO instance;

	private AnimalDAO() {
	}

	public static AnimalDAO getInstance() {
		if (instance == null) {
			instance = new AnimalDAO();
		}

		return instance;
	}

	public int addAnimal(String nomeAnimal, int idadeAnimal, SexoAnimal sexoAnimal, Especie especie, int idCliente) {
		PreparedStatement statement = null;
		Connection conn = null;
		ResultSet rs = null;
		int idAnimal = -1;
		
		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement(
					"INSERT INTO Animais(nomeAnimal, idadeAnimal, sexoAnimal, idEspecie, nomeEspecie, idCliente) VALUES(?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, nomeAnimal);
			statement.setInt(2, idadeAnimal);
			statement.setString(3, sexoAnimal.getSexo());
			statement.setInt(4, especie.getIdEspecie());
			statement.setString(5, especie.getNomEsp());
			statement.setInt(6, idCliente);

			statement.executeUpdate();

			rs = statement.getGeneratedKeys();

			if (rs.next())
				idAnimal = rs.getInt(1);
			return idAnimal;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closePreparedStatement(statement);			
		}
		
		return idAnimal;
	}

	public List<Animal> getAnimalByIdCliente(int idCliente) {
		List<Animal> result = null;
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("SELECT * FROM Animais WHERE idCliente = ? ORDER BY idAnimal");
			statement.setInt(1, idCliente);

			rs = statement.executeQuery();

			result = new ArrayList<>();

			while (rs.next()) {
				result.add(buildObject(rs));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public List<Animal> getAllAnimais() {
		List<Animal> result = new ArrayList<>();
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("SELECT * FROM Animais ORDER BY idAnimal");
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

	public Animal getAnimalByIdAnimal(int idAnimal) {
		Animal result = null;
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("SELECT * FROM Animais WHERE idAnimal = ? ORDER BY idAnimal");
			statement.setInt(1, idAnimal);

			rs = statement.executeQuery();

			result = buildObject(rs);

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public Animal getAnimalByNome(String nomeAnimal) {
		Animal result = null;
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("SELECT * FROM Animais WHERE nomeAnimal = ? ORDER BY idAnimal");
			statement.setString(1, nomeAnimal);

			rs = statement.executeQuery();

			result = buildObject(rs);

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public void updateAnimal(int idAnimal, String nomeAnimal, int idadeAnimal, SexoAnimal sexoAnimal, Especie especieAnimal, int idCliente) {
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("UPDATE Animais SET " 
											+ "nomeAnimal = ?," 
											+ "idadeAnimal = ?,"
											+ "sexoAnimal = ?," 
											+ "idEspecie = ?,"
											+ "nomeEspecie = ?,"
											+ "idCliente = ?"
											+ "WHERE idAnimal = ?");

			statement.setString(1, nomeAnimal);
			statement.setInt(2, idadeAnimal);
			statement.setString(3, sexoAnimal.getSexo());
			statement.setInt(4, especieAnimal.getIdEspecie());
			statement.setString(5, especieAnimal.getNomEsp());
			statement.setInt(6, idCliente);
			statement.setInt(7, idAnimal);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAnimalByIdAnimal(int idAnimal) {
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("DELETE FROM Animais WHERE idAnimal = ?");
			statement.setInt(1, idAnimal);

			statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Animal buildObject(ResultSet rs) {
		Animal animal = null;
		
		try {
			int idEspecie = rs.getInt("idEspecie");
			String nomeEspecie = rs.getString("nomeEspecie");
			SexoAnimal sexoAnimal = SexoAnimal.fromSexo(rs.getString("sexoAnimal"));
			Especie especie = new Especie(idEspecie, nomeEspecie);
			
			animal = new Animal(rs.getInt("idAnimal"), rs.getString("nomeAnimal"), rs.getInt("idadeAnimal"), sexoAnimal, especie, rs.getInt("idCliente"));
		} catch (SQLException e) { 
			e.printStackTrace();
		}

		return animal;
	}
}
