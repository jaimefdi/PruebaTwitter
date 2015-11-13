package es.fdi.Twiter.entity.repos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import es.fdi.Twiter.entity.Usuario;

@Repository
public class UserRepo {

	List<Usuario> listaUsu = new ArrayList<Usuario>();
	
	public UserRepo(){
		super();
		
	}
	
	public List<Usuario> getLista(){
		return new ArrayList<Usuario>(listaUsu);
	}
	
	public Usuario dameUsuario(Usuario u){
		Usuario user = null;
		boolean encontrado = false;
		int i=0;
		
		while(!encontrado && (i < listaUsu.size()) ){
			if(u.getNombre().equals(listaUsu.get(i).getNombre()) 
					&& u.getPassword().equals(listaUsu.get(i).getPassword())){
				encontrado = true;
				user = listaUsu.get(i);
			}
			i++;
		}
		
		
		return user;
	}
	
	public void anyadeUsuario(Usuario u){
		//Antes de añadir un usuario, hay que comprobar que no existe
		
			listaUsu.add(u);
		
	}

	public boolean existeUsuario(Usuario u) {
		int id = u.getIdentificador();
		int i=0;
		while (i < listaUsu.size()){
			if (listaUsu.get(i).getIdentificador() == id){
				return true;
			}
			i++;
		}
		return false;
	}

	public Usuario dameUsuarioLogueado() {
		for (int i=0;i<listaUsu.size();i++){
			if (listaUsu.get(i).isLog()){
				return listaUsu.get(i);
			}
		}
		
		return null;
	}
}
