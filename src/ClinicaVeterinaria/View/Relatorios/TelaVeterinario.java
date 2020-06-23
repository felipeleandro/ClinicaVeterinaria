package ClinicaVeterinaria.View.Relatorios;

import java.awt.EventQueue;
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
import ClinicaVeterinaria.Models.Veterinario;
import ClinicaVeterinaria.View.Atualizacao.TelaAtualizarAnimal;
import ClinicaVeterinaria.View.Atualizacao.TelaAtualizarVeterinario;
import ClinicaVeterinaria.View.Cadastros.TelaNovoAnimal;
import ClinicaVeterinaria.View.Cadastros.TelaNovoVeterinario;
import ClinicaVeterinaria.View.Principal.TelaPrincipal;
import ClinicaVeterinaria.View.TableModels.AnimalTableModel;
import ClinicaVeterinaria.View.TableModels.VeterinarioTableModel;

import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TelaVeterinario extends javax.swing.JFrame {

	private JPanel jPane1;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public TelaVeterinario() {
		setTitle("Lista de Veterin\u00E1rios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 544, 350);
		jPane1 = new JPanel();
		jPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jPane1);
		jPane1.setLayout(null);

		JLabel jLabel = new JLabel();
		jLabel.setText("Lista de Veterin\u00E1rios");
		jLabel.setBounds(211, 10, 183, 14);
		jPane1.add(jLabel);

		JButton btnNovoVeterinario = new JButton();
		btnNovoVeterinario.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		btnNovoVeterinario.setText("Novo Veterin\u00E1rio");
		btnNovoVeterinario.setBounds(10, 42, 135, 23);
		jPane1.add(btnNovoVeterinario);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 75, 510, 228);
		jPane1.add(scrollPane);

		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(new VeterinarioTableModel((ArrayList<Veterinario>) Controller.getAllVeterinarios()));
		scrollPane.setViewportView(table);

		JButton btnAtualizarVeterinario = new JButton("Atualizar Veterin\u00E1rio");
		btnAtualizarVeterinario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Selecione um registro para continuar.");
				} else {

					TelaAtualizarVeterinario obj = new TelaAtualizarVeterinario();
					
					obj.txtIdVeterinario.setText(table.getModel().getValueAt(table.getSelectedRow(), 3).toString());
					obj.txtNome.setText(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
					obj.txtEndereco.setText(table.getModel().getValueAt(table.getSelectedRow(), 1).toString());
					obj.txtTelefone.setText(table.getModel().getValueAt(table.getSelectedRow(), 2).toString());
					
					obj.setVisible(true);

					obj.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosed(WindowEvent e) {
							table.setModel(new VeterinarioTableModel((ArrayList<Veterinario>) Controller.getAllVeterinarios()));
						}

					});
				}
			}
		});
		btnAtualizarVeterinario.setBounds(155, 42, 135, 23);
		jPane1.add(btnAtualizarVeterinario);
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		TelaNovoVeterinario obj = new TelaNovoVeterinario();
		obj.setVisible(true);

		obj.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				table.setModel(new VeterinarioTableModel((ArrayList<Veterinario>) Controller.getAllVeterinarios()));
			}

		});

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				TelaVeterinario frame = new TelaVeterinario();
				frame.setVisible(true);
			}
		});
	}
}
