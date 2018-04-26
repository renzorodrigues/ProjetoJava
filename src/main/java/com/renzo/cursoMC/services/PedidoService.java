package com.renzo.cursoMC.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renzo.cursoMC.domain.Pedido;
import com.renzo.cursoMC.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		
		Optional<Pedido> obj = repo.findById(id);		
		return obj.orElseThrow(() -> new com.renzo.cursoMC.services.exceptions.ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + " | Tipo: " + Pedido.class.getName()));
				
	}
}
