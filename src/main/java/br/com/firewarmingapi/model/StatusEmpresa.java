package br.com.firewarmingapi.model;

public class StatusEmpresa {

	private NivelPerigo nivelPerigo;
	private String comentario;
	private String status;
	
	
	
	public NivelPerigo getNivelPerigo() {
		return nivelPerigo;
	}
	public void setNivelPerigo(NivelPerigo nivelPerigo) {
		this.nivelPerigo = nivelPerigo;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
	
}
