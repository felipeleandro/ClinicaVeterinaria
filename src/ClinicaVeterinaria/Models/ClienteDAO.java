package ClinicaVeterinaria.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class ClienteDAO extends Observable {
    private static ClienteDAO instance;
    private List<Cliente> clientes;
    private int id;

    private ClienteDAO() {
        clientes = new ArrayList<Cliente>();
        id = 0;
    }

    public static ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }

    public void addCliente(String nomCli, String endCli, String telCli, String cepCli, String emailCli) {
        PreparedStatement statement = null;
        Connection conn = null;
        try {
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

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closePreparedStatement(statement);
            DB.closeConnection();
        }
    }

    // RetrieveAll
    public List<Cliente> getAllClientes() {
        return clientes;
    }

    public Cliente getClienteByNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNomCli() == nome) {
                return cliente;
            }
        }
        return null;
    }
    public Cliente getClienteById(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getidCli() == id) {
                return cliente;
            }
        }
        return null;
    }

    // Updade
    public void updateCliente(Cliente cliente, String endereco, String telefone, String cep, String email) {
        int pos = clientes.indexOf(cliente);

        if (pos > 0) {
            cliente.setTelCli(telefone);
            cliente.setEmailCli(email);
            cliente.setEndCli(endereco);
            cliente.setCepCli(cep);

            clientes.set(pos, cliente);
        }
    }

    // Delete
    public void deleteCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

}