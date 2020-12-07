package br.com.firewarning.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	private String cnpj;
	
	private String fantasia;
	
	private String contato;
	
	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
	@JsonBackReference
	private Set<Incidente> incidentes = new HashSet<>();
	


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	


	public String getContato() {
		return contato;
	}


	public void setContato(String contato) {
		this.contato = contato;
	}


	


	public String getFantasia() {
		return fantasia;
	}


	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}


	@Override
	public String toString() {
		return "Empresa [id=" + id + ", cnpj=" + cnpj + ", fantasia=" + fantasia + ", contato=" + contato
				+ ", incidentes=" + incidentes + "]";
	}

	
	

	


	
	
}
