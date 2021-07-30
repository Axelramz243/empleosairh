package com.axel.huerta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.axel.huerta.model.Categoria;
import com.axel.huerta.service.IntCategoriasService;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {
	
	
	@Autowired
	private IntCategoriasService categoriasService;
	
	@GetMapping("/buscar")
	public String buscar(@RequestParam("id") int idCategoria,
			Model model) {
		Categoria categoria = categoriasService.buscarPorId(idCategoria);
		System.out.println(categoria);
		model.addAttribute("categoria",categoria);
		return "categorias/formCategoria";
	}
	
	@PostMapping("/guardar")
	//Data binding (vincular entre la clase modelo y de formulario
	public String guardar(Categoria categoria,
			RedirectAttributes attribute) {
		//categoria.setId(categoriasService.obtenerTodos().size()+1);
		//guardar el objeto de categoria
		
				categoriasService.guardar(categoria);
				attribute.addFlashAttribute("msg", "¡Categoria guardada con exito!");
		return "redirect:/categorias/indexPaginate";
		
	}
	/*
	@PostMapping("/guardar")
	public String guardar(@RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion,
			RedirectAttributes attribute) {
		System.out.println("Nombre: "+ nombre);
		System.out.println("Descripcion: "+ descripcion);
		Categoria categoria = new Categoria();
		categoria.setId(categoriasService.obtenerTodos().size()+1);
		categoria.setNombre(nombre);
		categoria.setDescripcion(descripcion);
		
		//guardar el objeto de categoria
		categoriasService.guardar(categoria);
		//redireccionamineto /categorias/index
		attribute.addFlashAttribute("msg", "¡Categoria guardada con exito!");
		return "redirect:/categorias/index";
		
	}*/
	
	
	@GetMapping("/crear")
	public String crear(Categoria categoria) {
		return "categorias/formCategoria";
	}
	
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") int idCategoria, 
			Model model) {
		System.out.println("IdCategoria =" + idCategoria);
		//eliminar categoria
		categoriasService.eliminar(idCategoria);
		
		return "redirect:/categorias/indexPaginate";
	}
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Categoria>lista = categoriasService.buscarTodas(page);
		model.addAttribute("categorias", lista);
		return "categorias/listaCategorias";}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Categoria> lista = categoriasService.obtenerTodos();
		for(Categoria categoria : lista) {
			System.out.println(categoria);
		}
		model.addAttribute("categorias", lista);
		return "categorias/listaCategorias";
	}

}
