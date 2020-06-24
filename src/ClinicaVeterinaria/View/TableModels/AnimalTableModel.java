package ClinicaVeterinaria.View.TableModels;

import java.util.ArrayList;

import ClinicaVeterinaria.Models.Models.Animal;
import ClinicaVeterinaria.Models.Models.Especie;
import ClinicaVeterinaria.Models.Models.SexoAnimal;
import ClinicaVeterinaria.Models.Models.Tratamento;


public class AnimalTableModel extends GenericTableModel{

	public AnimalTableModel(ArrayList vDados) {
		super(vDados, new String[] { "Nome", "Espécie", "Idade", "Gênero"});
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
	            	return animal.getEspecie();	                
	            case 2:
	            	return animal.getIdadeAnimal();	                
	            case 3:
	            	return animal.getSexoAnimal();	                
	            case 4:
	                return animal.getIdAnimal();
	            case 5:
	                return animal.getCliente().getidCli();
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
	            	animal.getEspecie().setNomEsp((String) aValue);	                
	                break;
	            case 2:
	            	animal.setIdadeAnimal((int) aValue);	                
	                break;
	            case 3:
	            	animal.setSexoAnimal(SexoAnimal.fromSexo((String) aValue));
	                break;	            
	            default:
	                throw new IndexOutOfBoundsException("columnIndex out of bounds");
	        }
	 }
	        @Override
	        public boolean isCellEditable(int rowIndex, int columnIndex) {
	            return false;
	        }

}
