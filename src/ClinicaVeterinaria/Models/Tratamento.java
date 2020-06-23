package ClinicaVeterinaria.Models;

import java.util.ArrayList;
import java.util.Date;

public class Tratamento {
	private int idTratamento;
	private Date datIni;
	private Date datFim;
	private ArrayList<Consulta> listaConsultas;

	public Tratamento() {
		listaConsultas = new ArrayList<>();
	}

	public Tratamento(int idTratamento, Date datIni, Date datFim) {
		this.idTratamento = idTratamento;
		this.datIni = datIni;
		this.datFim = datFim;
		listaConsultas = new ArrayList<>();
	}

	public Tratamento(Date datIni, Date datFim) {
		this.datIni = datIni;
		this.datFim = datFim;
		listaConsultas = new ArrayList<>();
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