package ClinicaVeterinaria.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class AnimalDAO extends Observable {
	private static AnimalDAO instance;
	private List<Animal> animais;
	private int id;

	private AnimalDAO() {
		animais = new ArrayList();
		id = 0;
	}

	public static AnimalDAO getInstance() {
		if (instance == null) {
			instance = new AnimalDAO();
		}
		return instance;
	}

	public void addAnimal(String nome, int anoNasc, int sexo, Especie especie, int id) {
		Animal animal = new Animal(nome, anoNasc, sexo, especie, id);
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
