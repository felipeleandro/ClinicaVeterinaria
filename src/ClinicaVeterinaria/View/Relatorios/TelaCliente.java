package ClinicaVeterinaria.View.Relatorios;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import ClinicaVeterinaria.Controller.Controller;
import ClinicaVeterinaria.Models.Animal;
import ClinicaVeterinaria.Models.Cliente;
import ClinicaVeterinaria.View.Atualizacao.TelaAtualizarAnimal;
import ClinicaVeterinaria.View.Atualizacao.TelaAtualizarCliente;
import ClinicaVeterinaria.View.Cadastros.TelaNovoCliente;
import ClinicaVeterinaria.View.TableModels.AnimalTableModel;
import ClinicaVeterinaria.View.TableModels.ClienteTableModel;

public class TelaCliente extends JFrame {

	private JPanel contentPane;
	private JTable jTable1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente frame = new TelaCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCliente() {
		setTitle("Lista de Clientes");
        initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 541, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);		
		contentPane.setLayout(null);
		
		JPanel jPanel1 = new JPanel();
		jPanel1.setBounds(10, 10, 513, 312);
		contentPane.add(jPanel1);
		
		JScrollPane jScrollPane1 = new JScrollPane();
		jScrollPane1.setBounds(10, 78, 493, 224);
		
		JLabel jLabel1 = new JLabel();
		jLabel1.setBounds(221, 10, 91, 13);
		jLabel1.setText("Lista de Clientes");
		
		JButton btnNovoCliente = new JButton();
		btnNovoCliente.setBounds(10, 31, 125, 23);
		btnNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaNovoCliente obj = new TelaNovoCliente();			
				obj.setVisible(true);
				
				obj.addWindowListener(new WindowAdapter() {
			        @Override
			        public void windowClosed(WindowEvent e) {
			        	jTable1.setModel(new ClienteTableModel((ArrayList) Controller.getAllClientes()));
			        }

			    });
			}
		});
		btnNovoCliente.setText("Novo Cliente");
		
		jTable1 = new JTable();
		jTable1.setCellSelectionEnabled(true);
		jTable1.setColumnSelectionAllowed(true);
		jTable1.setModel(new ClienteTableModel((ArrayList) Controller.getAllClientes()));
		jScrollPane1.setViewportView(jTable1);
		jPanel1.setLayout(null);
		jPanel1.add(jLabel1);
		jPanel1.add(btnNovoCliente);
		jPanel1.add(jScrollPane1);
		
		JButton btnAtualizarCliente = new JButton();
		btnAtualizarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (jTable1.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Selecione um registro para continuar.");
				} else {

					TelaAtualizarCliente obj = new TelaAtualizarCliente();
					
					obj.txtNome.setText(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0).toString());
					obj.txtEndereco.setText(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 1).toString());
					obj.txtTelefone.setText(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 2).toString());
					obj.txtCEP.setText(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 3).toString());
					obj.txtEmail.setText(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 4).toString());															
					obj.txtIdCliente.setText(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 5).toString());
					
					obj.setVisible(true);

					obj.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosed(WindowEvent e) {
							jTable1.setModel(new ClienteTableModel((ArrayList<Cliente>) Controller.getAllClientes()));
						}

					});
				}
			}
		});
		btnAtualizarCliente.setText("Atualizar Cliente");
		btnAtualizarCliente.setBounds(145, 31, 125, 23);
		jPanel1.add(btnAtualizarCliente);
	}
}