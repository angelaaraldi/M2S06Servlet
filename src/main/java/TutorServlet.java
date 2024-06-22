import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Tutor;
import repositories.TutorRepository;

public class TutorServlet extends HttpServlet {
	@Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TutorRepository.setUltimoId(TutorRepository.getUltimoId()+1);
		Tutor tutor = new Tutor(TutorRepository.getUltimoId(), req.getParameter("nome"));
		TutorRepository.getTutores().add(tutor);
		PrintWriter writer = resp.getWriter();
		writer.println(tutor.getId() + " - " + tutor.getNome());
	}
	@Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		for (Tutor tutor : TutorRepository.getTutores()) {
		writer.println(tutor.getId() + " - " + tutor.getNome());
		}
		if (TutorRepository.getTutores().isEmpty()) {
			writer.println("Não há tutores cadastrados.");
		}
	}
	@Override protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		boolean tutorEncontrado = false;
		for (Tutor tutor : TutorRepository.getTutores()) {
			if (tutor.getId() == Integer.parseInt(req.getParameter("id"))) {
				tutorEncontrado = true;
				tutor.setNome(req.getParameter("nome"));
				writer.println(tutor.getId() + " - " + tutor.getNome());
				break;
			}
		}
		if (!tutorEncontrado) {
			writer.println("Tutor não encontrado.");
		}
	}
	@Override protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		boolean tutorEncontrado = false;
		for (Tutor tutor : TutorRepository.getTutores()) {
			if (tutor.getId() == Integer.parseInt(req.getParameter("id"))) {
				tutorEncontrado = true;
				TutorRepository.getTutores().remove(tutor);
				writer.println(true);
				break;
			}
		}
		if (!tutorEncontrado) {
			writer.println(false);
		}
	}
}
