package ClinicaVeterinaria.View;

import java.util.ArrayList;

import ClinicaVeterinaria.Models.Animal;
import ClinicaVeterinaria.Models.Especie;
import ClinicaVeterinaria.Models.Tratamento;


public class AnimalTableModel extends GenericTableModel{

	public AnimalTableModel(ArrayList vDados) {
		super(vDados, new String[] { "nomeAnimal", "idadeAnimal", "sexoAnimal", "especie","tratamento" });
	}

	 @Override
	    public Class<?> getColumnClass(int columnIndex) {
	        switch (columnIndex) {
	            case 0:
	                return String.class;
	            case 1:
	                return String.class;
	            case 2:
	                return String.class;
	            case 3:
	                return String.class;
	            case 4:
	                return String.class;
	            default:
	                throw new IndexOutOfBoundsException("columnIndex out of bounds");
	        }
	    }
	 @Override
	    public Object getValueAt(int rowIndex, int columnIndex) {
	        Animal animal = (Animal) vDados.get(rowIndex);

	        switch (columnIndex) {
	            case 0:
	                return animal.getNomeAnimal();
	            case 1:
	                return animal.getIdadeAnimal();
	            case 2:
	                return animal.getSexoAnimal();
	            case 3:
	                return animal.getEspecie();
	            case 4:
	                return animal.getListaTratamentos();
	            default:
	                throw new IndexOutOfBoundsException("columnIndex out of bounds");
	        }
	    }
	 @Override
	    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	        Animal animal = (Animal) vDados.get(rowIndex);

	        switch (columnIndex) {
	            case 0:
	                animal.setNomeAnimal((String) aValue);
	                break;
	            case 1:
	                animal.setIdadeAnimal((int) aValue);
	                break;
	            case 2:
	                animal.setSexoAnimal((int) aValue);
	                break;
	            case 3:
	                animal.setEspecie((Especie) aValue);
	                break;
	            case 4:
	                animal.setListaTratamentos((ArrayList<Tratamento>) aValue);
	                break;    
	            default:
	                throw new IndexOutOfBoundsException("columnIndex out of bounds");
	        }
	 }
	        @Override
	        public boolean isCellEditable(int rowIndex, int columnIndex) {
	            return true;
	        }

}
