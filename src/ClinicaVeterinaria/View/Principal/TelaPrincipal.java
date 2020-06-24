package ClinicaVeterinaria.View.Principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ClinicaVeterinaria.Models.Models.DB;
import ClinicaVeterinaria.View.Cadastros.TelaNovaEspecie;
import ClinicaVeterinaria.View.Cadastros.TelaNovoAnimal;
import ClinicaVeterinaria.View.Cadastros.TelaNovoCliente;
import ClinicaVeterinaria.View.Cadastros.TelaNovoVeterinario;
import ClinicaVeterinaria.View.Diversos.TelaSobre;
import ClinicaVeterinaria.View.Processos.TelaMarcarConsulta;
import ClinicaVeterinaria.View.Processos.TelaMarcarExame;
import ClinicaVeterinaria.View.Processos.TelaNovoTratamento;
import ClinicaVeterinaria.View.Relatorios.TelaAnimal;
import ClinicaVeterinaria.View.Relatorios.TelaCliente;
import ClinicaVeterinaria.View.Relatorios.TelaClienteAnimal;
import ClinicaVeterinaria.View.Relatorios.TelaConsulta;
import ClinicaVeterinaria.View.Relatorios.TelaEspecie;
import ClinicaVeterinaria.View.Relatorios.TelaExame;
import ClinicaVeterinaria.View.Relatorios.TelaTratamento;
import ClinicaVeterinaria.View.Relatorios.TelaVeterinario;

public class TelaPrincipal extends javax.swing.JFrame {
	/**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
		setTitle("Tela Principal");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mainMenuCadastros = new JMenu("Cadastros");
		menuBar.add(mainMenuCadastros);
		
		JMenuItem menuNovoCliente = new JMenuItem("Cliente");
		menuNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaNovoCliente obj = new TelaNovoCliente();
				obj.setVisible(true);
			}
		});
		mainMenuCadastros.add(menuNovoCliente);
		
		JMenuItem menuNovoAnimal = new JMenuItem("Animal");
		menuNovoAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaNovoAnimal obj = new TelaNovoAnimal();
				obj.setVisible(true);
			}
		});
		
		JMenuItem menuNovoVeterinario = new JMenuItem("Veterin\u00E1rio");
		menuNovoVeterinario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaNovoVeterinario obj = new TelaNovoVeterinario();
				obj.setVisible(true);
			}
		});
		mainMenuCadastros.add(menuNovoVeterinario);
		
		JMenuItem menuNovaEspecie = new JMenuItem("Esp\u00E9cie");
		menuNovaEspecie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaNovaEspecie obj = new TelaNovaEspecie();
				obj.setVisible(true);
			}
		});
		mainMenuCadastros.add(menuNovaEspecie);
		mainMenuCadastros.add(menuNovoAnimal);
		
		JMenu mainMenuProcessos = new JMenu("Processos");
		menuBar.add(mainMenuProcessos);
		
		JMenuItem menuNovoTratamento = new JMenuItem("Novo Tratamento");
		menuNovoTratamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaNovoTratamento obj = new TelaNovoTratamento();
				obj.setVisible(true);
			}
		});
		mainMenuProcessos.add(menuNovoTratamento);
		
		JMenuItem menuMarcarConsulta = new JMenuItem("Marcar Consulta");
		menuMarcarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMarcarConsulta obj = new TelaMarcarConsulta();
				obj.setVisible(true);
			}
		});
		mainMenuProcessos.add(menuMarcarConsulta);
		
		JMenuItem menuMarcarExame = new JMenuItem("Marcar Exame");
		menuMarcarExame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMarcarExame obj = new TelaMarcarExame();
				obj.setVisible(true);
			}
		});
		mainMenuProcessos.add(menuMarcarExame);
		
		JMenu mainMenuRelatorios = new JMenu("Relat\u00F3rios");
		menuBar.add(mainMenuRelatorios);
		
		JMenuItem menuRelatorioClientes = new JMenuItem("Lista de Clientes");
		menuRelatorioClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCliente obj = new TelaCliente();
				obj.setVisible(true);
			}
		});
		
		JMenu menuRelatoriosCadastros = new JMenu("Cadastros");
		mainMenuRelatorios.add(menuRelatoriosCadastros);
		menuRelatoriosCadastros.add(menuRelatorioClientes);
		
		JMenuItem menuRelatorioAnimais = new JMenuItem("Lista de Animais");
		menuRelatorioAnimais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAnimal obj = new TelaAnimal();
				obj.setVisible(true);
			}
		});
		
		JMenuItem menuRelatorioVeterinarios = new JMenuItem("Lista de Veterin\u00E1rios");
		menuRelatorioVeterinarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVeterinario obj = new TelaVeterinario();
				obj.setVisible(true);
			}
		});
		menuRelatoriosCadastros.add(menuRelatorioVeterinarios);
		
		JMenuItem menuRelatorioEspecies = new JMenuItem("Lista de Esp\u00E9cies");
		menuRelatorioEspecies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEspecie obj = new TelaEspecie();
				obj.setVisible(true);
			}
		});
		menuRelatoriosCadastros.add(menuRelatorioEspecies);
		menuRelatoriosCadastros.add(menuRelatorioAnimais);
		
		JMenuItem menuRelatorioClientesAnimais = new JMenuItem("Lista de Clientes x Animais");
		menuRelatorioClientesAnimais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaClienteAnimal obj = new TelaClienteAnimal();
				obj.setVisible(true);
			}
		});
		menuRelatoriosCadastros.add(menuRelatorioClientesAnimais);
		
		JMenuItem menuRelatorioTratamentos = new JMenuItem("Lista de Tratamentos");
		menuRelatorioTratamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTratamento obj = new TelaTratamento();
				obj.setVisible(true);
			}
		});
		
		JMenu mainMenuRelatoriosTratamento = new JMenu("Tratamentos");
		mainMenuRelatorios.add(mainMenuRelatoriosTratamento);
		mainMenuRelatoriosTratamento.add(menuRelatorioTratamentos);
		
		JMenuItem menuRelatorioConsultas = new JMenuItem("Lista de Consultas");
		menuRelatorioConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsulta obj = new TelaConsulta();
				obj.setVisible(true);
			}
		});
		mainMenuRelatoriosTratamento.add(menuRelatorioConsultas);
		
		JMenuItem menuRelatorioExames = new JMenuItem("Lista de Exames");
		menuRelatorioExames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaExame obj = new TelaExame();
				obj.setVisible(true);
			}
		});
		mainMenuRelatoriosTratamento.add(menuRelatorioExames);
		
		JMenu mainMenuSobre = new JMenu("Sobre");
		menuBar.add(mainMenuSobre);
		
		JMenuItem menuSobre = new JMenuItem("Sobre");
		menuSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSobre obj = new TelaSobre();				
				obj.setVisible(true);
			}
		});
		mainMenuSobre.add(menuSobre);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/background.png")));
		lblNewLabel.setBounds(10, 10, 565, 313);
		getContentPane().add(lblNewLabel);
		
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);        
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
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
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {            	
                TelaPrincipal obj = new TelaPrincipal();
                obj.setVisible(true);
                obj.setSize(500, 500);
                
                DB.getConnection();
                
                obj.addWindowListener(new WindowAdapter() {
        	        @Override
        	        public void windowClosed(WindowEvent e) {
        	        	DB.closeConnection();
        	        }

        	    });
                
            }
        });
    }
}
