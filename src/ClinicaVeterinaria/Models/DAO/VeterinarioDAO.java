package ClinicaVeterinaria.Models.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ClinicaVeterinaria.Models.Models.DB;
import ClinicaVeterinaria.Models.Models.Veterinario;

public class VeterinarioDAO {
	private static VeterinarioDAO instance;
    
    private VeterinarioDAO()
    {    	
    }
    
    public static VeterinarioDAO getInstance(){
    	if (instance == null) {
			instance = new VeterinarioDAO();
		}

		return instance;
    }
    
    public int addVeterinario(String nomVet, String endVet, String telVet)
    {
    	PreparedStatement statement = null;
		Connection conn = null;
		ResultSet rs = null;
		int idVeterinario = -1;
		
		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement(
					"INSERT INTO Veterinarios(nomeVeterinario, enderecoVeterinario, telefoneVeterinario) VALUES(?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, nomVet);
			statement.setString(2, endVet);
			statement.setString(3, telVet);			

			statement.executeUpdate();

			rs = statement.getGeneratedKeys();

			if (rs.next())
				idVeterinario = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closePreparedStatement(statement);			
		}
		
		return idVeterinario;
    }
    
    public List<Veterinario> getAllVeterinarios(){
    	List<Veterinario> result = new ArrayList<>();
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("SELECT * FROM Veterinarios ORDER BY idVeterinario");
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
    
    public Veterinario getVeterinarioByIdVeterinario(int idVeterinario){
    	Veterinario result = null;
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("SELECT * FROM Veterinarios WHERE idVeterinario = ? ORDER BY idVeterinario");
			statement.setInt(1, idVeterinario);

			rs = statement.executeQuery();

			if (rs.next())
            	result = buildObject(rs);
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;        
    }

    public Veterinario getVeterinarioByNome(String nomeVeterinario) {
    	Veterinario result = null;
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("SELECT * FROM Veterinarios WHERE nomeVeterinario = ? ORDER BY idVeterinario");
			statement.setString(1, nomeVeterinario);

			rs = statement.executeQuery();
			
			if (rs.next())
            	result = buildObject(rs);

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;        
    }
 
    public void updateVeterinario(int idVeterinario, String nomeVeterinario, String enderecoVeterinario, String telefoneVeterinario) {
    	Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("UPDATE Veterinarios SET " 
											+ "nomeVeterinario = ?," 
											+ "enderecoVeterinario = ?,"
											+ "telefoneVeterinario = ?"											
											+ "WHERE idVeterinario = ?");

			statement.setString(1, nomeVeterinario);
			statement.setString(2, enderecoVeterinario);
			statement.setString(3, telefoneVeterinario);
			statement.setInt(4, idVeterinario);			

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}     
    }
    
    public void deleteVeterinario(int idVeterinario){
    	Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = DB.getConnection();
			statement = conn.prepareStatement("DELETE FROM Veterinarios WHERE idVeterinario = ?");
			statement.setInt(1, idVeterinario);

			statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    private Veterinario buildObject(ResultSet rs) {
		Veterinario veterinario = null;
		
		try {
			int idVeterinario = rs.getInt("idVeterinario");
			String nomeVeterinario = rs.getString("nomeVeterinario");
			String enderecoVeterinario = rs.getString("enderecoVeterinario");
			String telefoneVeterinario = rs.getString("telefoneVeterinario");
			
			veterinario = new Veterinario(idVeterinario, nomeVeterinario, enderecoVeterinario, telefoneVeterinario);
		} catch (SQLException e) { 
			e.printStackTrace();
		}

		return veterinario;
	}
    
}