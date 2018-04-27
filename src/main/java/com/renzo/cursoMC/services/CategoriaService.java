package com.renzo.cursoMC.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renzo.cursoMC.domain.Categoria;
import com.renzo.cursoMC.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		
		Optional<Categoria> obj = repo.findById(id);		
		return obj.orElseThrow(() -> new com.renzo.cursoMC.services.exceptions.ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + " | Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
}
