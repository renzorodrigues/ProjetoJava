package com.renzo.cursoMC.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renzo.cursoMC.domain.Cliente;
import com.renzo.cursoMC.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		
		Optional<Cliente> obj = repo.findById(id);		
		return obj.orElseThrow(() -> new com.renzo.cursoMC.services.exceptions.ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + " | Tipo: " + Cliente.class.getName()));
				
	}
}
