package ClinicaVeterinaria.View.TableModels;

import java.util.ArrayList;

import ClinicaVeterinaria.Models.Animal;
import ClinicaVeterinaria.Models.Cliente;
import ClinicaVeterinaria.Models.Especie;
import ClinicaVeterinaria.Models.SexoAnimal;
import ClinicaVeterinaria.Models.Tratamento;


public class ClienteAnimalTableModel extends GenericTableModel{

	public ClienteAnimalTableModel(ArrayList vDados) {
		super(vDados, new String[] { "Nome Cliente", "Nome Animal", "Idade Animal", "Gênero Animal", "Espécie Animal"});
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
	        Cliente cliente = (Cliente) vDados.get(rowIndex);

	        switch (columnIndex) {
	            case 0:
	                return cliente.getNomCli();
	            case 1:
	                return cliente.getListaAnimais().get(rowIndex).getNomeAnimal();
	            case 2:
	            	return cliente.getListaAnimais().get(rowIndex).getIdadeAnimal();
	            case 3:
	            	return cliente.getListaAnimais().get(rowIndex).getSexoAnimal();
	            case 4:
	            	return cliente.getListaAnimais().get(rowIndex).getEspecie().getNomEsp();	            
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
	                animal.setSexoAnimal(SexoAnimal.fromSexo((String) aValue));
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
