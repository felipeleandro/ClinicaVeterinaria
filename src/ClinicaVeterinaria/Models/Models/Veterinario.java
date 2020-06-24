package ClinicaVeterinaria.Models.Models;

import java.util.ArrayList;

public class Veterinario {
    private int idVeterinario;
    private String nomVet;
    private String endVet;
    private String telVet;
    private ArrayList<Consulta> listaConsultas;    
    
    public Veterinario(int idVeterinario, String nomVet, String endVet, String telVet) {
    	this.idVeterinario = idVeterinario;
        this.nomVet = nomVet;
        this.endVet = endVet;
        this.telVet = telVet;
        listaConsultas = new ArrayList<>();
    }

    public Veterinario(String nomVet, String endVet, String telVet) {
        this.nomVet = nomVet;
        this.endVet = endVet;
        this.telVet = telVet;
        listaConsultas = new ArrayList<>();
    }
    
    public Veterinario() {
        listaConsultas = new ArrayList<>();
    }

    public int getIdVeterinario() {
		return idVeterinario;
	}

	public void setIdVeterinario(int idVeterinario) {
		this.idVeterinario = idVeterinario;
	}

	public String getNomVet() {
        return nomVet;
    }

    public void setNomVet(String nomVet) {
        this.nomVet = nomVet;
    }

    public String getEndVet() {
        return endVet;
    }

    public void setEndVet(String endVet) {
        this.endVet = endVet;
    }

    public String getTelVet() {
        return telVet;
    }

    public void setTelVet(String telVet) {
        this.telVet = telVet;
    }


    public ArrayList<Consulta> getListaConsultas() {
        return listaConsultas;
    }

    public void addListaConsultas(Consulta consulta) {
        this.listaConsultas.add(consulta);
    }
}