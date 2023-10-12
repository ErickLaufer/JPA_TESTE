package br.edu.unoesc.testejpa.app;

import java.math.BigDecimal;

import br.edu.unoesc.testejpa.model.Pessoa;
import br.edu.unoesc.testejpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class App1 {
	private static EntityManager em;

	private void adicionar() {
		Pessoa p1 = new Pessoa("Otilia", java.sql.Date.valueOf("2000-04-01"), new BigDecimal("10000.0"));
		Pessoa p2 = new Pessoa("Maria", java.sql.Date.valueOf("2001-05-02"), new BigDecimal("20000.0"));
		// inicia a transação, persiste os objetos e faz commit
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.getTransaction().commit();
	}

	public static void main(String[] args) {
		App1 app = new App1();
		em = JPAUtil.getEntityManager();
		app.adicionar();
		em.close();
		JPAUtil.closeEntityManagerFactory();
	}
}
