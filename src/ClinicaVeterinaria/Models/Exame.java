package ClinicaVeterinaria.Models;

public class Exame
{
    private String desExame;
    private Consulta consulta;

    public Exame() {
    }

    public Exame(String desExame, Consulta consulta) {
        this.desExame = desExame;
        this.consulta = consulta;
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