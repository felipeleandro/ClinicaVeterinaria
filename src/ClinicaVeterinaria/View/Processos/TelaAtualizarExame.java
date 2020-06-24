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
import ClinicaVeterinaria.Models.Models.Consulta;
import ClinicaVeterinaria.Models.Models.Tratamento;
import ClinicaVeterinaria.Models.Models.Veterinario;

public class TelaAtualizarExame extends JFrame {

	private JPanel contentPane;
	public JTextField txtDescricaoExame;
	public JTextField txtIdExame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarExame frame = new TelaAtualizarExame();
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
	public TelaAtualizarExame() {
		setTitle("Marcar Exame");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 483, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Marcar Exame");
		lblTitulo.setBounds(187, 10, 96, 13);
		contentPane.add(lblTitulo);

		MaskFormatter maskData = null;
		try {
			maskData = new MaskFormatter("##/##/####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		JButton btnAtualizarExame = new JButton("Gravar");
		btnAtualizarExame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int idExame = Integer.parseInt(txtIdExame.getText());
				String descricaoExame = txtDescricaoExame.getText();
				
				Controller.updateExame(idExame, descricaoExame);

				setVisible(false);
				dispose();
			}
		});
		btnAtualizarExame.setBounds(363, 220, 96, 21);
		contentPane.add(btnAtualizarExame);

		txtDescricaoExame = new JTextField();
		txtDescricaoExame.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtDescricaoExame.setColumns(10);
		txtDescricaoExame.setBounds(10, 52, 96, 22);
		contentPane.add(txtDescricaoExame);

		JLabel lblDescricaoExame = new JLabel("Descri\u00E7\u00E3o Exame");
		lblDescricaoExame.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblDescricaoExame.setBounds(10, 36, 96, 13);
		contentPane.add(lblDescricaoExame);
		
		txtIdExame = new JTextField();
		txtIdExame.setBounds(279, 9000, 70, 19);
		contentPane.add(txtIdExame);
		txtIdExame.setColumns(10);
	}
}
