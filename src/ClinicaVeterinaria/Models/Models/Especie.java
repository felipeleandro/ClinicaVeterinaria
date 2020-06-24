package ClinicaVeterinaria.Models.Models;

import java.util.ArrayList;

public class Especie {

	private int idEspecie;
	private String nomEsp;
	private ArrayList<Animal> listaAnimais;

	public Especie() {
		listaAnimais = new ArrayList<>();
	}

	public Especie(int idEspecie, String nomEsp) {
		this.idEspecie = idEspecie;
		this.nomEsp = nomEsp;
		listaAnimais = new ArrayList<>();
	}

	public int getIdEspecie() {
		return idEspecie;
	}

	public void setIdEspecie(int idEspecie) {
		this.idEspecie = idEspecie;
	}

	public String getNomEsp() {
		return nomEsp;
	}

	public void setNomEsp(String nomEsp) {
		this.nomEsp = nomEsp;
	}

	public ArrayList<Animal> getListaAnimais() {
		return listaAnimais;
	}

	public void setListaAnimais(ArrayList<Animal> listaAnimais) {
		this.listaAnimais = listaAnimais;
	}

	@Override
	public String toString() {
		return nomEsp;
	}
}
