package ClinicaVeterinaria.Models.Models;

import java.util.ArrayList;
import java.util.Date;

public class Tratamento {
	private int idTratamento;
	private Date datIni;
	private Date datFim;
	private Animal animal;
	private ArrayList<Consulta> listaConsultas;

	public Tratamento() {
		listaConsultas = new ArrayList<>();
	}

	public Tratamento(int idTratamento, Animal animal, Date datIni, Date datFim) {
		this.idTratamento = idTratamento;
		this.datIni = datIni;
		this.datFim = datFim;
		this.animal = animal;
		listaConsultas = new ArrayList<>();
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public int getIdTratamento() {
		return idTratamento;
	}

	public void setIdTratamento(int idTratamento) {
		this.idTratamento = idTratamento;
	}

	public Date getDatIni() {
		return datIni;
	}

	public void setDatIni(Date datIni) {
		this.datIni = datIni;
	}

	public Date getDatFim() {
		return datFim;
	}

	public void setDatFim(Date datFim) {
		this.datFim = datFim;
	}

	public ArrayList<Consulta> getListaConsultas() {
		return listaConsultas;
	}

	public void setListaConsultas(ArrayList<Consulta> listaConsultas) {
		this.listaConsultas = listaConsultas;
	}

	public String VisTrat() {
		return null;
	}

	public String ConTrat() {
		return null;
	}

	public int RegTrat() {
		return 0;
	}
}