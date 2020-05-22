package ClinicaVeterinaria.Models;

import java.util.ArrayList;

public class Animal {
	private int id; 
    private String nomeAnimal;
    private int idadeAnimal;
    private int sexoAnimal;
    private Especie especie;
    private ArrayList<Tratamento> listaTratamentos;

    public Animal() {
        listaTratamentos = new ArrayList<>();
    }

    public Animal(String nomeAnimal, int idadeAnimal, int sexoAnimal, Especie especie, int id) {
        this.id=id;
    	this.nomeAnimal = nomeAnimal;
        this.idadeAnimal = idadeAnimal;
        this.sexoAnimal = sexoAnimal;
        this.especie = especie;
        listaTratamentos = new ArrayList<>();
    }

    public ArrayList<Tratamento> getListaTratamentos() {
        return listaTratamentos;
    }

    public void setListaTratamentos(ArrayList<Tratamento> listaTratamentos) {
        this.listaTratamentos = listaTratamentos;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public int getIdadeAnimal() {
        return idadeAnimal;
    }

    public void setIdadeAnimal(int idadeAnimal) {
        this.idadeAnimal = idadeAnimal;
    }

    public int getSexoAnimal() {
        return sexoAnimal;
    }

    public void setSexoAnimal(int sexoAnimal) {
        this.sexoAnimal = sexoAnimal;
    }

    public int getId() {
    	return id;
    }
    
    public void setId(int id) {
    	this.id=id;
    }
    
    private String ViaAnimal()
    {
        return null;
    }

    private String ConAnimal()
    {
        return null;
    }

    @Override
    public String toString() {
        return "Nome: " + nomeAnimal + " "  +
               "Idade: " + idadeAnimal + " " +
               "Espécie: " + especie;
    }
}
