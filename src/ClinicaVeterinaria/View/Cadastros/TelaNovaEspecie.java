package ClinicaVeterinaria.View.Cadastros;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ClinicaVeterinaria.Controller.Controller;

public class TelaNovaEspecie extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaNovaEspecie frame = new TelaNovaEspecie();
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
	public TelaNovaEspecie() {
		setTitle("Nova Esp\u00E9cie");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 483, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nova Esp\u00E9cie");
		lblNewLabel.setBounds(187, 10, 96, 13);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtNome.setBounds(20, 55, 96, 22);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNome.setBounds(20, 39, 96, 13);
		contentPane.add(lblNome);
		
		JButton btnSalvarEspecie = new JButton("Gravar");
		btnSalvarEspecie.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				
				String nomeEspecie = txtNome.getText();
				
				Controller.addEspecie(nomeEspecie);
				
				setVisible(false); 
				dispose(); 
			}
		});	
		btnSalvarEspecie.setBounds(363, 220, 96, 21);
		contentPane.add(btnSalvarEspecie);
	}
}
