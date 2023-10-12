package br.edu.unoesc.testejpa.app;

import br.edu.unoesc.testejpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class App {
	private static EntityManager em;

	public static void main(String[] args) {
		App app = new App();
		em = JPAUtil.getEntityManager();
		em.close();
		JPAUtil.closeEntityManagerFactory();
		
	}
}