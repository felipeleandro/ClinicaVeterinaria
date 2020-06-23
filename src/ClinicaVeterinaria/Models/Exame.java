package ClinicaVeterinaria.Models;

public class Exame
{
	private int idExame;
    private String desExame;
    private Consulta consulta;

    public Exame() {
    }
    
    public Exame(int idExame, String desExame, Consulta consulta) {
    	this.idExame = idExame;
        this.desExame = desExame;
        this.consulta = consulta;
    }

    public Exame(String desExame, Consulta consulta) {
        this.desExame = desExame;
        this.consulta = consulta;
    }

    public int getIdExame() {
		return idExame;
	}

	public void setIdExame(int idExame) {
		this.idExame = idExame;
	}

	public String getDesExame() {
        return desExame;
    }

    public void setDesExame(String desExame) {
        this.desExame = desExame;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}