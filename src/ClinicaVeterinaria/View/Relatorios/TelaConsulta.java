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
import ClinicaVeterinaria.Models.Models.Animal;
import ClinicaVeterinaria.Models.Models.Consulta;
import ClinicaVeterinaria.Models.Models.Veterinario;
import ClinicaVeterinaria.View.Atualizacao.TelaAtualizarAnimal;
import ClinicaVeterinaria.View.Atualizacao.TelaAtualizarVeterinario;
import ClinicaVeterinaria.View.Cadastros.TelaNovoAnimal;
import ClinicaVeterinaria.View.Cadastros.TelaNovoVeterinario;
import ClinicaVeterinaria.View.Principal.TelaPrincipal;
import ClinicaVeterinaria.View.Processos.TelaAtualizarConsulta;
import ClinicaVeterinaria.View.Processos.TelaMarcarConsulta;
import ClinicaVeterinaria.View.Processos.TelaMarcarExame;
import ClinicaVeterinaria.View.TableModels.AnimalTableModel;
import ClinicaVeterinaria.View.TableModels.ConsultaTableModel;
import ClinicaVeterinaria.View.TableModels.VeterinarioTableModel;

import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TelaConsulta extends javax.swing.JFrame {

	private JPanel jPane1;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public TelaConsulta() {
		setTitle("Lista de Consultas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 544, 350);
		jPane1 = new JPanel();
		jPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jPane1);
		jPane1.setLayout(null);

		JLabel jLabel = new JLabel();
		jLabel.setText("Lista de Consultas");
		jLabel.setBounds(211, 10, 183, 14);
		jPane1.add(jLabel);

		JButton btnMarcarConsulta = new JButton();
		btnMarcarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnMarcarConsultaActionPerformed(evt);
			}
		});
		btnMarcarConsulta.setText("Marcar Consulta");
		btnMarcarConsulta.setBounds(10, 42, 135, 23);
		jPane1.add(btnMarcarConsulta);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 75, 510, 228);
		jPane1.add(scrollPane);

		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(new ConsultaTableModel((ArrayList<Consulta>) Controller.getAllConsultas()));
		scrollPane.setViewportView(table);

		JButton btnAtualizarConsulta = new JButton("Atualizar Consulta");
		btnAtualizarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Selecione um registro para continuar.");
				} else {

					TelaAtualizarConsulta obj = new TelaAtualizarConsulta();

					obj.txtIdConsulta.setText(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
					obj.txtDataConsulta.setText(table.getModel().getValueAt(table.getSelectedRow(), 3).toString());
					obj.txtNomeVeterinario.setText(table.getModel().getValueAt(table.getSelectedRow(), 4).toString());

					obj.txtNomeVeterinario.setEnabled(false);
					obj.txtIdConsulta.setEnabled(false);

					obj.setVisible(true);

					obj.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosed(WindowEvent e) {
							table.setModel(new ConsultaTableModel((ArrayList<Consulta>) Controller.getAllConsultas()));
						}

					});
				}
			}
		});
		btnAtualizarConsulta.setBounds(155, 42, 135, 23);
		jPane1.add(btnAtualizarConsulta);

		JButton btnMarcarExame = new JButton("Marcar Exame");
		btnMarcarExame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Selecione um registro para continuar.");
				} else {

					TelaMarcarExame obj = new TelaMarcarExame();

					obj.txtIdConsulta.setText(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
					obj.txtIdConsulta.setEnabled(false);

					obj.setVisible(true);
				}
			}
		});
		btnMarcarExame.setBounds(300, 42, 135, 23);
		jPane1.add(btnMarcarExame);
	}

	private void btnMarcarConsultaActionPerformed(java.awt.event.ActionEvent evt) {
		TelaMarcarConsulta obj = new TelaMarcarConsulta();
		obj.setVisible(true);

		obj.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				table.setModel(new ConsultaTableModel((ArrayList<Consulta>) Controller.getAllConsultas()));
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
				TelaConsulta frame = new TelaConsulta();
				frame.setVisible(true);
			}
		});
	}
}
