package es.fdi.Twiter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fdi.Twiter.entity.Usuario;
import es.fdi.Twiter.entity.repos.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public UserService(){
		super();
		
	}
	
	public List<Usuario> getLista(){
		return userRepo.getLista();
	}
	
	public boolean getUsuario(Usuario u){
		return userRepo.existeUsuario(u);
	}
	
	public boolean anyadeUsuario(Usuario u){
		return userRepo.anyadeUsuario(u);
	}

	public Usuario dameUsuario(Usuario u){
		return userRepo.dameUsuario(u);
	}
	
	public Usuario dameUsuarioLogueado() {
		// TODO Auto-generated method stub
		return null;
	}
}
