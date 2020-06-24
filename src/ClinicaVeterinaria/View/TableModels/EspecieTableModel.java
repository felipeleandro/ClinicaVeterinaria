package ClinicaVeterinaria.View.TableModels;

import java.util.ArrayList;

import ClinicaVeterinaria.Models.Models.Animal;
import ClinicaVeterinaria.Models.Models.Especie;
import ClinicaVeterinaria.Models.Models.SexoAnimal;
import ClinicaVeterinaria.Models.Models.Tratamento;
import ClinicaVeterinaria.Models.Models.Veterinario;

public class EspecieTableModel extends GenericTableModel {

	public EspecieTableModel(ArrayList vDados) {
		super(vDados, new String[] { "Id Espécie", "Espécie" });
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Especie especie = (Especie) vDados.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return especie.getIdEspecie();
		case 1:
			return especie.getNomEsp();
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Especie especie = (Especie) vDados.get(rowIndex);

		switch (columnIndex) {
		case 0:
			especie.setNomEsp((String) aValue);
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
