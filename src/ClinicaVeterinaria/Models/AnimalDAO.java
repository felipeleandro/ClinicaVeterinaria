package ClinicaVeterinaria.Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class AnimalDAO extends Observable {
    private static AnimalDAO instance;

    private AnimalDAO() {
    }

    public static AnimalDAO getInstance() {
        if (instance == null) {
            instance = new AnimalDAO();
        }

        return instance;
    }

    public void addAnimal(String nomeAnimal, int idadeAnimal, int sexoAnimal, Especie especie, int idCliente) {
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = DB.getConnection();
            statement = conn.prepareStatement(
                    "INSERT INTO Animais(nomeAnimal, idadeAnimal, sexoAnimal, idEspecie, idCliente) VALUES(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, nomeAnimal);
            statement.setInt(2, idadeAnimal);
            statement.setInt(3, sexoAnimal);
            statement.setInt(4, 1);
            statement.setInt(5, idCliente);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closePreparedStatement(statement);
            DB.closeConnection();
        }
    }

    public List<Animal> getAnimalByIdCliente(int idCliente) {
        List<Animal> result = null;
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = DB.getConnection();
            statement = conn.prepareStatement("SELECT * FROM Animais WHERE idCliente = ?");
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
            statement = conn.prepareStatement("SELECT * FROM Animais");
            rs = statement.executeQuery();
            
            while (rs.next())
            {
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
            statement = conn.prepareStatement("SELECT * FROM Animais WHERE idAnimal = ?");
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
            statement = conn.prepareStatement("SELECT * FROM Animais WHERE nomeAnimal = ?");
            statement.setString(1, nomeAnimal);

            rs = statement.executeQuery();
            
            result = buildObject(rs);
            
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    // Update
    public void updateAnimal(int idAnimal, String nomeAnimal, int idadeAnimal, int sexoAnimal) {
    	Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = DB.getConnection();
            statement = conn.prepareStatement("UPDATE Animais SET "
            								+ "nomeAnimal = ?,"
            								+ "idadeAnimal = ?,"
            								+ "sexoAnimal = ?,"
            								+ "WHERE idAnimal = ?");
            
            statement.setString(1, nomeAnimal);
            statement.setInt(1, idadeAnimal);
            statement.setInt(1, sexoAnimal);
            statement.setInt(1, idAnimal);

            statement.executeUpdate();   
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
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
            Especie especie = new Especie();
            especie.setNomEsp("gato");
            
            animal = new Animal(rs.getString("nomeAnimal"),
                    rs.getInt("idadeAnimal"),
                    rs.getInt("sexoAnimal"),
                    especie,
                    rs.getInt("idCliente"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animal;
    }
}
