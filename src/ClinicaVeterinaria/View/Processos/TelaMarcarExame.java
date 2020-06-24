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

public class TelaMarcarExame extends JFrame {

	private JPanel contentPane;
	private JTextField txtDescricaoExame;
	public JTextField txtIdConsulta;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMarcarExame frame = new TelaMarcarExame();
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
	public TelaMarcarExame() {
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

		JButton btnMarcarExame = new JButton("Gravar");
		btnMarcarExame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Consulta consulta = Controller.getConsultaByIdConsulta(Integer.parseInt(txtIdConsulta.getText()));
				String descricaoExame = txtDescricaoExame.getText();
				
				Controller.marcarExame(consulta, descricaoExame);
				
				JOptionPane.showMessageDialog(null, "Exame marcado com sucesso.");

				setVisible(false);
				dispose();
			}
		});
		btnMarcarExame.setBounds(363, 220, 96, 21);
		contentPane.add(btnMarcarExame);

		txtDescricaoExame = new JTextField();
		txtDescricaoExame.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtDescricaoExame.setColumns(10);
		txtDescricaoExame.setBounds(20, 106, 96, 22);
		contentPane.add(txtDescricaoExame);

		JLabel lblDescricaoExame = new JLabel("Descri\u00E7\u00E3o Exame");
		lblDescricaoExame.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblDescricaoExame.setBounds(20, 90, 96, 13);
		contentPane.add(lblDescricaoExame);
		
		txtIdConsulta = new JTextField();
		txtIdConsulta.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtIdConsulta.setColumns(10);
		txtIdConsulta.setBounds(20, 58, 96, 22);
		contentPane.add(txtIdConsulta);
		
		JLabel lblIdConsulta = new JLabel("Id Consulta");
		lblIdConsulta.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblIdConsulta.setBounds(20, 42, 96, 13);
		contentPane.add(lblIdConsulta);
	}
}
