package es.fdi.Twiter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebMvc //Habilitar seguridad de Spring MVC
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	/**
	 * Especifica cómo deben protegerse las solicitudes http y que opciones tiene un cliente
	 * para autenticar al usuario.
	 * Con authorizeRequests().anyRequest().authenticated() se exige que se autentiquen 
	 * todas las solicitudes que lleguen.
	 * Tambien admite la autenticacion por inicio de sesion con formularios.
	 */
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
	}
	
	/**
	 * inMemoryAuthentication() habilita un repo de usuarios en memoria, pero necesita usuarios 
	 * o el repo no valdrá para nada.
	 * withUser() añade un nuevo usuario al repo de usuarios en memoria. Devuelve 
	 * UserDetailsConfigurer, que cuenta con metodos para configurar el usuario.
	 * 
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()// hanilita un repo de usuarios en memoria
		.withUser("user").password("password").roles("USER").and()
		.withUser("admin").password("password").roles("USER","ADMIN");
	}
}
