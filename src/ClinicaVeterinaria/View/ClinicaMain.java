package ClinicaVeterinaria.View;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.util.List;

import ClinicaVeterinaria.Controller.Controller;
import ClinicaVeterinaria.Models.*;

public class ClinicaMain implements Observer {

    public void update(Observable o, Object arg) {
        System.out.println("Dados Atualizados!");
        System.out.println(arg);
    }

    public void ListaAnimal() {
        List animais = Controller.getAllAnimais();
        for (Object animal : animais) {
            System.out.println(animal);
        }
    }

    public void Menu() {
        Scanner in = new Scanner(System.in);
        Controller.setObserverAnimal(this);
        Controller.setObserverCliente(this);
        int escolha = 1;

        while (escolha != 0) {
            System.out.println("Bem Vindo a clinica como posso ajudar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Inserir Cliente");
            System.out.println("2 - Inserir Animal");
            System.out.println("3 - Listar animais pelo ID");
            escolha = in.nextInt();

            switch (escolha) {
                case 0:
                    return;

                case 1:
                    Controller.addCliente("Cli1", "endereco", "(11)1111-1111", "11111-000", "teste@email.com" );
                    break;
                case 2:
                    Especie especie = new Especie();
                    especie.setNomEsp("gato");
                    Controller.addAnimal(1,"Nome",2,1, especie);
                    break;
                case 3:
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Digite um ID: ");
                    int idCliente = sc.nextInt();

                    List animais = Controller.getAnimalByIdCliente(idCliente);

                    for (Object animal : animais) {
                        System.out.println(animal);
                    }

                    sc.close();
                    break;
                case 4:

                    break;
            }

        }
        in.close();
    }

    public static void main(String[] args) {
        new ClinicaMain().Menu();
    }

}
