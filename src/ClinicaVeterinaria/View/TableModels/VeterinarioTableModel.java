package ClinicaVeterinaria.View.TableModels;

import java.util.ArrayList;

import ClinicaVeterinaria.Models.Animal;
import ClinicaVeterinaria.Models.Especie;
import ClinicaVeterinaria.Models.SexoAnimal;
import ClinicaVeterinaria.Models.Tratamento;
import ClinicaVeterinaria.Models.Veterinario;


public class VeterinarioTableModel extends GenericTableModel{

	public VeterinarioTableModel(ArrayList vDados) {
		super(vDados, new String[] { "Nome", "Endereço", "Telefone"});
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
	            default:
	                throw new IndexOutOfBoundsException("columnIndex out of bounds");
	        }
	    }
	 @Override
	    public Object getValueAt(int rowIndex, int columnIndex) {
	        Veterinario veterinario = (Veterinario) vDados.get(rowIndex);

	        switch (columnIndex) {
	            case 0:
	                return veterinario.getNomVet();
	            case 1:
	            	return veterinario.getEndVet();	                
	            case 2:
	            	return veterinario.getTelVet();                
	            case 3:
	            	return veterinario.getIdVeterinario();
	            	            
	            default:
	                throw new IndexOutOfBoundsException("columnIndex out of bounds");
	        }
	    }
	 @Override
	    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	        Veterinario veterinario = (Veterinario) vDados.get(rowIndex);

	        switch (columnIndex) {
	            case 0:
	            	veterinario.setNomVet((String) aValue);
	                break;
	            case 1:
	            	veterinario.setEndVet((String) aValue);	                
	                break;
	            case 2:
	            	veterinario.setTelVet((String) aValue);	                
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
