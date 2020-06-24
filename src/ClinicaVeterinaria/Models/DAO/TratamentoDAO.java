package ClinicaVeterinaria.Models.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ClinicaVeterinaria.Controller.Controller;
import ClinicaVeterinaria.Models.Models.Animal;
import ClinicaVeterinaria.Models.Models.Cliente;
import ClinicaVeterinaria.Models.Models.Consulta;
import ClinicaVeterinaria.Models.Models.DB;
import ClinicaVeterinaria.Models.Models.Tratamento;
import ClinicaVeterinaria.Models.Models.Veterinario;

public class TratamentoDAO {
	private static TratamentoDAO instance;

	private TratamentoDAO() {
	}

	public static TratamentoDAO getInstance() {
		if (instance == null) {
			instance = new TratamentoDAO();
		}

		return instance;
	}

	public int addTratamento(Date dataInicial, Date dataFinal, Animal animal) {
		PreparedStatement statement = null;
		Connection conn = null;
		ResultSet rs = null;
		java.sql.Date sqlDataInicial = null;
		java.sql.Date sqlDataFinal = null;

		int idTratamento = -1;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement(
					"INSERT INTO Tratamentos(dataInicial, dataFinal, idAnimal) VALUES(?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			sqlDataInicial = new java.sql.Date(dataInicial.getTime());

			if (dataFinal != null)
				sqlDataFinal = new java.sql.Date(dataFinal.getTime());

			statement.setDate(1, sqlDataInicial);
			statement.setDate(2, sqlDataFinal);
			statement.setInt(3, animal.getIdAnimal());

			statement.executeUpdate();

			rs = statement.getGeneratedKeys();

			if (rs.next())
				idTratamento = rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closePreparedStatement(statement);
		}

		return idTratamento;
	}

	public List<Tratamento> getAllTratamentos() {
		List<Tratamento> result = new ArrayList<>();
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("SELECT * FROM Tratamentos ORDER BY dataInicial DESC");
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

	public Tratamento getTratamentoByIdTratamento(int idTratamento) {
		Tratamento result = null;
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("SELECT * FROM Tratamentos WHERE idTratamento = ? ORDER BY idTratamento");
			statement.setInt(1, idTratamento);

			rs = statement.executeQuery();

			if (rs.next())
				result = buildObject(rs);

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public void updateTratamento(int idTratamento, Date dataInicial, Date dataFinal) {
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement(
					"UPDATE Tratamentos SET " + "dataInicial = ?," + "dataFinal = ?" + "WHERE idTratamento = ?");

			java.sql.Date sqlDataInicial = new java.sql.Date(dataInicial.getTime());
			
			java.sql.Date sqlDataFinal = null;
			if (dataFinal != null)
				sqlDataFinal = new java.sql.Date(dataFinal.getTime());

			statement.setDate(1, sqlDataInicial);
			statement.setDate(2, sqlDataFinal);
			statement.setInt(3, idTratamento);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteTratamento(int idTratamento) {
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("DELETE FROM Tratamentos WHERE idTratamento = ?");
			statement.setInt(1, idTratamento);

			statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Tratamento buildObject(ResultSet rs) {
		Tratamento tratamento = null;
		Animal animal = null;

		try {
			int idTratamento = rs.getInt("idTratamento");
			int idAnimal = rs.getInt("idAnimal");
			java.sql.Date dataInicial = new java.sql.Date(rs.getDate("dataInicial").getTime());
			java.sql.Date dataFinal = null;

			if (rs.getDate("dataFinal") != null)
				dataFinal = new java.sql.Date(rs.getDate("dataFinal").getTime());

			animal = Controller.getAnimalByIdAnimal(idAnimal);

			tratamento = new Tratamento(idTratamento, animal, dataInicial, dataFinal);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tratamento;
	}
}