package br.edu.unoesc.testejpa.app;

import java.math.BigDecimal;

import br.edu.unoesc.testejpa.model.Departamento;
import br.edu.unoesc.testejpa.model.Pessoa;
import br.edu.unoesc.testejpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class App3 {
	private static EntityManager em;

	public static void main(String[] args) {
		em = JPAUtil.getEntityManager();
		Departamento d1 = new Departamento("Desenvolvimento");
		Departamento d2 = new Departamento("Testes");
		Pessoa p1 = new Pessoa("Maria", java.sql.Date.valueOf("2000-04-01"), new BigDecimal("10000.0"), d1);
		Pessoa p2 = new Pessoa("Antônio", java.sql.Date.valueOf("2001-05-02"), new BigDecimal("20000.0"), d2);
		Pessoa p3 = new Pessoa("Osvaldo", java.sql.Date.valueOf("2001-05-10"), new BigDecimal("10000.0"), d1);
		em.getTransaction().begin();
		em.persist(d1);
		em.persist(d2);
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		em.close();
		JPAUtil.closeEntityManagerFactory();
	}
}
