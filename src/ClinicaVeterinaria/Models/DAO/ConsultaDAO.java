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

public class ConsultaDAO {
	private static ConsultaDAO instance;
    
    private ConsultaDAO()
    {    	
    }
    
    public static ConsultaDAO getInstance(){
    	if (instance == null) {
			instance = new ConsultaDAO();
		}

		return instance;
    }
    
    public int marcarConsulta(Tratamento tratamento, Date dataConsulta, Veterinario veterinario)
    {
    	PreparedStatement statement = null;
		Connection conn = null;
		ResultSet rs = null;
		int idConsulta = -1;
		
		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement(
					"INSERT INTO Consultas(idTratamento, dataConsulta, idVeterinario) VALUES(?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			
			java.sql.Date sqlDataConsulta = new java.sql.Date(dataConsulta.getTime());
			
			statement.setInt(1, tratamento.getIdTratamento());
			statement.setDate(2, sqlDataConsulta);
			statement.setInt(3, veterinario.getIdVeterinario());

			statement.executeUpdate();

			rs = statement.getGeneratedKeys();

			if (rs.next())
				idConsulta = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closePreparedStatement(statement);			
		}
		
		return idConsulta;
    }
    
    public List<Consulta> getAllConsultas(){
    	List<Consulta> result = new ArrayList<>();
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("SELECT * FROM Consultas ORDER BY dataConsulta DESC");
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
    
    public Consulta getConsultaByIdConsulta(int idConsulta){
    	Consulta result = null;
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("SELECT * FROM Consultas WHERE idConsulta = ? ORDER BY idConsulta");
			statement.setInt(1, idConsulta);

			rs = statement.executeQuery();

			if (rs.next())
            	result = buildObject(rs);
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;        
    }
 
    public void updateConsulta(int idConsulta, Date dataConsulta, String historicoConsulta) {
    	Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("UPDATE Consultas SET " 
											+ "historicoConsulta = ?,"
											+ "dataConsulta = ?"
											+ "WHERE idConsulta = ?");

			java.sql.Date sqlDataConsulta = new java.sql.Date(dataConsulta.getTime());
			
			statement.setString(1, historicoConsulta);
			statement.setDate(2, sqlDataConsulta);
			statement.setInt(3, idConsulta);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}     
    }
    
    public void deleteConsulta(int idConsulta){
    	Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("DELETE FROM Consultas WHERE idConsulta = ?");
			statement.setInt(1, idConsulta);

			statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    private Consulta buildObject(ResultSet rs) {
		Consulta consulta = null;
		Tratamento tratamento = null;
		Veterinario veterinario = null;
		
		try {
			int idConsulta = rs.getInt("idConsulta");
			java.sql.Date dataConsulta = new java.sql.Date(rs.getDate("dataConsulta").getTime());
			String historicoConsulta = rs.getString("historicoConsulta");
			int idTratamento = rs.getInt("idTratamento");
			int idVeterinario = rs.getInt("idVeterinario");
			
			tratamento = Controller.getTratamentoByIdTratamento(idTratamento);
			veterinario = Controller.getVeterinarioByIdVeterinario(idVeterinario);
			
			consulta = new Consulta(idConsulta, dataConsulta, historicoConsulta, tratamento, veterinario);
		} catch (SQLException e) { 
			e.printStackTrace();
		}

		return consulta;
	}
    
}