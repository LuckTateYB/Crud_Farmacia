package com.upn.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upn.demo.interfaces.IPersona;
import com.upn.demo.interfaces.services.IPersonaService;
import com.upn.demo.models.Persona;

@Service
public class PersonaService implements IPersonaService {

	@Autowired
	private IPersona data;
	
	@Override
	public List<Persona> listar() {
		List<Persona> listar = (List<Persona>) data.findAll();
		return listar;
	}

	@Override
	public Optional<Persona> listarId(int id) {
		
		return data.findById(id);
	}

	@Override
	public int save(Persona p) {
		int band = 0;
		Persona p_save = data.save(p);
		if(!p_save.equals(null)) {
			band = 1;
		}		
		
		return band;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}

	
	
}
