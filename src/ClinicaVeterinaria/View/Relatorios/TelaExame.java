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
import ClinicaVeterinaria.Models.Models.Exame;
import ClinicaVeterinaria.Models.Models.Veterinario;
import ClinicaVeterinaria.View.Atualizacao.TelaAtualizarAnimal;
import ClinicaVeterinaria.View.Atualizacao.TelaAtualizarVeterinario;
import ClinicaVeterinaria.View.Cadastros.TelaNovoAnimal;
import ClinicaVeterinaria.View.Cadastros.TelaNovoVeterinario;
import ClinicaVeterinaria.View.Principal.TelaPrincipal;
import ClinicaVeterinaria.View.Processos.TelaAtualizarExame;
import ClinicaVeterinaria.View.Processos.TelaMarcarConsulta;
import ClinicaVeterinaria.View.Processos.TelaMarcarExame;
import ClinicaVeterinaria.View.TableModels.AnimalTableModel;
import ClinicaVeterinaria.View.TableModels.ConsultaTableModel;
import ClinicaVeterinaria.View.TableModels.ExameTableModel;
import ClinicaVeterinaria.View.TableModels.VeterinarioTableModel;

import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TelaExame extends javax.swing.JFrame {

	private JPanel jPane1;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public TelaExame() {
		setTitle("Lista de Exames");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 544, 350);
		jPane1 = new JPanel();
		jPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jPane1);
		jPane1.setLayout(null);

		JLabel jLabel = new JLabel();
		jLabel.setText("Lista de Exames");
		jLabel.setBounds(211, 10, 183, 14);
		jPane1.add(jLabel);

		JButton btnMarcarExame = new JButton();
		btnMarcarExame.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnMarcarConsultaActionPerformed(evt);
			}
		});
		btnMarcarExame.setText("Marcar Exame");
		btnMarcarExame.setBounds(10, 42, 135, 23);
		jPane1.add(btnMarcarExame);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 75, 510, 228);
		jPane1.add(scrollPane);

		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(new ExameTableModel((ArrayList<Exame>) Controller.getAllExames()));
		scrollPane.setViewportView(table);

		JButton btnAtualizarConsulta = new JButton("Atualizar Exame");
		btnAtualizarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Selecione um registro para continuar.");
				} else {

					TelaAtualizarExame obj = new TelaAtualizarExame();
					
					obj.txtIdExame.setText(table.getModel().getValueAt(table.getSelectedRow(), 2).toString());
					obj.txtDescricaoExame.setText(table.getModel().getValueAt(table.getSelectedRow(), 1).toString());
				
					obj.setVisible(true);

					obj.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosed(WindowEvent e) {
							table.setModel(new ExameTableModel((ArrayList<Exame>) Controller.getAllExames()));
						}

					});
				}
			}
		});
		btnAtualizarConsulta.setBounds(155, 42, 135, 23);
		jPane1.add(btnAtualizarConsulta);
	}

	private void btnMarcarConsultaActionPerformed(java.awt.event.ActionEvent evt) {
		TelaMarcarExame obj = new TelaMarcarExame();
		obj.setVisible(true);

		obj.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				table.setModel(new ExameTableModel((ArrayList<Exame>) Controller.getAllExames()));
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
				TelaExame frame = new TelaExame();
				frame.setVisible(true);
			}
		});
	}
}
