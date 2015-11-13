package es.fdi.Twiter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value="/registrarse")
	public String muestraUsuarios(Usuario u){
		return "registrarse";
	}
	
	@RequestMapping(value="/login")
	public String loguin(Usuario u){
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loguearse(Usuario u){
		
		Usuario user = usuarios.dameUsuario(u);
    	if(user != null){
    		
    		user.setLog(true);
    	    return new ModelAndView("welcome","userlogin", user);	
    	}
    	else
    	    return new ModelAndView("login","error", "Usuario/contraseña incorrectos");
	}
	
	
	@RequestMapping(value="/registrarse", method=RequestMethod.POST)
	public ModelAndView registro(Usuario u){
		
		ModelAndView modelo = new ModelAndView("registrarse");
		if (u.emailCorrecto()){
			if (u.nombreCorrecto()){
				if (u.passwordCorrecta()){
					
					Usuario user = usuarios.dameUsuario(u);
					if (user == null){
						
						usuarios.anyadeUsuario(u);
						modelo.addObject("exito", "Usuario registrado correctamente" );
					}
					else 
						modelo.addObject("errorUsuario", "Usuario no registrado" );
					
				}else modelo.addObject("errorPassword", "Password incorrecta" );
			}else modelo.addObject("errorNombre", "Nombre incorrecto" );
		}else modelo.addObject("errorEmail", "Email incorrecto" );
		
		return modelo;
		
	}
}
