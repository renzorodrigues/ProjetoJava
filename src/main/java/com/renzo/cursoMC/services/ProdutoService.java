package com.renzo.cursoMC.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renzo.cursoMC.domain.Categoria;
import com.renzo.cursoMC.repositories.CategoriaRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		
		Optional<Categoria> obj = repo.findById(id);		
		return obj.orElse(null);
		
	}
}
