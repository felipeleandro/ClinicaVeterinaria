package ClinicaVeterinaria.View.TableModels;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import ClinicaVeterinaria.Models.Models.Consulta;
import ClinicaVeterinaria.Models.Models.Exame;

public class ExameTableModel extends GenericTableModel {

	public ExameTableModel(ArrayList vDados) {
		super(vDados, new String[] { "Id Consulta", "Descrição Exame"});
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
		Exame exame = (Exame) vDados.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return exame.getConsulta().getIdConsulta();
		case 1:
			return exame.getDesExame();
		case 2:
			return exame.getIdExame();
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

}
