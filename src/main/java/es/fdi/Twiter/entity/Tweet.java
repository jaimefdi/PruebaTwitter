package es.fdi.Twiter.entity;

import java.util.Date;

public class Tweet {
	private Integer identificador = null;
	private String texto = null;
	private Date fecha = null;
	private Usuario usuario = null;
	
	public Tweet(){
		super();
	}
	
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario u) {
		this.usuario = u;
	}
	
	
}
