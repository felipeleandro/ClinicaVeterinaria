package ClinicaVeterinaria.Controller;

import java.util.List;
import java.util.Observer;
import java.util.Map;

import ClinicaVeterinaria.Models.Animal;
import ClinicaVeterinaria.Models.AnimalDAO;
import ClinicaVeterinaria.Models.Cliente;
import ClinicaVeterinaria.Models.ClienteDAO;
import ClinicaVeterinaria.Models.Especie;

public class Controller {

    public static void setObserverCliente(Observer observer) {
        ClienteDAO.getInstance().addObserver(observer);
    }

    public static void setObserverAnimal(Observer observer) {
        AnimalDAO.getInstance().addObserver(observer);
    }

    public static void addAnimal(String nomeAnimal, int idadeAnimal, int sexoAnimal, Especie especie, int idCliente) {
        AnimalDAO.getInstance().addAnimal(nomeAnimal, idadeAnimal, sexoAnimal, especie, idCliente);
    }

    public static List<Animal> getAllAnimais() {
        return AnimalDAO.getInstance().getAllAnimais();
    }

    public static List getAnimalByIdCliente(int idCliente) {
        return AnimalDAO.getInstance().getAnimalByIdCliente(idCliente);
    }

    public static void addCliente(String nomCli, String endCli, String telCli, String cepCli, String emailCli) {
        ClienteDAO.getInstance().addCliente(nomCli, endCli, telCli, cepCli, emailCli);
    }

    public static Cliente getClienteById(int idCliente) {
        return ClienteDAO.getInstance().getClienteByIdCliente(idCliente);
    }
    
    public static List<Cliente> getAllClientes() {
        return ClienteDAO.getInstance().getAllClientes();
    }
    
   public static void deleteCliente(Cliente cliente) {
       return;
    }

}
