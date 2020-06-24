package ClinicaVeterinaria.Models.Models;

import java.util.ArrayList;
import java.util.Date;

public class Consulta {
	private int idConsulta;
	private Date datCon;
	private String historico;
	private Tratamento tratamento;
	private Veterinario veterinario;
	private ArrayList<Exame> listaExames;

	public Consulta() {
		listaExames = new ArrayList<>();
	}

	public Consulta(int idConsulta, Date datCon, String historico, Tratamento tratamento, Veterinario veterinario) {
		this.idConsulta = idConsulta;
		this.datCon = datCon;
		this.historico = historico;
		this.tratamento = tratamento;
		this.veterinario = veterinario;
		listaExames = new ArrayList<>();
	}

	public int getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
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

	public void addListaExames(Exame exame) {
		this.listaExames.add(exame);
	}
}
