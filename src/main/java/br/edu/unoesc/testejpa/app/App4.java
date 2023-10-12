package br.edu.unoesc.testejpa.app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.edu.unoesc.testejpa.dao.DaoDepartamento;
import br.edu.unoesc.testejpa.dao.DaoPessoa;
import br.edu.unoesc.testejpa.model.Departamento;
import br.edu.unoesc.testejpa.model.Pessoa;

public class App4 {
	public static void main(String[] args) {
		DaoDepartamento daoDepartamento = new DaoDepartamento();
		DaoPessoa daoPessoa = new DaoPessoa();
		Departamento departamento = new Departamento(null, "Marketing");
		Pessoa pessoa = new Pessoa("Elisa", java.sql.Date.valueOf(LocalDate.now()), new BigDecimal("12000"),
				departamento);
		System.out.println(daoDepartamento.salvar(departamento).obterTodos());
		daoDepartamento.fechar();
		daoPessoa.salvar(pessoa);
		// atenção - precisa ter o construtor padrão para Pessoa
		List<Pessoa> pessoas = daoPessoa.obterTodos();
		for (Pessoa p : pessoas) {
			System.out.println(p.getNome() + " - " + p.getDepartamento().getNome());
		}
		daoPessoa.fechar();
	}
}