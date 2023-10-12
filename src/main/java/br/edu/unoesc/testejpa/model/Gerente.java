package br.edu.unoesc.testejpa.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "gerentes")
public class Gerente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	private Departamento departamento;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Gerente(Integer id, String nome, Departamento departamento) {
		this.id = id;
		this.nome = nome;
		this.departamento = departamento;
	}
	
	public Gerente( String nome, Departamento departamento) {
		this.nome = nome;
		this.departamento = departamento;
	}
	public Gerente() {
		
	}
	
	

	

}