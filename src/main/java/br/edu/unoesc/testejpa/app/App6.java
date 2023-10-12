package br.edu.unoesc.testejpa.app;

import java.util.List;

import br.edu.unoesc.testejpa.model.Departamento;
import br.edu.unoesc.testejpa.model.Gerente;
import br.edu.unoesc.testejpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class App6 {
	private static EntityManager em;

	public static void main(String[] args) {
		em = JPAUtil.getEntityManager();
		Departamento departamento1 = new Departamento(null, "Marketing", null);
		Departamento departamento2 = new Departamento(null, "RH", null);
		Gerente gerente1 = new Gerente("Marisa", departamento1);
		Gerente gerente2 = new Gerente("Bernardo", departamento2);
		departamento1.setGerente(gerente1);
		departamento2.setGerente(gerente2);
		em.getTransaction().begin();
		em.persist(gerente1);
		em.persist(gerente2);
		em.getTransaction().commit();
		String jpql = "SELECT g FROM Gerente g";
		List<Gerente> gerentes = em.createQuery(jpql, Gerente.class).getResultList();
		for (Gerente g : gerentes) {
			System.out.println(g.getNome() + " - " + g.getDepartamento().getNome());
		}
		jpql = "SELECT d FROM Departamento d";
		List<Departamento> departamentos = em.createQuery(jpql, Departamento.class).getResultList();
		for (Departamento d : departamentos) {
			System.out.println(d.getNome() + " - " + d.getGerente().getNome());
		}
		em.close();
		JPAUtil.closeEntityManagerFactory();
	}
}
