package com.axel.huerta.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.axel.huerta.model.Categoria;


@Service
public class CategoriasServiceImp implements IntCategoriasService{
	
	private List<Categoria> lista;
	public CategoriasServiceImp(){
	lista = new LinkedList<Categoria>();

	Categoria c1 = new Categoria();
	 c1.setId(1);
	c1.setNombre("Ingenieros");
	c1.setDescripcion("Relacionasdo con ramas de las ingenieria");
	//********************************************
	Categoria c2 = new Categoria();
	 c2.setId(2);
	c2.setNombre("Contadores");
	c2.setDescripcion("Relacionasdo con contabilidad y finanzas");
	//********************************************
	Categoria c3 = new Categoria();
	 c3.setId(3);
	c3.setNombre("Auxiliares de limpieza");
	c3.setDescripcion("Relacionado con limpieza de oficinas");
	//********************************************
	Categoria c4 = new Categoria();
	 c4.setId(4);
	c4.setNombre("Vigilancia");
	c4.setDescripcion("Relacionado con segurirdad");
	//********************************************
	
	lista.add(c1);
	lista.add(c2);
	lista.add(c3);
	lista.add(c4);
	
	
	}


	@Override
	public List<Categoria> obtenerTodos() {
		
		return lista;
	}

	@Override
	public void guardar(Categoria categoria) {
		lista.add(categoria);
		
	}

	@Override
	public void eliminar(Integer idCategoria) {
		lista.remove(buscarPorId(idCategoria));
		
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		for(Categoria c: lista) {
			if(c.getId()== idCategoria) {
				return c;
				
			}
		}
		return null;
	}


	@Override
	public Page<Categoria> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
