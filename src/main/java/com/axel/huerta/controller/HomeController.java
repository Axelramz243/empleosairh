package com.axel.huerta.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.axel.huerta.model.Perfil;
import com.axel.huerta.model.Usuario;
import com.axel.huerta.model.Vacante;
import com.axel.huerta.service.IntUsuariosService;
import com.axel.huerta.service.IntVacantesService;

@Controller
class HomeController {
	
	@Autowired
	private IntUsuariosService usuariosService;
	
	@Autowired
	private IntVacantesService vacantesService;
	
	@GetMapping("/index")
	public String mostrarIndex(Authentication auth) {
		String username = auth.getName();
		System.out.println("Nombre usuario: " + username);
		for(GrantedAuthority rol: auth.getAuthorities()) {
			System.out.println("Rol : " + rol.getAuthority());
		}
		return "redirect:/";
		
	}
	
	@PostMapping("/guardar")
	public String guardarUsuario(Usuario usuario) {
		usuario.setPassword("{noop}"+ usuario.getPassword());
		usuario.setEstatus(1);
		usuario.setFecharegistro(LocalDate.now());
		//Crear perfil o rol, todos los que se registren
		Perfil per =new Perfil();
		per.setId(3); //rol de usuario
		usuario.agregar(per);
		
		usuariosService.guardar(usuario);
		return "formLogin";
		
	}
	
	@GetMapping("/registro")
	public String registroUsuario(Usuario usuario) {
		return "formRegistro";
	}
	
	@GetMapping("/")
	public String mostrarHome(Model model) {
		List<Vacante> vacantes = vacantesService.obtenerDestacadas();
		model.addAttribute("vacantes",vacantes);
		return "home";
	}
	
	

}
