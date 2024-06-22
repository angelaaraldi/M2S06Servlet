import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Pet;
import repositories.PetRepository;

public class PetServlet extends HttpServlet {
	@Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PetRepository.setUltimoId(PetRepository.getUltimoId()+1);
		Pet pet = new Pet(PetRepository.getUltimoId(), req.getParameter("nome"));
		PetRepository.getPets().add(pet);
		PrintWriter writer = resp.getWriter();
		writer.println(pet.getId() + " - " + pet.getNome());
	}
	@Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		for (Pet pet : PetRepository.getPets()) {
		writer.println(pet.getId() + " - " + pet.getNome());
		}
		if (PetRepository.getPets().isEmpty()) {
			writer.println("Não há pets cadastrados.");
		}
	}
	@Override protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		boolean petEncontrado = false;
		for (Pet pet : PetRepository.getPets()) {
			if (pet.getId() == Integer.parseInt(req.getParameter("id"))) {
				petEncontrado = true;
				pet.setNome(req.getParameter("nome"));
				writer.println(pet.getId() + " - " + pet.getNome());
				break;
			}
		}
		if (!petEncontrado) {
			writer.println("Pet não encontrado.");
		}
	}
	@Override protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		boolean petEncontrado = false;
		for (Pet pet : PetRepository.getPets()) {
			if (pet.getId() == Integer.parseInt(req.getParameter("id"))) {
				petEncontrado = true;
				PetRepository.getPets().remove(pet);
				writer.println(true);
				break;
			}
		}
		if (!petEncontrado) {
			writer.println(false);
		}
	}
}
