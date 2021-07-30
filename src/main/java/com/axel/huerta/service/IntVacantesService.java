package com.axel.huerta.service;

import java.util.List;

import com.axel.huerta.model.Vacante;

public interface IntVacantesService {
	
	
	public List<Vacante> obtenerTodas();
	public void guardar(Vacante vacante);
	public void eliminar(Integer idVacante);
	public Vacante buscarPorId(Integer idVacante);
	
	public List<Vacante> obtenerDestacadas();
	public Integer totalEntidades();
	

}
