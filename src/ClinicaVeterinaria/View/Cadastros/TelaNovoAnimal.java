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
import ClinicaVeterinaria.Models.Models.Especie;
import ClinicaVeterinaria.Models.Models.SexoAnimal;

public class TelaNovoAnimal extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtNomeEspecie;
	private JTextField txtIdade;
	private JTextField txtSexo;
	private JTextField txtNomeCliente;

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

		txtNomeEspecie = new JTextField();
		txtNomeEspecie.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtNomeEspecie.setColumns(10);
		txtNomeEspecie.setBounds(20, 100, 96, 22);
		contentPane.add(txtNomeEspecie);

		JLabel lblEspecie = new JLabel("Esp\u00E9cie");
		lblEspecie.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblEspecie.setBounds(20, 85, 96, 13);
		contentPane.add(lblEspecie);

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

		JLabel lblNomeCliente = new JLabel("Nome do Cliente");
		lblNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNomeCliente.setBounds(20, 205, 96, 13);
		contentPane.add(lblNomeCliente);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtNomeCliente.setColumns(10);
		txtNomeCliente.setBounds(20, 220, 96, 22);
		contentPane.add(txtNomeCliente);

		JButton btnSalvarAnimal = new JButton("Gravar");
		btnSalvarAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nomeAnimal = txtNome.getText();
				int idadeAnimal = Integer.parseInt(txtIdade.getText());
				int idCliente = Controller.getClienteByNome(txtNomeCliente.getText()).getidCli();

				SexoAnimal sexoAnimalClasse = SexoAnimal.fromSexo(txtSexo.getText());
				Especie especie = Controller.getEspecieByNome(txtNomeEspecie.getText());

				Controller.addAnimal(nomeAnimal, idadeAnimal, sexoAnimalClasse, especie, idCliente);

				setVisible(false);
				dispose();
			}
		});
		btnSalvarAnimal.setBounds(363, 220, 96, 21);
		contentPane.add(btnSalvarAnimal);
	}
}
