package ClinicaVeterinaria.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import model.Cliente;
import model.ClienteDAO;
import model.Especie;
import model.Sexo;

public class AnimalDao extends Observable{
	private static AnimalDao instance;
    private List<Animal> animal;
    private int id;
    
    private AnimalDao(){
        animal = new ArrayList();
        id = 0;
    }
	
    public static AnimalDao getInstance(){
        if (instance == null) {
             instance = new AnimalDAO();
         }
         return instance;
     }
    
    public void addAnimal(String nome, int anoNasc, Sexo sexo, Especie especie){
        Animal animal = new Animal(nome, anoNasc, sexo, especie);
        id++;
        animal.add(animal);
        setChanged();
        notifyObservers(animal);
    }
    
    public List getAllAnimais(){        
        return clientes;
    }
    
    public Animal getAnimalById(int id){
        for(Animal animal : animal){
            if(animal.getId()==id){
                return animal;
            }
        }
        return null;
    }
}
