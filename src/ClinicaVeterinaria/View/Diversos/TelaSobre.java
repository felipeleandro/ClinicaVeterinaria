package ClinicaVeterinaria.View.Diversos;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaSobre extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSobre frame = new TelaSobre();
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
	public TelaSobre() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Grupo Balacobaco");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(26, 10, 200, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(TelaSobre.class.getResource("/logoFT.png")));
		lblNewLabel_1.setBounds(419, 10, 207, 178);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Felipe Vedoveto");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(26, 56, 143, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Guilherme Cesila");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(26, 79, 137, 13);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Pedro Augusto");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(26, 102, 143, 13);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Alexandre Hausmann");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(26, 125, 143, 13);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Isabela Batarce");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_4.setBounds(26, 148, 137, 13);
		contentPane.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("Juan Costa");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_5.setBounds(26, 171, 137, 13);
		contentPane.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("Jean Marcos");
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_6.setBounds(26, 194, 143, 13);
		contentPane.add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_2_7 = new JLabel("Gilberto da Silva");
		lblNewLabel_2_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_7.setBounds(26, 217, 143, 13);
		contentPane.add(lblNewLabel_2_7);
		
		JLabel lblNewLabel_2_7_1 = new JLabel("Samantha Beatriz");
		lblNewLabel_2_7_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_7_1.setBounds(26, 240, 143, 13);
		contentPane.add(lblNewLabel_2_7_1);
		
		JLabel lblNewLabel_3 = new JLabel("RA: 196866");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(217, 56, 84, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("RA: 217116");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(217, 81, 84, 13);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("RA: 223216");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(217, 104, 84, 13);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("RA: 256601");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_3.setBounds(217, 127, 84, 13);
		contentPane.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("RA: 236862");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_4.setBounds(217, 150, 84, 13);
		contentPane.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_6 = new JLabel("RA: 175710");
		lblNewLabel_3_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_6.setBounds(217, 196, 84, 13);
		contentPane.add(lblNewLabel_3_6);
		
		JLabel lblNewLabel_3_7 = new JLabel("RA: 173050");
		lblNewLabel_3_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_7.setBounds(217, 219, 84, 13);
		contentPane.add(lblNewLabel_3_7);
		
		JLabel lblNewLabel_3_8 = new JLabel("RA: 244151");
		lblNewLabel_3_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_8.setBounds(217, 242, 84, 13);
		contentPane.add(lblNewLabel_3_8);
		
		JLabel lblNewLabel_3_5 = new JLabel("RA: 219146");
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_5.setBounds(217, 173, 84, 13);
		contentPane.add(lblNewLabel_3_5);
		
		JLabel lblNewLabel_4 = new JLabel("Disciplina de Programa\u00E7\u00E3o Orientada a Objetos - Professores: Plinio Vilela/Ulisses Martins");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(26, 288, 590, 20);
		contentPane.add(lblNewLabel_4);
	}
}
