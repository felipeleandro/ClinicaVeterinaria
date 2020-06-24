package ClinicaVeterinaria.View.TableModels;

import java.util.ArrayList;

import ClinicaVeterinaria.Models.Models.Cliente;

public class ClienteTableModel extends GenericTableModel {

    public ClienteTableModel(ArrayList vDados) {
        super(vDados, new String[] { "Nome", "Endereço", "Telefone", "CEP", "E-mail"});
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
                return cliente.getEndCli();
            case 2:
                return cliente.getTelCli();
            case 3:
                return cliente.getCepCli();
            case 4:
                return cliente.getEmailCli();
            case 5:
                return cliente.getidCli();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Cliente cliente = (Cliente) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                cliente.setNomCli((String) aValue);
                break;
            case 1:
                cliente.setEndCli((String) aValue);
                break;
            case 2:
                cliente.setTelCli((String) aValue);
                break;
            case 3:
                cliente.setCepCli((String) aValue);
                break;
            case 4:
                cliente.setEmailCli((String) aValue);
                break;                
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

     //AARUMAR   ClienteDAO.getInstance().updateCliente(cliente);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
