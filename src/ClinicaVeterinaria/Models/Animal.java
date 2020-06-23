package ClinicaVeterinaria.Models;

import java.util.ArrayList;

public class Animal {
	private int idAnimal; 
    private String nomeAnimal;
    private int idadeAnimal;
    private SexoAnimal sexoAnimal;
    private Especie especie;
    private int idCliente;
    private ArrayList<Tratamento> listaTratamentos;    

	public Animal() {
        listaTratamentos = new ArrayList<>();
    }

    public Animal(int idAnimal, String nomeAnimal, int idadeAnimal, SexoAnimal sexoAnimal, Especie especie, int idCliente) {
        this.idAnimal = idAnimal;
    	this.nomeAnimal = nomeAnimal;
        this.idadeAnimal = idadeAnimal;
        this.sexoAnimal = sexoAnimal;
        this.especie = especie;
        this.idCliente = idCliente;
        listaTratamentos = new ArrayList<>();
    }

    public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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

    public SexoAnimal getSexoAnimal() {
        return sexoAnimal;
    }

    public void setSexoAnimal(SexoAnimal sexoAnimal) {
        this.sexoAnimal = sexoAnimal;
    }

    public int getIdAnimal() {
    	return idAnimal;
    }
    
    public void setIdAnimal(int idAnimal) {
    	this.idAnimal = idAnimal;
    }

    @Override
    public String toString() {
        return "Nome: " + nomeAnimal + " "  +
               "Idade: " + idadeAnimal + " " +
               "Espécie: " + especie;
    }
}
