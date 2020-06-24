package ClinicaVeterinaria.View.Relatorios;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import ClinicaVeterinaria.Controller.Controller;
import ClinicaVeterinaria.Models.Models.Cliente;
import ClinicaVeterinaria.View.Principal.TelaPrincipal;
import ClinicaVeterinaria.View.TableModels.ClienteAnimalTableModel;

@SuppressWarnings("serial")
public class TelaClienteAnimal extends javax.swing.JFrame {

	private JPanel jPane1;
	private JTable table;



	/**
	 * Create the frame.
	 */
	public TelaClienteAnimal() {
		setTitle("Lista de Animais");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 544, 350);
		jPane1 = new JPanel();
		jPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jPane1);
		jPane1.setLayout(null);
		
		JLabel jLabel = new JLabel();
		jLabel.setText("Lista de Clientes x Animais");
		jLabel.setBounds(189, 10, 179, 14);
		jPane1.add(jLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 34, 510, 269);
		jPane1.add(scrollPane);
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		
		table.setModel(new ClienteAnimalTableModel((ArrayList<Cliente>) Controller.getAllClientesAnimals()));
		scrollPane.setViewportView(table);
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
				TelaClienteAnimal frame = new TelaClienteAnimal();
				frame.setVisible(true);
			}
		});
	}
}