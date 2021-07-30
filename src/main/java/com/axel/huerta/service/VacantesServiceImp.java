package com.axel.huerta.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.axel.huerta.model.Categoria;
import com.axel.huerta.model.Vacante;


@Service
public class VacantesServiceImp implements IntVacantesService {
	
	private List<Vacante>lista;
	
	public VacantesServiceImp() {
		lista = new LinkedList<Vacante>();
		DateTimeFormatter formato = DateTimeFormatter.
				ofPattern("dd-MM-yyyy");
		try {
			//objetos de tipo Vacante
			Vacante v1 = new Vacante();
			v1.setId(1);
			v1.setNombre("Ingeniero en sistemas");
			v1.setDescripcion("Sistemas");
			v1.setSalario(15000.00);
			v1.setFecha(LocalDate.parse("02-06-2021", formato));
			v1.setDestacado(1);
			v1.setImagen("logo1.png");
			v1.setEstatus("Creada");
			v1.setDetalles("<h1><strong>Amplia experencia</strong></h1>");
			Categoria c1 = new Categoria();
			c1.setId(1);
			c1.setNombre("Ingenieros");
			c1.setDescripcion("ingenieros en sistemas");
			v1.setCategoria(c1);
			/*******************/
			Vacante v2 = new Vacante();
			v2.setId(2);
			v2.setNombre("Ingeniero en Base de datos");
			v2.setDescripcion("BD");
			v2.setSalario(15870.00);
			v2.setFecha(LocalDate.parse("05-08-2021", formato));
			v2.setDestacado(1);
			v2.setImagen("logo10.png");
			v2.setEstatus("Aprobada");
			v2.setDetalles("<h1><strong>Amplia experencia</strong></h1>");
			Categoria c2 = new Categoria();
			c2.setId(1);
			c2.setNombre("Ingenieros");
			c2.setDescripcion("ingenieros en sistemas");
			v2.setCategoria(c2);
			
			/****************************************/
			Vacante v3 = new Vacante();
			v3.setId(3);
			v3.setNombre("Ingeniero en mecatronica");
			v3.setDescripcion("mecatronica");
			v3.setSalario(55000.00);
			v3.setFecha(LocalDate.parse("01-12-2021", formato));
			v3.setDestacado(0);
			v3.setImagen("logo12.png");
			v3.setEstatus("Eliminada");
			v3.setDetalles("<h1><strong>Amplia experencia</strong></h1>");
			Categoria c3 = new Categoria();
			c3.setId(2);
			c3.setNombre("Contadores");
			c3.setDescripcion("Contadores relacionados en finanzas");
			v3.setCategoria(c3);
			/******************************************/
			
			Vacante v4 = new Vacante();
			v4.setId(4);
			v4.setNombre("Ingeniero en robotica");
			v4.setDescripcion("Robotica");
			v4.setSalario(100000.00);
			v4.setFecha(LocalDate.parse("12-11-2021", formato));
			v4.setDestacado(0);
			v4.setImagen("logo1.png");
			v4.setEstatus("Creada");
			v4.setDetalles("<h1><strong>Amplia experencia</strong></h1>");
			Categoria c4 = new Categoria();
			c4.setId(1);
			c4.setNombre("Ingenieros en robotica");
			c4.setDescripcion("ingenieros en robotica");
			v4.setCategoria(c4);
			
			lista.add(v1);
			lista.add(v2);
			lista.add(v3);
			lista.add(v4);
			
		}catch(DateTimeParseException ex) {
			System.out.println("Error : " + ex.getMessage());
			
		}
		
	}

	@Override
	public List<Vacante> obtenerTodas() {
		
		return lista;
	}

	@Override
	public void guardar(Vacante vacante) {
		lista.add(vacante);

	}

	@Override
	public void eliminar(Integer idVacante) {
		lista.remove(buscarPorId(idVacante));

	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		for(Vacante v : lista ) {
			if ( v.getId() == idVacante) {
				return v;
			}
		}
		return null;
	}

	@Override
	public List<Vacante> obtenerDestacadas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer totalEntidades() {
		// TODO Auto-generated method stub
		return null;
	}

}
