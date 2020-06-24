package ClinicaVeterinaria.View.Processos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import ClinicaVeterinaria.Controller.Controller;
import ClinicaVeterinaria.Models.Models.Animal;
import ClinicaVeterinaria.Models.Models.Cliente;
import ClinicaVeterinaria.Models.Models.Tratamento;
import ClinicaVeterinaria.Models.Models.Veterinario;

public class TelaMarcarConsulta extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeVeterinario;
	public JTextField txtIdTratamento;
	private JFormattedTextField txtDataConsulta;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMarcarConsulta frame = new TelaMarcarConsulta();
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
	public TelaMarcarConsulta() {
		setTitle("Marcar Consulta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 483, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Marcar Consulta");
		lblTitulo.setBounds(187, 10, 96, 13);
		contentPane.add(lblTitulo);

		MaskFormatter maskData = null;
		try {
			maskData = new MaskFormatter("##/##/####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtDataConsulta = new JFormattedTextField();
		txtDataConsulta.setColumns(6);
		txtDataConsulta.setBounds(20, 100, 96, 23);
		maskData.install(txtDataConsulta);
		contentPane.add(txtDataConsulta);

		JButton btnMarcarConsulta = new JButton("Gravar");
		btnMarcarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Tratamento tratamento = Controller.getTratamentoByIdTratamento(Integer.parseInt(txtIdTratamento.getText()));
				Veterinario veterinario = Controller.getVeterinarioByNome(txtNomeVeterinario.getText());
				Date dataConsulta = null;
				try {
					dataConsulta = new SimpleDateFormat("dd/MM/yyyy").parse(txtDataConsulta.getText());
				} catch (ParseException e1) {
				}
				
				int idConsulta = Controller.marcarConsulta(tratamento, dataConsulta, veterinario);
				
				if (idConsulta >= 1)
					JOptionPane.showMessageDialog(null, "Foi gerado uma consulta com o ID " + idConsulta + ". Utilize esse ID para marcar os exames.");

				setVisible(false);
				dispose();
			}
		});
		btnMarcarConsulta.setBounds(363, 220, 96, 21);
		contentPane.add(btnMarcarConsulta);

		JLabel lblDataConsulta = new JLabel("Data da Consulta");
		lblDataConsulta.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblDataConsulta.setBounds(20, 86, 96, 13);
		contentPane.add(lblDataConsulta);

		txtNomeVeterinario = new JTextField();
		txtNomeVeterinario.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtNomeVeterinario.setColumns(10);
		txtNomeVeterinario.setBounds(20, 144, 96, 22);
		contentPane.add(txtNomeVeterinario);

		JLabel lblNomeVeterinario = new JLabel("Nome Veterin\u00E1rio");
		lblNomeVeterinario.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNomeVeterinario.setBounds(20, 128, 96, 13);
		contentPane.add(lblNomeVeterinario);
		
		txtIdTratamento = new JTextField();
		txtIdTratamento.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtIdTratamento.setColumns(10);
		txtIdTratamento.setBounds(20, 58, 96, 22);
		contentPane.add(txtIdTratamento);
		
		JLabel lblIdTratamento = new JLabel("Id Tratamento");
		lblIdTratamento.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblIdTratamento.setBounds(20, 42, 96, 13);
		contentPane.add(lblIdTratamento);
	}
}
