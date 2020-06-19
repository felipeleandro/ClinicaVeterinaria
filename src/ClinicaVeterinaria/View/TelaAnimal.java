package ClinicaVeterinaria.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class TelaAnimal extends javax.swing.JFrame {

	private JPanel jPane1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAnimal frame = new TelaAnimal();
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
	public TelaAnimal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		jPane1 = new JPanel();
		jPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jPane1);
		jPane1.setLayout(null);
		
		JLabel jLabel = new JLabel();
		jLabel.setText("Lista de Animais");
		jLabel.setBounds(201, 23, 78, 14);
		jPane1.add(jLabel);
		
		JButton jButton1 = new JButton();
		jButton1.setText("Novo Animal");
		jButton1.setBounds(10, 42, 111, 23);
		jPane1.add(jButton1);
	}
}
