package ClinicaVeterinaria.View.Atualizacao;

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

public class TelaAtualizarVeterinario extends JFrame {

	private JPanel contentPane;
	public JTextField txtNome;
	public JTextField txtEndereco;
	public JTextField txtTelefone;
	public JTextField txtIdVeterinario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarVeterinario frame = new TelaAtualizarVeterinario();
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
	public TelaAtualizarVeterinario() {
		setTitle("Atualizar Veterin\u00E1rio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 483, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Atualizar Veterin\u00E1rio");
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
		
		JButton btnSalvarVeterinario = new JButton("Gravar");
		btnSalvarVeterinario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int idVeterinario = Integer.parseInt(txtIdVeterinario.getText());
				String nomeVeterinario = txtNome.getText();
				String enderecoVeterinario = txtEndereco.getText();
				String telVeterinario = txtTelefone.getText();									
				
				Controller.updateVeterinario(idVeterinario, nomeVeterinario, enderecoVeterinario, telVeterinario);
				
				setVisible(false); 
				dispose(); 
			}
		});	
		btnSalvarVeterinario.setBounds(363, 220, 96, 21);
		contentPane.add(btnSalvarVeterinario);
		
		txtIdVeterinario = new JTextField();
		txtIdVeterinario.setBounds(266, 9000, 96, 19);
		contentPane.add(txtIdVeterinario);
		txtIdVeterinario.setColumns(10);
	}
}
