package ClinicaVeterinaria.Models.Models;

public enum SexoAnimal {
	Macho("M"), Fêmea("F");
	
	private String sexo;

	SexoAnimal(String sexo) {
		this.sexo = sexo;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public static SexoAnimal fromSexo(String sexo) {
		
		for (SexoAnimal current : SexoAnimal.values()) {
			if (current.sexo.equalsIgnoreCase(sexo))
				return current;
		}
			
		return Macho;
	}

}
