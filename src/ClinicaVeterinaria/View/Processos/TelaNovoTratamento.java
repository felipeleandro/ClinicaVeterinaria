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

public class TelaNovoTratamento extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeAnimal;
	private JFormattedTextField txtDataInicial;
	private JFormattedTextField txtDataFinal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaNovoTratamento frame = new TelaNovoTratamento();
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
	public TelaNovoTratamento() {
		setTitle("Novo Tratamento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 483, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Novo Tratamento");
		lblTitulo.setBounds(187, 10, 96, 13);
		contentPane.add(lblTitulo);
		
		JLabel lblDataInicial = new JLabel("Data Inicial");
		lblDataInicial.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblDataInicial.setBounds(10, 83, 83, 13);
		contentPane.add(lblDataInicial);

		JButton btnGravarTratamento = new JButton("Gravar");
		btnGravarTratamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Animal animal = Controller.getAnimalByNomeAnimal(txtNomeAnimal.getText());
				Date dataInicial = null;
				Date dataFinal = null;
				try {
					dataInicial = new SimpleDateFormat("dd/MM/yyyy").parse(txtDataInicial.getText());
					dataFinal = new SimpleDateFormat("dd/MM/yyyy").parse(txtDataFinal.getText());
				} catch (ParseException e1) {
				}
				
				int idTratamento = Controller.addTratamento(dataInicial, dataFinal, animal);
				
				if (idTratamento >= 1)
					JOptionPane.showMessageDialog(null, "Foi gerado um tratamento com o ID " + idTratamento + ". Utilize esse ID para marcar as consultas.");

				setVisible(false);
				dispose();
			}
		});
		btnGravarTratamento.setBounds(363, 220, 96, 21);
		contentPane.add(btnGravarTratamento);
		
		txtNomeAnimal = new JTextField();
		txtNomeAnimal.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtNomeAnimal.setColumns(10);
		txtNomeAnimal.setBounds(10, 55, 96, 22);
		contentPane.add(txtNomeAnimal);
		
		JLabel lblNomeAnimal = new JLabel("Nome Animal");
		lblNomeAnimal.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNomeAnimal.setBounds(10, 39, 96, 13);
		contentPane.add(lblNomeAnimal);

		MaskFormatter maskData = null;
		MaskFormatter maskData1 = null;
		try {
			maskData = new MaskFormatter("##/##/####");
			maskData1 = new MaskFormatter("##/##/####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		txtDataFinal = new JFormattedTextField();
		txtDataFinal.setColumns(6);
		txtDataFinal.setBounds(10, 140, 96, 23);
		maskData1.install(txtDataFinal);
		contentPane.add(txtDataFinal);
		
		JLabel lblDataFinal = new JLabel("Data Final");
		lblDataFinal.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblDataFinal.setBounds(10, 125, 96, 13);
		contentPane.add(lblDataFinal);
		
		txtDataInicial = new JFormattedTextField();
		txtDataInicial.setColumns(6);
		txtDataInicial.setBounds(10, 98, 96, 23);
		maskData.install(txtDataInicial);
		contentPane.add(txtDataInicial);
	}
}
