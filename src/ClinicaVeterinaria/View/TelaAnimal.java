package ClinicaVeterinaria.View;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import ClinicaVeterinaria.Controller.Controller;
import ClinicaVeterinaria.Models.Animal;

@SuppressWarnings("serial")
public class TelaAnimal extends javax.swing.JFrame {

	private JPanel jPane1;
	private JTable table;



	/**
	 * Create the frame.
	 */
	public TelaAnimal() {
		setTitle("Lista de Animais");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 544, 350);
		jPane1 = new JPanel();
		jPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jPane1);
		jPane1.setLayout(null);
		
		JLabel jLabel = new JLabel();
		jLabel.setText("Lista de Animais");
		jLabel.setBounds(211, 10, 86, 14);
		jPane1.add(jLabel);
		
		JButton btnNovoAnimal = new JButton();
		btnNovoAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		btnNovoAnimal.setText("Novo Animal");
		btnNovoAnimal.setBounds(10, 42, 111, 23);
		jPane1.add(btnNovoAnimal);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 91, 510, 194);
		jPane1.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setModel(new AnimalTableModel((ArrayList<Animal>) Controller.getAllAnimais()));
		scrollPane.setViewportView(table);
	}
	
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
			TelaNovoAnimal obj = new TelaNovoAnimal();			
			obj.setVisible(true);
			
			obj.addWindowListener(new WindowAdapter() {
		        @Override
		        public void windowClosed(WindowEvent e) {
		        	table.setModel(new AnimalTableModel((ArrayList<Animal>) Controller.getAllAnimais()));
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
				TelaAnimal frame = new TelaAnimal();
				frame.setVisible(true);
			}
		});
	}
}
