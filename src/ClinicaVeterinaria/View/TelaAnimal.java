package ClinicaVeterinaria.View;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import ClinicaVeterinaria.Models.Animal;
import ClinicaVeterinaria.Models.AnimalDAO;
import ClinicaVeterinaria.Models.Especie;
import ClinicaVeterinaria.View.*;

@SuppressWarnings("serial")
public class TelaAnimal extends javax.swing.JFrame {

	private JPanel jPane1;
	private JTable table;



	/**
	 * Create the frame.
	 */
	public TelaAnimal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 350);
		jPane1 = new JPanel();
		jPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jPane1);
		jPane1.setLayout(null);
		
		JLabel jLabel = new JLabel();
		jLabel.setText("Lista de Animais");
		jLabel.setBounds(201, 23, 111, 14);
		jPane1.add(jLabel);
		
		JButton jButton1 = new JButton();
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jButton1.setText("Novo Animal");
		jButton1.setBounds(10, 42, 111, 23);
		jPane1.add(jButton1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 91, 485, 194);
		jPane1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new AnimalTableModel((ArrayList<Animal>) AnimalDAO.getInstance().getAllAnimais()));
		scrollPane.setViewportView(table);
	}
	
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		Especie especie = new Especie();
		especie.setNomEsp("gato");
		//Erro no id do cliente, ele dá a seguinte msg quando tem um int no id
		//Detalhe: Key (idcliente)=(0) is not present in table "clientes".
		// ja tentei deixar idCliente como null mas continua dando erro
		int newId = AnimalDAO.getInstance().addAnimal("anim1", 1, 1, especie, 0);
		
		if (newId >= 0) {
			Animal animal = new Animal();
			
			GenericTableModel tb = (GenericTableModel) table.getModel();
			
			tb.addItem(animal);
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				TelaAnimal frame = new TelaAnimal();
				frame.setVisible(true);
			}
		});
	}
}
