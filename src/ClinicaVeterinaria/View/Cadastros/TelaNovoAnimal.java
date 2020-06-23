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
import ClinicaVeterinaria.Models.Especie;
import ClinicaVeterinaria.Models.SexoAnimal;

public class TelaNovoAnimal extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEspecie;
	private JTextField txtIdade;
	private JTextField txtSexo;
	private JTextField txtIdCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaNovoAnimal frame = new TelaNovoAnimal();
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
	public TelaNovoAnimal() {
		setTitle("Novo Animal");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 483, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Novo Animal");
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
		
		txtEspecie = new JTextField();
		txtEspecie.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtEspecie.setColumns(10);
		txtEspecie.setBounds(20, 100, 96, 22);
		contentPane.add(txtEspecie);
		
		JLabel lblEspcie = new JLabel("Esp\u00E9cie");
		lblEspcie.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblEspcie.setBounds(20, 85, 96, 13);
		contentPane.add(lblEspcie);
		
		txtIdade = new JTextField();
		txtIdade.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtIdade.setColumns(10);
		txtIdade.setBounds(20, 140, 96, 22);
		contentPane.add(txtIdade);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblIdade.setBounds(20, 125, 96, 13);
		contentPane.add(lblIdade);
		
		txtSexo = new JTextField();
		txtSexo.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtSexo.setColumns(10);
		txtSexo.setBounds(20, 180, 96, 22);
		contentPane.add(txtSexo);
		
		JLabel lblSexo = new JLabel("Sexo (M ou F)");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSexo.setBounds(20, 165, 96, 13);
		contentPane.add(lblSexo);
		
		JLabel lblIdDoCliente = new JLabel("Id do Cliente");
		lblIdDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblIdDoCliente.setBounds(20, 205, 96, 13);
		contentPane.add(lblIdDoCliente);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtIdCliente.setColumns(10);
		txtIdCliente.setBounds(20, 220, 96, 22);
		contentPane.add(txtIdCliente);
		
		JButton btnSalvarAnimal = new JButton("Gravar");
		btnSalvarAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeAnimal = txtNome.getText();
				String nomeEspecie = txtEspecie.getText();
				int idadeAnimal = Integer.parseInt(txtIdade.getText());				
				int idCliente = Integer.parseInt(txtIdCliente.getText());				
				
				SexoAnimal sexoAnimalClasse = SexoAnimal.fromSexo(txtSexo.getText());
				Especie especie = new Especie(1, nomeEspecie);				
				
				Controller.addAnimal(nomeAnimal, idadeAnimal, sexoAnimalClasse, especie, idCliente);
				
				setVisible(false); 
				dispose(); 
			}
		});	
		btnSalvarAnimal.setBounds(363, 220, 96, 21);
		contentPane.add(btnSalvarAnimal);
	}
}
