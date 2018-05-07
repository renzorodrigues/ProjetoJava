package com.renzo.cursoMC;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.renzo.cursoMC.domain.Categoria;
import com.renzo.cursoMC.domain.Cidade;
import com.renzo.cursoMC.domain.Cliente;
import com.renzo.cursoMC.domain.Endereco;
import com.renzo.cursoMC.domain.Estado;
import com.renzo.cursoMC.domain.ItemPedido;
import com.renzo.cursoMC.domain.Pagamento;
import com.renzo.cursoMC.domain.PagamentoComBoleto;
import com.renzo.cursoMC.domain.PagamentoComCartao;
import com.renzo.cursoMC.domain.Pedido;
import com.renzo.cursoMC.domain.Produto;
import com.renzo.cursoMC.domain.enums.EstadoPagamento;
import com.renzo.cursoMC.domain.enums.TipoCliente;
import com.renzo.cursoMC.repositories.CategoriaRepository;
import com.renzo.cursoMC.repositories.CidadeRepository;
import com.renzo.cursoMC.repositories.ClienteRepository;
import com.renzo.cursoMC.repositories.EnderecoRepository;
import com.renzo.cursoMC.repositories.EstadoRepository;
import com.renzo.cursoMC.repositories.ItemPedidoRepository;
import com.renzo.cursoMC.repositories.PagamentoRepository;
import com.renzo.cursoMC.repositories.PedidoRepository;
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
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	/* ------ INSTÂNCIAS DE CATEGORIAS */
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		Categoria cat3 = new Categoria(null,"Cama, Mesa e Banho");
		Categoria cat4 = new Categoria(null,"Eletrônicos");
		Categoria cat5 = new Categoria(null,"Jardinagem");
		Categoria cat6 = new Categoria(null,"Decoração");
		Categoria cat7 = new Categoria(null,"Perfumaria");
		
	/* ------ INSTÂNCIAS DE PRODUTOS */
		
		Produto prod1 = new Produto(null,"Computador",2000.00);
		Produto prod2 = new Produto(null,"Impressora",800.00);
		Produto prod3 = new Produto(null,"Mouse",80.00);
		Produto prod4 = new Produto(null,"Mesa de escritório",300.00);
		Produto prod5 = new Produto(null,"Toalha",50.00);
		Produto prod6 = new Produto(null,"Colcha",200.00);
		Produto prod7 = new Produto(null,"TV true color",1200.00);
		Produto prod8 = new Produto(null,"Roçadeira",800.00);
		Produto prod9 = new Produto(null,"Abajour",100.00);
		Produto prod10 = new Produto(null,"Pendente",180.00);
		Produto prod11 = new Produto(null,"Shampoo",90.00);
					
		//associando os produtos em suas respectivas categorias
		cat1.getProdutos().addAll(Arrays.asList(prod1,prod2,prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod2,prod4));
		cat3.getProdutos().addAll(Arrays.asList(prod5,prod6));
		cat4.getProdutos().addAll(Arrays.asList(prod1,prod2,prod3,prod7));
		cat5.getProdutos().addAll(Arrays.asList(prod8));
		cat6.getProdutos().addAll(Arrays.asList(prod9,prod10));
		cat7.getProdutos().addAll(Arrays.asList(prod11));
		
		//associando a(s) categoria(s) de cada produto
		prod1.getCategorias().addAll(Arrays.asList(cat1,cat4));
		prod2.getCategorias().addAll(Arrays.asList(cat1,cat2,cat4));
		prod3.getCategorias().addAll(Arrays.asList(cat1,cat4));
		prod4.getCategorias().addAll(Arrays.asList(cat2));
		prod5.getCategorias().addAll(Arrays.asList(cat3));
		prod6.getCategorias().addAll(Arrays.asList(cat3));
		prod7.getCategorias().addAll(Arrays.asList(cat4));
		prod8.getCategorias().addAll(Arrays.asList(cat5));
		prod9.getCategorias().addAll(Arrays.asList(cat6));
		prod10.getCategorias().addAll(Arrays.asList(cat6));
		prod11.getCategorias().addAll(Arrays.asList(cat7));
		
		//adicionando a lista de instâncias em seu respectivo Repository
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5,cat6,cat7));
		produtoRepository.saveAll(Arrays.asList(prod1,prod2,prod3,prod2,prod4,prod5,prod6,prod7,prod8,prod9,prod10,prod11));
		
	/* ------ INSTÂNCIAS DE ESTADOS */
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
	/* ------ INSTÂNCIAS DE CIDADES */
		Cidade cid1 = new Cidade(null,"Uberlândia",est1);
		Cidade cid2 = new Cidade(null,"São Paulo",est2);
		Cidade cid3 = new Cidade(null,"Campinas",est2);
		
		//associando a(s) cidade(s) de cada estado
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2,cid3));
		
		//adicionando a lista de instâncias em seu respectivo Repository
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));
		
	/* ------ INSTÂNCIAS DE CLIENTES */
		Cliente cli1 = new Cliente(null,"Maria Silva","maria@gmail.com","05012455630",TipoCliente.PESSOAFISICA);
		//adicionando o(s) telefone(s) do cliente
		cli1.getTelefones().addAll(Arrays.asList("32356230","991254585"));
	
	/* ------ INSTÂNCIAS DE ENDEREÇOS */
		Endereco end1 = new Endereco(null,"Rua Flores","300","Apto 203","Jardim","38220834",cli1,cid1);
		Endereco end2 = new Endereco(null,"Avenida Matos","105","Sala 800","Centro","38777012",cli1,cid2);
		//associando o(s) endereço(s) para o cliente
		cli1.getEnderecos().addAll(Arrays.asList(end1,end2));
		
		//adicionando a lista de instâncias em seu respectivo Repository
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end1,end2));
		
	/* ------ INSTÂNCIAS DE PEDIDOS */
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null,sdf.parse("30/09/2017 10:32"),cli1,end1);
		Pedido ped2 = new Pedido(null,sdf.parse("10/10/2017 19:35"),cli1,end2);
		
	/* ------ INSTÂNCIAS DE PEDIDOS */
		Pagamento pag1 = new PagamentoComCartao(null,EstadoPagamento.QUITADO,ped1,6);
		ped1.setPagamento(pag1);
		Pagamento pag2 = new PagamentoComBoleto(null,EstadoPagamento.PENDENTE,ped2,sdf.parse("20/10/2017 00:00"),null);
		ped2.setPagamento(pag2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		//adicionando a lista de instâncias em seu respectivo Repository
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pag1,pag2));
		
	/* ------ INSTÂNCIAS DE ITEMPEDIDOS */
		ItemPedido itp1 = new ItemPedido(ped1,prod1,0.00,1,2000.00);
		ItemPedido itp2 = new ItemPedido(ped1,prod3,0.00,2,80.00);
		ItemPedido itp3 = new ItemPedido(ped2,prod2,100.00,1,800.00);
		
		ped1.getItens().addAll(Arrays.asList(itp1,itp2));
		ped2.getItens().addAll(Arrays.asList(itp3));
		
		prod1.getItens().addAll(Arrays.asList(itp1));
		prod2.getItens().addAll(Arrays.asList(itp3));
		prod3.getItens().addAll(Arrays.asList(itp2));
		
		itemPedidoRepository.saveAll(Arrays.asList(itp1,itp2,itp3));
	}
}
