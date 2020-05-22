package ClinicaVeterinaria.Models;

import java.util.ArrayList;

public class Veterinario {
    private int id;
    private String nomVet;
    private String endVet;
    private String telVet;
    private ArrayList<Consulta> listaConsultas;

    public Veterinario() {
        listaConsultas = new ArrayList<>();
    }

    public Veterinario(String nomVet, String endVet, String telVet) {
        this.nomVet = nomVet;
        this.endVet = endVet;
        this.telVet = telVet;
        listaConsultas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setListaConsultas(ArrayList<Consulta> listaConsultas) {
        this.listaConsultas = listaConsultas;
    }
}