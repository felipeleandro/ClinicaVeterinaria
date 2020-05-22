package ClinicaVeterinaria.View;

import java.util.Scanner;
import java.util.List;
import ClinicaVeterinaria.Controller.Controller;
import ClinicaVeterinaria.Models.*;
import java.util.Observable;
import java.util.Observer;

public class ClinicaMain {
	
	
	 public void ListaClientes(){
	        List clientes = ClinicaVeterinaria.Controller.getAllClientes();
	        for (Object cliente : clientes){
	            System.out.println(cliente);
	        }
	    }
	 public void ListaAnimal(){
	        List clientes = ClinicaVeterinaria.Controller.getAllAnimais();
	        for ( Animal animal : animal){
	            System.out.println(animal);
	        }
	    }
	

	public void Menu() {
		Scanner in = new Scanner(System.in);
		int escolha = 1;
		
		while (escolha != 0) {
			System.out.println("Bem Vindo a clinica como posso ajudar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Listar Clientes");
			System.out.println("2 - Inserir Cliente");
			System.out.println("3 - Listar Animal");
			System.out.println("4 - Inserir Animal");
			escolha = in.nextInt();
			
			switch(escolha) {
				case 0:
					return;
				
				case 1:
					ListaClientes();
					break;
				case 2:
					Controller.addCliente("Cli1","endereco","(11)1111-1111","11111-000");
					break;
				case 3:
					ListaAnimal();
					break;
				case 4:
					Controller.addAnimal("bixano","2","0",/*especie*/,/*tratamento*/);
					break;
			}
			
		}
		in.close();
	}
	public static void main(String[] args) {
		new ClinicaMain().Menu();
		
	}

}
