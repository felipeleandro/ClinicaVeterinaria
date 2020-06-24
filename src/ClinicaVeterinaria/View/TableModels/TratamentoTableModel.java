package ClinicaVeterinaria.View.TableModels;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import ClinicaVeterinaria.Models.Models.Animal;
import ClinicaVeterinaria.Models.Models.Especie;
import ClinicaVeterinaria.Models.Models.SexoAnimal;
import ClinicaVeterinaria.Models.Models.Tratamento;

public class TratamentoTableModel extends GenericTableModel {

	public TratamentoTableModel(ArrayList vDados) {
		super(vDados, new String[] { "Id Tratamento", "Nome Cliente", "Nome Animal", "Data Inicial", "Data Final" });
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
		Tratamento tratamento = (Tratamento) vDados.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return tratamento.getIdTratamento();
		case 1:
			return tratamento.getAnimal().getCliente().getNomCli();
		case 2:
			return tratamento.getAnimal().getNomeAnimal();
		case 3:
			return new SimpleDateFormat("dd/MM/YYYY").format(tratamento.getDatIni());
		case 4:
			if (tratamento.getDatFim() != null)
			{
				return new SimpleDateFormat("dd/MM/YYYY").format(tratamento.getDatFim());
			}
			else
			{
				return "";
			}

		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

}
