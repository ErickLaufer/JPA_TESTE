package br.edu.unoesc.testejpa.dao;

import java.util.List;

import br.edu.unoesc.testejpa.model.Pessoa;
import br.edu.unoesc.testejpa.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class DaoPessoa {
	private EntityManager em;

	public DaoPessoa() {
		em = JPAUtil.getEntityManager();
	}

// métodos privados
	private DaoPessoa abrirTransacao() {
		em.getTransaction().begin();
		return this;
	}

	private DaoPessoa fecharTransacao() {
		em.getTransaction().commit();
		return this;
	}

	private DaoPessoa incluir(Pessoa p) {
		em.persist(p);
		return this;
	}

	private DaoPessoa remover(Pessoa p) {
		em.remove(p);
		return this;
	}

// métodos públicos
	public DaoPessoa salvar(Pessoa p) {
		return this.abrirTransacao().incluir(p).fecharTransacao();
	}

	public DaoPessoa excluir(Pessoa p) {
		return this.abrirTransacao().remover(p).fecharTransacao();
	}

	public List<Pessoa> obterTodos() {
		String jpql = "SELECT p FROM Pessoa p";
		return em.createQuery(jpql, Pessoa.class).getResultList();
	}

	public Pessoa buscarPorId(Integer id) {
		return em.find(Pessoa.class, id);
	}

	public List<Pessoa> buscarPorNome(String nome) {
		String jpql = "SELECT p FROM Pessoa p WHERE p.nome LIKE :nome";
		TypedQuery<Pessoa> consulta = em.createQuery(jpql, Pessoa.class);
		consulta.setParameter("nome", "%" + nome + "%");
		return consulta.getResultList();
	}

	public void fechar() {
		em.close();
	}
}