package ClinicaVeterinaria.Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class AnimalDAO extends Observable {
    private static AnimalDAO instance;
    private List<Animal> animais;
    private int id;

    private AnimalDAO() {
        animais = new ArrayList();
        id = 0;
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

    public List<Animal> retrieveByIdCliente(int idCliente) {
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

    public List getAllAnimais() {
        return animais;
    }

    public Animal getAnimalById(int id) {
        for (Animal animal : animais) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return null;
    }

    public Animal getAnimalByNome(String nomeAnimal) {
        for (Animal animal : animais) {
            if (animal.getNomeAnimal() == nomeAnimal) {
                return animal;
            }
        }
        return null;
    }

    // Updade
    public void updateAnimal(Animal animal, String nomeAnimal, int idadeAnimal, int sexoAnimal, Especie especie, int id) {
        int pos = animais.indexOf(animal);

        if (pos > 0) {
            animal.setNomeAnimal(nomeAnimal);
            animal.setIdadeAnimal(idadeAnimal);
            animal.setSexoAnimal(sexoAnimal);
            animal.setEspecie(especie);

            animais.set(pos, animal);
        }
    }

    // Delete
    public void deleteAnimal(Animal animal) {
        animais.remove(animal);
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
