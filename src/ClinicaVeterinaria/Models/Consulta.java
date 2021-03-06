package ClinicaVeterinaria.Models;

import java.util.ArrayList;
import java.util.Date;

public class Consulta
 {
	private Date datCon;
	private String historico;
	private Tratamento tratamento;
	private Veterinario veterinario;
	private ArrayList<Exame> listaExames;

	 public Consulta() {
		 listaExames = new ArrayList<>();
	 }

	 public Consulta(Date datCon, String historico)
	{
		this.datCon = datCon;
		this.historico = historico;
		listaExames = new ArrayList<>();
	}

	 public Date getDatCon() {
		 return datCon;
	 }

	 public void setDatCon(Date datCon) {
		 this.datCon = datCon;
	 }

	 public String getHistorico() {
		 return historico;
	 }

	 public void setHistorico(String historico) {
		 this.historico = historico;
	 }

	 public Tratamento getTratamento() {
		 return tratamento;
	 }

	 public void setTratamento(Tratamento tratamento) {
		 this.tratamento = tratamento;
	 }

	 public Veterinario getVeterinario() {
		 return veterinario;
	 }

	 public void setVeterinario(Veterinario veterinario) {
		 this.veterinario = veterinario;
	 }

	 public ArrayList<Exame> getListaExames() {
		 return listaExames;
	 }

	 public void setListaExames(ArrayList<Exame> listaExames) {
		 this.listaExames = listaExames;
	 }
 }
