package com.renzo.cursoMC;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.renzo.cursoMC.domain.Categoria;
import com.renzo.cursoMC.domain.Cidade;
import com.renzo.cursoMC.domain.Estado;
import com.renzo.cursoMC.domain.Produto;
import com.renzo.cursoMC.repositories.CategoriaRepository;
import com.renzo.cursoMC.repositories.CidadeRepository;
import com.renzo.cursoMC.repositories.EstadoRepository;
import com.renzo.cursoMC.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoMcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/* ------ INSTÂNCIAS DE CATEGORIAS */
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		/* ------ INSTÂNCIAS DE PRODUTOS */
		
		Produto prod1 = new Produto(null,"Computador",2000.00);
		Produto prod2 = new Produto(null,"Impressora",800.00);
		Produto prod3 = new Produto(null,"Mouse",80.00);
					
		//associando os produtos em suas respectivas categorias
		cat1.getProdutos().addAll(Arrays.asList(prod1,prod2,prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod2));
		
		//associando as categorias de origem para os produtos
		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		prod3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(prod1,prod2,prod3));
		
		/* ------ INSTÂNCIAS DE ESTADOS */
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		/* ------ INSTÂNCIAS DE CIDADES */
		Cidade cid1 = new Cidade(null,"Uberlândia",est1);
		Cidade cid2 = new Cidade(null,"São Paulo",est2);
		Cidade cid3 = new Cidade(null,"Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2,cid3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));
		
	}
}
