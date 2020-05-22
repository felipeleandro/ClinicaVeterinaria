package ClinicaVeterinaria.Models;

import java.util.ArrayList;

public class Especie {

	private String nomEsp;
	private ArrayList<Animal> listaAnimais;

	public Especie() {
		listaAnimais = new ArrayList<>();
	}

	public Especie(String nomEsp) {
		this.nomEsp = nomEsp;
		listaAnimais = new ArrayList<>();
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
