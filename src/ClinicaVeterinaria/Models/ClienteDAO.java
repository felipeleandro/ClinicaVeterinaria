package ClinicaVeterinaria.Models;

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

  public void addCliente(String nome, String endereco, String telefone, String cep, String email) {
    Cliente cliente = new Cliente(nome, endereco, telefone, cep, email);
    id++;
    clientes.add(cliente);
    setChanged();
    notifyObservers(cliente);
  }

  // RetrieveAll
  public List<Cliente> getAllClientes() {
    return clientes;
  }

  public Cliente getClienteByNom(String nome) {
    for (Cliente cliente : clientes) {
      if (cliente.getNomCli() == nome) {
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