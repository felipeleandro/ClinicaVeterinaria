package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class VeterinarioDAO extends Observable{
    private static VeterinarioDAO instance;
    private List<Veterinario> veterinarios;
    private int id;
    
    private VeterinarioDAO(){
        Veterinario = new ArrayList();
        id = 0;
    }
    
    public static ClienteDAO getInstance(){
       if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }
    
    public void addVeterinario(String nomVet, String endVet, String telVet){
        Veterinario veterinario = new Veterinario(nomVet, endVet, telVet);
        id++;
        veterinario.add(veterinario);
        setChanged();
        notifyObservers(veterinario);
    }
    
    public List getAllVeterinario(){        
        return veterinarios;
    }
    
    public Veterinario getVeterinarioById(int id){
        for(Veterinario veterinario : veterinarios){
            if(veterinario.getId()==id){
                return veterinario;
            }
        }
        return null;
    }
    
    public void deleteVeterinario(Veterinario veterinario){
        veterinarios.remove(veterinario);
    }
    
}