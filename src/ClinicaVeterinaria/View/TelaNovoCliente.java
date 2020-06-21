package ClinicaVeterinaria.View;

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

public class TelaNovoCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtTelefone;
	private JTextField txtCEP;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaNovoCliente frame = new TelaNovoCliente();
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
	public TelaNovoCliente() {
		setTitle("Novo Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 483, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Novo Cliente");
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
		
		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(20, 100, 96, 22);
		contentPane.add(txtEndereco);
		
		JLabel lblEspcie = new JLabel("Endere\u00E7o");
		lblEspcie.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblEspcie.setBounds(20, 85, 96, 13);
		contentPane.add(lblEspcie);
		
		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(20, 140, 96, 22);
		contentPane.add(txtTelefone);
		
		JLabel lblIdade = new JLabel("Telefone");
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblIdade.setBounds(20, 125, 96, 13);
		contentPane.add(lblIdade);
		
		txtCEP = new JTextField();
		txtCEP.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtCEP.setColumns(10);
		txtCEP.setBounds(20, 180, 96, 22);
		contentPane.add(txtCEP);
		
		JLabel lblSexo = new JLabel("CEP");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSexo.setBounds(20, 165, 96, 13);
		contentPane.add(lblSexo);
		
		JLabel lblIdDoCliente = new JLabel("E-mail");
		lblIdDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblIdDoCliente.setBounds(20, 205, 96, 13);
		contentPane.add(lblIdDoCliente);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtEmail.setColumns(10);
		txtEmail.setBounds(20, 220, 96, 22);
		contentPane.add(txtEmail);
		
		JButton btnSalvarAnimal = new JButton("Gravar");
		btnSalvarAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeCliente = txtNome.getText();
				String enderecoCliente = txtEndereco.getText();
				String telCliente = txtTelefone.getText();
				String cepCliente = txtCEP.getText();
				String emailCliente = txtEmail.getText();					
				
				Controller.addCliente(nomeCliente, enderecoCliente, telCliente, cepCliente, emailCliente);
				
				setVisible(false); 
				dispose(); 
			}
		});	
		btnSalvarAnimal.setBounds(363, 220, 96, 21);
		contentPane.add(btnSalvarAnimal);
	}
}
