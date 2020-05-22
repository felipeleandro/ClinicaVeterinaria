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

	public void addAnimal(String nomeAnimal, int idadeAnimal, int sexoAnimal, Especie especie, int id) {
		Animal animal = new Animal(nomeAnimal, idadeAnimal, sexoAnimal, especie,id);
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
	
    public Animal getAnimalByNome(String nomeAnimal) {
        for (Animal animal : animais) {
            if (animal.getNomeAnimal() == nomeAnimal) {
                return animal;
            }
        }
        return null;
    }

    // Updade
    public void updateAnimal(Animal animal, String nomeAnimal, int idadeAnimal, int sexoAnimal, Especie especie, int id) {
        int pos = animais.indexOf(animal);

        if (pos > 0) {
            animal.setNomeAnimal(nomeAnimal);
            animal.setIdadeAnimal(idadeAnimal);
            animal.setSexoAnimal(sexoAnimal);
            animal.setEspecie(especie);

            animais.set(pos, animal);
        }
    }

    // Delete
    public void deleteAnimal(Animal animal) {
        animais.remove(animal);
    }
}
