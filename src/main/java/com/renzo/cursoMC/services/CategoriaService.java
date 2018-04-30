package com.renzo.cursoMC.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.renzo.cursoMC.domain.Categoria;
import com.renzo.cursoMC.repositories.CategoriaRepository;
import com.renzo.cursoMC.services.exceptions.DataIntegrityException;

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
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Categoria que possui Produtos");
		}
	}
	
	public List<Categoria> findAll(){
		return repo.findAll();
	}
}
