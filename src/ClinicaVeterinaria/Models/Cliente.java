package ClinicaVeterinaria.Models;

import ClinicaVeterinaria.Models.Animal;

import java.util.ArrayList;

public class Cliente {
	private int idCli;
	private String nomCli;
	private String endCli;
	private String telCli;
	private String cepCli;
	private String emailCli;
	private ArrayList<Animal> listaAnimais;

	public Cliente() {
		listaAnimais = new ArrayList<>();
	}

	public Cliente(int idCli, String nomCli, String endCli, String telCli, String cepCli, String emailCli) {
		this.idCli  = idCli;
		this.nomCli = nomCli;
		this.endCli = endCli;
		this.telCli = telCli;
		this.cepCli = cepCli;
		this.emailCli = emailCli;
		listaAnimais = new ArrayList<>();
	}
	
	public int getidCli() {
		return idCli;
	}
	
	public void setidCli(int idCli) {
		this.idCli = idCli;
	}
	
	public int RegCli() {
		return 0;
	}

	public String Concli() {
		return null;
	}

	public String getNomCli() {
		return nomCli;
	}

	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}

	public String getEndCli() {
		return endCli;
	}

	public void setEndCli(String endCli) {
		this.endCli = endCli;
	}

	public String getTelCli() {
		return telCli;
	}

	public void setTelCli(String telCli) {
		this.telCli = telCli;
	}

	public String getCepCli() {
		return cepCli;
	}

	public void setCepCli(String cepCli) {
		this.cepCli = cepCli;
	}

	public String getEmailCli() {
		return emailCli;
	}

	public void setEmailCli(String emailCli) {
		this.emailCli = emailCli;
	}

	public ArrayList<Animal> getListaAnimais() {
		return listaAnimais;
	}

	public void setListaAnimais(ArrayList<Animal> listaAnimais) {
		this.listaAnimais = listaAnimais;
	}

	@Override
	public String toString() {
		return "Nome: " + nomCli + " " +
			   "Endereço: " + endCli + " " +
			   "Telefone: " + telCli + " ";
	}
}
