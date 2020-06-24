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
import ClinicaVeterinaria.Models.Models.Exame;
import ClinicaVeterinaria.Models.Models.Tratamento;
import ClinicaVeterinaria.Models.Models.Veterinario;

public class ExameDAO {
	private static ExameDAO instance;
    
    private ExameDAO()
    {    	
    }
    
    public static ExameDAO getInstance(){
    	if (instance == null) {
			instance = new ExameDAO();
		}

		return instance;
    }
    
    public int marcarExame(Consulta consulta, String descricaoExame)
    {
    	PreparedStatement statement = null;
		Connection conn = null;
		ResultSet rs = null;
		int idExame = -1;
		
		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement(
					"INSERT INTO Exames(idConsulta, descricaoExame) VALUES(?,?)",
					Statement.RETURN_GENERATED_KEYS);
			
			statement.setInt(1, consulta.getIdConsulta());
			statement.setString(2, descricaoExame);

			statement.executeUpdate();

			rs = statement.getGeneratedKeys();

			if (rs.next())
				idExame = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closePreparedStatement(statement);			
		}
		
		return idExame;
    }
    
    public List<Exame> getAllExames(){
    	List<Exame> result = new ArrayList<>();
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("SELECT * FROM Exames ORDER BY idConsulta");
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
    
    public Exame getExmeByIdExame(int idExame){
    	Exame result = null;
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("SELECT * FROM Exames WHERE idExame = ? ORDER BY idExame");
			statement.setInt(1, idExame);

			rs = statement.executeQuery();

			if (rs.next())
            	result = buildObject(rs);
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;        
    }
 
    public void updateExame(int idExame, String descricaoExame) {
    	Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("UPDATE Exames SET " 
											+ "descricaoExame = ?"
											+ "WHERE idExame = ?");

			statement.setString(1, descricaoExame);
			statement.setInt(2, idExame);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}     
    }
    
    public void deleteExame(int idExame){
    	Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("DELETE FROM Exames WHERE idExame = ?");
			statement.setInt(1, idExame);

			statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    private Exame buildObject(ResultSet rs) {
    	Exame exame = null;
		Consulta consulta = null;
		
		try {
			int idExame = rs.getInt("idExame");
			String descricaoExame = rs.getString("descricaoExame");
			int idConsulta = rs.getInt("idConsulta");
			
			consulta = Controller.getConsultaByIdConsulta(idConsulta);
			
			exame = new Exame(idExame, descricaoExame, consulta);
		} catch (SQLException e) { 
			e.printStackTrace();
		}

		return exame;
	}
    
}