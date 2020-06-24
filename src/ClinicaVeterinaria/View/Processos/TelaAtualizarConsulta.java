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
import ClinicaVeterinaria.Models.Models.Veterinario;

public class TelaAtualizarConsulta extends JFrame {

	private JPanel contentPane;
	public JFormattedTextField txtDataConsulta;
	public JTextField txtIdConsulta;
	public JTextField txtNomeVeterinario;
	public JTextField txtHistoricoConsulta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarConsulta frame = new TelaAtualizarConsulta();
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
	public TelaAtualizarConsulta() {
		setTitle("Atualizar Consulta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 483, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Atualizar Consulta");
		lblTitulo.setBounds(187, 10, 204, 13);
		contentPane.add(lblTitulo);

		JButton btnGravarTratamento = new JButton("Gravar");
		btnGravarTratamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int idConsulta = Integer.parseInt(txtIdConsulta.getText());
				Date dataConsulta = null;
				try {
					dataConsulta = new SimpleDateFormat("dd/MM/yyyy").parse(txtDataConsulta.getText());
				} catch (ParseException e1) {
				}
				
				String historicoConsulta = txtHistoricoConsulta.getText();
				
				Controller.updateConsulta(idConsulta, dataConsulta, historicoConsulta);
				
				setVisible(false);
				dispose();
			}
		});
		btnGravarTratamento.setBounds(363, 220, 96, 21);
		contentPane.add(btnGravarTratamento);

		MaskFormatter maskData = null;
		try {
			maskData = new MaskFormatter("##/##/####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		txtIdConsulta = new JTextField();
		txtIdConsulta.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtIdConsulta.setColumns(10);
		txtIdConsulta.setBounds(10, 45, 96, 22);
		contentPane.add(txtIdConsulta);
		
		JLabel lblIdConsulta = new JLabel("Id Consulta");
		lblIdConsulta.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblIdConsulta.setBounds(10, 29, 96, 13);
		contentPane.add(lblIdConsulta);
		
		txtDataConsulta = new JFormattedTextField();
		txtDataConsulta.setColumns(6);
		txtDataConsulta.setBounds(10, 92, 96, 23);
		maskData.install(txtDataConsulta);
		contentPane.add(txtDataConsulta);
		
		JLabel lblDataConsulta = new JLabel("Data Consulta");
		lblDataConsulta.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblDataConsulta.setBounds(10, 77, 96, 13);
		contentPane.add(lblDataConsulta);
		
		txtNomeVeterinario = new JTextField();
		txtNomeVeterinario.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtNomeVeterinario.setColumns(10);
		txtNomeVeterinario.setBounds(10, 141, 96, 22);
		contentPane.add(txtNomeVeterinario);
		
		JLabel lblNomeVeterinario = new JLabel("Nome Veterin\u00E1rio");
		lblNomeVeterinario.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNomeVeterinario.setBounds(10, 125, 96, 13);
		contentPane.add(lblNomeVeterinario);
		
		txtHistoricoConsulta = new JTextField();
		txtHistoricoConsulta.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtHistoricoConsulta.setColumns(10);
		txtHistoricoConsulta.setBounds(10, 189, 449, 22);
		contentPane.add(txtHistoricoConsulta);
		
		JLabel lblHistoricoConsulta = new JLabel("Hist\u00F3rico Consulta");
		lblHistoricoConsulta.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblHistoricoConsulta.setBounds(10, 173, 96, 13);
		contentPane.add(lblHistoricoConsulta);
	}
}
