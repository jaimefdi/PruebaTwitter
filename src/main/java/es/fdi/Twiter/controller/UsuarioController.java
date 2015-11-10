package es.fdi.Twiter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.fdi.Twiter.entity.Usuario;
import es.fdi.Twiter.service.UserService;

@Controller
public class UsuarioController {

	@Autowired
	private UserService usuarios;
	
	public UsuarioController(){
		super();
	}
	
	@RequestMapping(value="/login")
	public String muestraUsuarios(Usuario u){
		return "registrarse";
	}
	
	@RequestMapping(value="/login",params="login")
	public ModelAndView loguearse(Usuario u){
		
		
    	if(usuarios.getUsuario(u)){
    		Usuario user = usuarios.dameUsuario(u);
    		user.setLog(true);
    	    return new ModelAndView("welcome","userlogin", user);	
    	}
    	else
    	    return new ModelAndView("login","error", "Usuario/contraseña incorrectos");
	}
	
	
	@RequestMapping(value="/registrarse", params={"registrar"})
	public ModelAndView registro(Usuario u){
		
		ModelAndView modelo = new ModelAndView("registrarse");
		
		if (usuarios.anyadeUsuario(u)){
			modelo.addObject("exito", "Usuario registrado correctamente" );
		}
		else 
			modelo.addObject("error", "Usuario no registrado" );

		return modelo;
		
	}
}
