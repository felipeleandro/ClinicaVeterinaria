package ClinicaVeterinaria.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class VeterinarioDAO extends Observable{
    private static VeterinarioDAO instance;
    private List<Veterinario> veterinarios;
    private int id;
    
    private VeterinarioDAO(){
        veterinarios = new ArrayList();
        id = 0;
    }
    
    public void addVeterinario(String nomVet, String endVet, String telVet){
        Veterinario veterinario = new Veterinario(nomVet, endVet, telVet);
        id++;
        veterinarios.add(veterinario);
        setChanged();
        notifyObservers(veterinario);
    }
    
    public List getAllVeterinario(){        
        return veterinarios;
    }
    
    public Veterinario getVeterinarioById(int id){
        for(Veterinario veterinario : veterinarios){
            if(veterinario.getId() == id){
                return veterinario;
            }
        }
        return null;
    }

    public Veterinario getVeterinarioByNome(String nome) {
        for (Veterinario veterinario : veterinarios) {
            if (veterinario.getNomVet() == nome) {
                return veterinario;
            }
        }
        return null;
    }

    // Updade
    public void updateVeterinario(Veterinario veterinario, String nome, String endereco, String telefone) {
        int pos = veterinarios.indexOf(veterinario);

        if (pos > 0) {
            veterinario.setNomVet(nome);
            veterinario.setEndVet(endereco);
            veterinario.setTelVet(telefone);

            veterinarios.set(pos, veterinario);
        }
    }
    
    public void deleteVeterinario(Veterinario veterinario){
        veterinarios.remove(veterinario);
    }
    
}