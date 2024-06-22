package repositories;

import java.util.ArrayList;
import java.util.List;

import models.Pet;

public class PetRepository {
	private static List<Pet> pets = new ArrayList<>();
	private static int ultimoId;
	
	public static List<Pet> getPets() {
		return pets;
	}

	public static void setPets(List<Pet> pets) {
		PetRepository.pets = pets;
	}

	public static int getUltimoId() {
		return ultimoId;
	}

	public static void setUltimoId(int ultimoId) {
		PetRepository.ultimoId = ultimoId;
	}
}
