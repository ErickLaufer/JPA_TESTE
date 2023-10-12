package br.edu.unoesc.testejpa.dao;

import java.util.List;
import br.edu.unoesc.testejpa.model.Departamento;
import br.edu.unoesc.testejpa.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class DaoDepartamento {
	private EntityManager em;

	public DaoDepartamento() {
		em = JPAUtil.getEntityManager();
	}

// métodos privados
	private DaoDepartamento abrirTransacao() {
		em.getTransaction().begin();
		return this;
	}

	private DaoDepartamento fecharTransacao() {
		em.getTransaction().commit();
		return this;
	}

	private DaoDepartamento incluir(Departamento d) {
		em.persist(d);
		return this;
	}

	private DaoDepartamento remover(Departamento d) {
		em.remove(d);
		return this;
	}

// métodos públicos
	public DaoDepartamento salvar(Departamento d) {
		return this.abrirTransacao().incluir(d).fecharTransacao();
	}

	public DaoDepartamento excluir(Departamento d) {
		return this.abrirTransacao().remover(d).fecharTransacao();
	}

	public List<Departamento> obterTodos() {
		String jpql = "SELECT d FROM Departamento d";
		return em.createQuery(jpql, Departamento.class).getResultList();
	}

	public Departamento buscarPorId(Integer id) {
		return em.find(Departamento.class, id);
	}

	public List<Departamento> buscarPorNome(String nome) {
		String jpql = "SELECT d FROM Departamento d WHERE d.nome LIKE :nome";
		TypedQuery<Departamento> consulta = em.createQuery(jpql, Departamento.class);
		consulta.setParameter("nome", "%" + nome + "%");
		return consulta.getResultList();
	}

	public void fechar() {
		em.close();
	}
}
