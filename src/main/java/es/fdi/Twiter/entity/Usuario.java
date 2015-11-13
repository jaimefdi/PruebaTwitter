package es.fdi.Twiter.entity;

public class Usuario {

	private int identificador;
	private String nombre;
	private String email;
	private String password;
	private boolean log;
	
	public Usuario(){}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLog() {
		return log;
	}

	public void setLog(boolean log) {
		this.log = log;
	}

	public boolean emailCorrecto() {
		if (this.email.contains("@")){
			String[] mail = this.email.split("@");
			if ((mail[0].length() > 0) && (mail[1].length() > 0) && (mail[1].contains("."))) {
				return true;
			}else return false;
		}else 
			return false;
	}

	public boolean nombreCorrecto() {
		if (this.nombre.length() > 0){
			return true;
		}
		return false;
	}

	public boolean passwordCorrecta() {
		if (this.password.length() > 0){
			return true;
		}
		return false;
	}
	
	
	
}
