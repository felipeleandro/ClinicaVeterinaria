package ClinicaVeterinaria.Models.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import ClinicaVeterinaria.Controller.Controller;
import ClinicaVeterinaria.Models.Animal;
import ClinicaVeterinaria.Models.Cliente;
import ClinicaVeterinaria.Models.DB;

public class ClienteDAO {
    private static ClienteDAO instance;

    private ClienteDAO() 
    {
    }

    public static ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }

    public int addCliente(String nomCli, String endCli, String telCli, String cepCli, String emailCli) {
        PreparedStatement statement = null;
        Connection conn = null;
        ResultSet rs = null;
        int idCliente = -1;
        
        try 
        {
            conn = DB.getConnection();
            statement = conn.prepareStatement(
                    "INSERT INTO Clientes(nomCli, endCli, telCli, cepCli, emailCli) VALUES(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, nomCli);
            statement.setString(2, endCli);
            statement.setString(3, telCli);
            statement.setString(4, cepCli);
            statement.setString(5, emailCli);

            statement.executeUpdate();
            
            rs = statement.getGeneratedKeys();
            
            if (rs.next())
            	idCliente = rs.getInt(1);
            
            return idCliente;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closePreparedStatement(statement);            
        }
        
        return idCliente;
    }
    
    public List<Cliente> getAllClientes() {
    	List<Cliente> result = new ArrayList<>();
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = DB.getConnection();
            statement = conn.prepareStatement("SELECT * FROM Clientes ORDER BY idCliente");

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
    
    public List<Cliente> getAllClientesAndAnimals() {
    	List<Cliente> result = new ArrayList<>();
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = DB.getConnection();
            statement = conn.prepareStatement("SELECT C.idCliente, C.nomCli, C.endCli, C.telCli, C.cepCli, C.emailCli "            								
            								+ "FROM Clientes C "
            								+ "INNER JOIN Animais A ON C.idCliente = A.idCliente"
            								+ "ORDER BY idCliente, idAnimal");

            rs = statement.executeQuery();

            while (rs.next()) {
                result.add(buildObjectWithAnimal(rs));
            }
            
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }    

	public Cliente getClienteByNome(String nomeCliente) {
    	Cliente result = null;
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = DB.getConnection();
            statement = conn.prepareStatement("SELECT * FROM Clientes WHERE nomCli = ? ORDER BY idCliente");
            statement.setString(1, nomeCliente);

            rs = statement.executeQuery();
            
            result = buildObject(rs);
            
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    
    public Cliente getClienteByIdCliente(int idCliente) {
    	Cliente result = null;
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = DB.getConnection();
            statement = conn.prepareStatement("SELECT * FROM Clientes WHERE idCliente = ? ORDER BY idCliente");
            statement.setInt(1, idCliente);

            rs = statement.executeQuery();
            
            if (rs.next())
            	result = buildObject(rs);
            
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    // Update
    public void updateCliente(int idCliente, String nomCli, String endCli, String telCli, String cepCli, String emailCli) {
    	Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = DB.getConnection();
            statement = conn.prepareStatement("UPDATE Clientes SET "
            								+ "nomCli = ?,"
            								+ "endCli = ?,"
            								+ "telCli = ?,"
            								+ "cepCli = ?,"
            								+ "emailCli = ? "
            								+ "WHERE idCliente = ?");
            
            statement.setString(1, nomCli);
            statement.setString(2, endCli);
            statement.setString(3, telCli);
            statement.setString(4, cepCli);
            statement.setString(5, emailCli);
            statement.setInt(6, idCliente);

            statement.executeUpdate();   
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteClienteByIdCliente(int idCliente) {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = DB.getConnection();
            statement = conn.prepareStatement("DELETE FROM Clientes WHERE idCliente = ?");
            statement.setInt(1, idCliente);

            statement.executeUpdate();   
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private Cliente buildObject(ResultSet rs) {
        Cliente cliente = null;
        try 
        {
            cliente = 
            		new Cliente
            		(rs.getInt("idCliente"),
            		rs.getString("nomCli"),
            		rs.getString("endCli"),
            		rs.getString("telCli"),
            		rs.getString("cepCli"),
            		rs.getString("emailCli"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }
    
    private Cliente buildObjectWithAnimal(ResultSet rs) {
    	Cliente cliente = null;
        try 
        {
            cliente = 
            		new Cliente
            		(rs.getInt("idCliente"),
            		rs.getString("nomCli"),
            		rs.getString("endCli"),
            		rs.getString("telCli"),
            		rs.getString("cepCli"),
            		rs.getString("emailCli"));
            
            List<Animal> listaAnimais = Controller.getAnimalByIdCliente(rs.getInt("idCliente"));
            
            for (Animal animal : listaAnimais) {
    			cliente.addListaAnimais(animal);
    		}            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
	}

}