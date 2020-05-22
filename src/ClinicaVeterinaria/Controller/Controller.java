package Controller;

import java.util.Observer;
//import java.util.List;
import java.util.Map;
import model.AnimalDao;
import model.ClienteDAO;

public class Controller {
	 public static void setObserver(Observer observer){
	        AnimalDao.getInstance().addObserver(observer);
	    }
	    
	    public static void addAnimal(int idAnimal, String nomeAnimal, String idadeAnimal, int sexoAnimal, String especie){
	        AnimalDao.getInstance().addAnimal(nomeAnimal, idadeAnimal, sexoAnimal, especie);
	    }
	    
	    public static Map getAllAnimais(){
	        return AnimalDao.getInstance().getAllAnimais();
	    }
	    
	 public static void setObserver(Observer observer){
	        ClienteDao.getInstance().addObserver(observer);
	    }
	    
	    public static void addCliente(String nomCli, String endCli, String telCli, String cepCli, String emailCli){
	        ClienteDAO.getInstance().addCliente(nomCli, endCli, telCli, cepCli, emailCli);
	    }
	    
	    public static Map getAllClientes(){
	        return ClienteDAO.getInstance().getAllClientes();
	    }
	 
}
