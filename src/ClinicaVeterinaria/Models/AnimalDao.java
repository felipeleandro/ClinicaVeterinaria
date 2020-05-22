package ClinicaVeterinaria.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import model.Cliente;
import model.ClienteDAO;
import model.Especie;
import model.Sexo;

public class AnimalDao extends Observable {
	private static AnimalDao instance;
	private List<Animal> animais;
	private int id;

	private AnimalDao() {
		animais = new ArrayList();
		id = 0;
	}

	public static AnimalDao getInstance() {
		if (instance == null) {
			instance = new AnimalDao();
		}
		return instance;
	}

	public void addAnimal(String nome, int anoNasc, int sexo,int id) {
		Animal animal = new Animal(nome, anoNasc, sexo, id);
		id++;
		animais.add(animal);
		setChanged();
		notifyObservers(animal);
	}

	public List getAllAnimais() {
		return animais;
	}

	public Animal getAnimalById(int id) {
		for (Animal animal : animais) {
			if (animal.getId() == id) {
				return animal;
			}
		}
		return null;
	}
}
