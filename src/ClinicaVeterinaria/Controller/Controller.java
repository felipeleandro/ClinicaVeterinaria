package ClinicaVeterinaria.Controller;

import java.util.List;
import java.util.Observer;
import java.util.Map;

import ClinicaVeterinaria.Models.Animal;
import ClinicaVeterinaria.Models.AnimalDAO;
import ClinicaVeterinaria.Models.ClienteDAO;
import ClinicaVeterinaria.Models.Especie;

public class Controller {

    public static void setObserverCliente(Observer observer) {
        ClienteDAO.getInstance().addObserver(observer);
    }

    public static void setObserverAnimal(Observer observer) {
        AnimalDAO.getInstance().addObserver(observer);
    }

    public static void addAnimal(int idAnimal, String nomeAnimal, int idadeAnimal, int sexoAnimal, Especie especie) {
        AnimalDAO.getInstance().addAnimal(nomeAnimal, idadeAnimal, sexoAnimal, especie, idAnimal);
    }

    public static List getAllAnimais() {
        return AnimalDAO.getInstance().getAllAnimais();
    }

    public static List getAnimalByIdCliente(int idCliente) {
        return AnimalDAO.getInstance().retrieveById(idCliente);
    }

    public static void addCliente(String nomCli, String endCli, String telCli, String cepCli, String emailCli) {
        ClienteDAO.getInstance().addCliente(nomCli, endCli, telCli, cepCli, emailCli);
    }

    public static List getAllClientes() {
        return ClienteDAO.getInstance().getAllClientes();
    }

}
