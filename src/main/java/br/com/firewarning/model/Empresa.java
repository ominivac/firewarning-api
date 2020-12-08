package br.com.firewarning.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	private String cnpj;

	@NotNull
	private String fantasia;
	
	@NotNull
	private String contato;
	
	@NotNull
	private String nivel;



	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
	private Set<Incidente> incidentes = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	

	public Set<Incidente> getIncidentes() {
		return incidentes;
	}

	public void setIncidente(Set<Incidente> incidentes) {
		this.incidentes = incidentes;

		for (Incidente i : incidentes) {
			i.setEmpresa(this);
		}
	}
}
