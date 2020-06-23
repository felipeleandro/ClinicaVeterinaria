package ClinicaVeterinaria.Controller;

import java.util.List;
import java.util.Observer;

import ClinicaVeterinaria.Models.Animal;
import ClinicaVeterinaria.Models.Cliente;
import ClinicaVeterinaria.Models.Especie;
import ClinicaVeterinaria.Models.SexoAnimal;
import ClinicaVeterinaria.Models.Veterinario;
import ClinicaVeterinaria.Models.DAO.AnimalDAO;
import ClinicaVeterinaria.Models.DAO.ClienteDAO;
import ClinicaVeterinaria.Models.DAO.VeterinarioDAO;

public class Controller {
	
	/* ANIMAL */

    public static void addAnimal(String nomeAnimal, int idadeAnimal, SexoAnimal sexoAnimal, Especie especie, int idCliente) {
        AnimalDAO.getInstance().addAnimal(nomeAnimal, idadeAnimal, sexoAnimal, especie, idCliente);
    }

    public static List<Animal> getAllAnimais() {
        return AnimalDAO.getInstance().getAllAnimais();
    }

    public static List<Animal> getAnimalByIdCliente(int idCliente) {
        return AnimalDAO.getInstance().getAnimalByIdCliente(idCliente);
    }
    
    public static void updateAnimal(int idAnimal, String nomeAnimal, int idadeAnimal, SexoAnimal sexoAnimal, Especie especie, int idCliente) {
        AnimalDAO.getInstance().updateAnimal(idAnimal, nomeAnimal, idadeAnimal, sexoAnimal, especie, idCliente);
     }
    
    public static void deleteAnimal(int idAnimal) {
        AnimalDAO.getInstance().deleteAnimalByIdAnimal(idAnimal);
    }
    
    /* FIM ANIMAL */
    
    
    
    /* CLIENTE */

    public static void addCliente(String nomCli, String endCli, String telCli, String cepCli, String emailCli) {
        ClienteDAO.getInstance().addCliente(nomCli, endCli, telCli, cepCli, emailCli);
    }
    
    public static List<Cliente> getAllClientes() {
        return ClienteDAO.getInstance().getAllClientes();
    }
    

    public static Cliente getClienteById(int idCliente) {
        return ClienteDAO.getInstance().getClienteByIdCliente(idCliente);
    }
    
    public static List<Cliente> getAllClientesAnimals() {
        return ClienteDAO.getInstance().getAllClientesAndAnimals();
    }
    
   public static void deleteCliente(int idCliente) {
       ClienteDAO.getInstance().deleteClienteByIdCliente(idCliente);
    }
   
   public static void updateCliente(int idCliente, String nomeCliente, String endCliente, String telCliente, String cepCliente, String emailCliente) {
       ClienteDAO.getInstance().updateCliente(idCliente, nomeCliente, endCliente, telCliente, cepCliente, emailCliente);
    }
   
   /* FIM CLIENTE */
   
   
   /* VETERINARIO */
   
   public static void addVeterinario(String nomVet, String endVet, String telVet) {
	   VeterinarioDAO.getInstance().addVeterinario(nomVet, endVet, telVet);
   }

   public static List<Veterinario> getAllVeterinarios() {
       return VeterinarioDAO.getInstance().getAllVeterinarios();
   }

   public static Veterinario getVeterinarioByIdVeterinario(int idVeterinario) {
       return VeterinarioDAO.getInstance().getVeterinarioByIdVeterinario(idVeterinario);
   }
   
   public static Veterinario getVeterinarioByNome(String nomeVeterinario) {
       return VeterinarioDAO.getInstance().getVeterinarioByNome(nomeVeterinario);
   }
   
   public static void updateVeterinario(int idVeterinario, String nomeVeterinario, String enderecoVeterinario, String telefoneVeterinario) {
	   VeterinarioDAO.getInstance().updateVeterinario(idVeterinario, nomeVeterinario, enderecoVeterinario, telefoneVeterinario);
    }
   
   public static void deleteVeterinario(int idVeterinario) {
	   VeterinarioDAO.getInstance().deleteVeterinario(idVeterinario);
    }
   
   /* FIM VETERINARIRO */
}
