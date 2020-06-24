package ClinicaVeterinaria.View.TableModels;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import ClinicaVeterinaria.Models.Models.Consulta;

public class ConsultaTableModel extends GenericTableModel {

	public ConsultaTableModel(ArrayList vDados) {
		super(vDados, new String[] { "Id Consulta", "Nome Cliente", "Nome Animal", "Data da Consulta", "Nome Veterinário" });
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
		Consulta consulta = (Consulta) vDados.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return consulta.getIdConsulta();
		case 1:
			return consulta.getTratamento().getAnimal().getCliente().getNomCli();
		case 2:
			return consulta.getTratamento().getAnimal().getNomeAnimal();
		case 3:
			return new SimpleDateFormat("dd/MM/YYYY").format(consulta.getDatCon());
		case 4:
			return consulta.getVeterinario().getNomVet();
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Consulta consulta = (Consulta) vDados.get(rowIndex);

		switch (columnIndex) {
		case 0:
			consulta.getTratamento().getAnimal().getCliente().setNomCli((String) aValue);
			break;
		case 1:
			consulta.getTratamento().getAnimal().setNomeAnimal((String) aValue);
			break;
		case 2:
			consulta.setDatCon((Date) aValue);
			break;
		case 3:
			consulta.getVeterinario().setNomVet((String) aValue);
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
