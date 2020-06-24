package ClinicaVeterinaria.Controller;

import java.util.Date;
import java.util.List;
import java.util.Observer;

import ClinicaVeterinaria.Models.DAO.AnimalDAO;
import ClinicaVeterinaria.Models.DAO.ClienteDAO;
import ClinicaVeterinaria.Models.DAO.ConsultaDAO;
import ClinicaVeterinaria.Models.DAO.EspecieDAO;
import ClinicaVeterinaria.Models.DAO.ExameDAO;
import ClinicaVeterinaria.Models.DAO.TratamentoDAO;
import ClinicaVeterinaria.Models.DAO.VeterinarioDAO;
import ClinicaVeterinaria.Models.Models.Animal;
import ClinicaVeterinaria.Models.Models.Cliente;
import ClinicaVeterinaria.Models.Models.Consulta;
import ClinicaVeterinaria.Models.Models.Especie;
import ClinicaVeterinaria.Models.Models.Exame;
import ClinicaVeterinaria.Models.Models.SexoAnimal;
import ClinicaVeterinaria.Models.Models.Tratamento;
import ClinicaVeterinaria.Models.Models.Veterinario;

public class Controller {
	
	/* ANIMAL */

    public static int addAnimal(String nomeAnimal, int idadeAnimal, SexoAnimal sexoAnimal, Especie especie, int idCliente) {
        return AnimalDAO.getInstance().addAnimal(nomeAnimal, idadeAnimal, sexoAnimal, especie, idCliente);
    }

    public static List<Animal> getAllAnimais() {
        return AnimalDAO.getInstance().getAllAnimais();
    }

    public static List<Animal> getAnimalByIdCliente(int idCliente) {
        return AnimalDAO.getInstance().getAnimalByIdCliente(idCliente);
    }
    
    public static Animal getAnimalByIdAnimal(int idAnimal) {
        return AnimalDAO.getInstance().getAnimalByIdAnimal(idAnimal);
    }
    
    public static Animal getAnimalByNomeAnimal(String nomeAnimal) {
        return AnimalDAO.getInstance().getAnimalByNome(nomeAnimal);
    }
    
    public static void updateAnimal(int idAnimal, String nomeAnimal, int idadeAnimal, SexoAnimal sexoAnimal, Especie especie, int idCliente) {
        AnimalDAO.getInstance().updateAnimal(idAnimal, nomeAnimal, idadeAnimal, sexoAnimal, especie, idCliente);
     }
    
    public static void deleteAnimal(int idAnimal) {
        AnimalDAO.getInstance().deleteAnimalByIdAnimal(idAnimal);
    }
    
    /* FIM ANIMAL */
    
    
    /* CLIENTE */

    public static int addCliente(String nomCli, String endCli, String telCli, String cepCli, String emailCli) {
        return ClienteDAO.getInstance().addCliente(nomCli, endCli, telCli, cepCli, emailCli);
    }
    
    public static List<Cliente> getAllClientes() {
        return ClienteDAO.getInstance().getAllClientes();
    }
    
    public static Cliente getClienteById(int idCliente) {
        return ClienteDAO.getInstance().getClienteByIdCliente(idCliente);
    }
    
    public static Cliente getClienteByNome(String nomeCliente) {
        return ClienteDAO.getInstance().getClienteByNome(nomeCliente);
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
   
   public static int addVeterinario(String nomVet, String endVet, String telVet) {
	   return VeterinarioDAO.getInstance().addVeterinario(nomVet, endVet, telVet);
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
   
   
   /* ESPECIE */
   
   public static int addEspecie(String nomeEspecie) {
	   return EspecieDAO.getInstance().addEspecie(nomeEspecie);
   }

   public static List<Especie> getAllEspecies() {
       return EspecieDAO.getInstance().getAllEspecies();
   }

   public static Especie getEspecieByIdEspecie(int idEspecie) {
       return EspecieDAO.getInstance().getEspecieByIdEspecie(idEspecie);
   }
   
   public static Especie getEspecieByNome(String nomeEspecie) {
       return EspecieDAO.getInstance().getEspecieByNome(nomeEspecie);
   }
   
   public static void updateEspecie(int idEspecie, String nomeEspecie) {
	   EspecieDAO.getInstance().updateEspecie(idEspecie, nomeEspecie);
    }
   
   public static void deleteEspecie(int idEspecie) {
	   EspecieDAO.getInstance().deleteEspecie(idEspecie);
    }
   
   /* FIM ESPECIE */
   
   /* CONSULTA */
   
   public static int marcarConsulta(Tratamento tratamento, Date dataConsulta, Veterinario veterinario) {
	   return ConsultaDAO.getInstance().marcarConsulta(tratamento, dataConsulta, veterinario);
   }

   public static List<Consulta> getAllConsultas() {
       return ConsultaDAO.getInstance().getAllConsultas();
   }

   public static Consulta getConsultaByIdConsulta(int idConsulta) {
       return ConsultaDAO.getInstance().getConsultaByIdConsulta(idConsulta);
   }
   
   public static void updateConsulta(int idConsulta, Date dataConsulta, String historicoConsulta) {
	   ConsultaDAO.getInstance().updateConsulta(idConsulta, dataConsulta, historicoConsulta);
    }
   
   public static void deleteConsulta(int idConsulta) {
	   ConsultaDAO.getInstance().deleteConsulta(idConsulta);
    }
   
   /* FIM CONSULTA */
   
   
   /* TRATAMENTO */
   
   public static int addTratamento(Date dataInicial, Date dataFinal, Animal animal){
	   return TratamentoDAO.getInstance().addTratamento(dataInicial, dataFinal, animal);
   }

   public static List<Tratamento> getAllTratamentos() {
       return TratamentoDAO.getInstance().getAllTratamentos();
   }

   public static Tratamento getTratamentoByIdTratamento(int idTratamento) {
       return TratamentoDAO.getInstance().getTratamentoByIdTratamento(idTratamento);
   }
   
   public static void updateTratamento(int idTratamento, Date dataInicial, Date dataFinal) {
	   TratamentoDAO.getInstance().updateTratamento(idTratamento, dataInicial, dataFinal);
    }
   
   public static void deleteTratamento(int idTratamento) {
	   TratamentoDAO.getInstance().deleteTratamento(idTratamento);
    }
   
    /* FIM TRATAMENTO */
   
    /* EXAME */
   
   public static int marcarExame(Consulta consulta, String descricaoExame){
	   return ExameDAO.getInstance().marcarExame(consulta, descricaoExame);
   }

   public static List<Exame> getAllExames() {
       return ExameDAO.getInstance().getAllExames();
   }

   public static Exame getExameByIdExame(int idExame) {
       return ExameDAO.getInstance().getExmeByIdExame(idExame);
   }
   
   public static void updateExame(int idExame, String descricaoExame) {
	   ExameDAO.getInstance().updateExame(idExame, descricaoExame);
    }
   
   public static void deleteExame(int idExame) {
	   ExameDAO.getInstance().deleteExame(idExame);
    }
   
    /* FIM EXAME */
}
