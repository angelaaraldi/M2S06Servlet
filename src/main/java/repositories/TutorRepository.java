package repositories;

import java.util.ArrayList;
import java.util.List;

import models.Tutor;

public class TutorRepository {
	private static List<Tutor> tutores = new ArrayList<>();
	private static int ultimoId;

	public static List<Tutor> getTutores() {
		return tutores;
	}

	public static void setTutores(List<Tutor> tutores) {
		TutorRepository.tutores = tutores;
	}

	public static int getUltimoId() {
		return ultimoId;
	}

	public static void setUltimoId(int ultimoId) {
		TutorRepository.ultimoId = ultimoId;
	}
}
