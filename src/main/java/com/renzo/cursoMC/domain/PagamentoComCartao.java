package com.renzo.cursoMC.domain;

import javax.persistence.Entity;

import com.renzo.cursoMC.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Integer nroDeParcelas;
	
	public PagamentoComCartao() {
		super();
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer nroDeParcelas) {
		super(id, estado, pedido);
		this.nroDeParcelas = nroDeParcelas;
	}

	public Integer getNroDeParcelas() {
		return nroDeParcelas;
	}

	public void setNroDeParcelas(Integer nroDeParcelas) {
		this.nroDeParcelas = nroDeParcelas;
	}

}
