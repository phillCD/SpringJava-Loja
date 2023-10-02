package com.satc.satcloja.health;

import com.satc.satcloja.enums.Status;
import com.satc.satcloja.model.*;
import com.satc.satcloja.repository.ClienteRepository;
import com.satc.satcloja.repository.ProdutoRepository;
import com.satc.satcloja.repository.ServicoRepository;
import com.satc.satcloja.repository.VendaRepository;
import com.satc.satcloja.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class HealthCheckController {

    @Autowired
    public ProdutoRepository produtoRepository;
    @Autowired
    public ServicoRepository servicoRepository;
    @Autowired
    public ClienteRepository clienteRepository;
    @Autowired
    public VendaRepository vendaRepository;
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/health")
    public String healthCheck() {

        return "OK";
    }

    @GetMapping("/teste-produtos-alugados")
    public String healthCheck4(){
        List<Produto> produtosAlugados = produtoService.findProdutosAlugados();
        return produtosAlugados.toString();
    }

    @GetMapping("/teste")
    public String healthCheck2(){
        Produto produto = new Produto();
        produto.setDescricao("Intel Pentium I5");
        produto.setNome("PC Intel");
        produto.setValorUnitario(1000.00);
        produto.setDataPrazo(LocalDate.now());
        produto.setDataValidade(LocalDate.now());
        produto.setPrecoCompra(850.00);
        produto.setStatus(Status.DISPONIVEL);
        produto.setEstocavel(Boolean.TRUE);
        produtoRepository.save(produto);

        Produto produto1 = new Produto();
        produto1.setDescricao("Monitor 144Hz");
        produto1.setNome("Monitor DELL");
        produto1.setValorUnitario(1000.00);
        produto1.setDataPrazo(LocalDate.now());
        produto1.setDataValidade(LocalDate.now());
        produto1.setPrecoCompra(850.00);
        produto1.setStatus(Status.DISPONIVEL);
        produto1.setEstocavel(Boolean.TRUE);
        produtoRepository.save(produto1);

        Produto produto2 = new Produto();
        produto2.setDescricao("Monitor 144Hz");
        produto2.setNome("Monitor DELL");
        produto2.setValorUnitario(1000.00);
        produto2.setDataPrazo(LocalDate.now());
        produto2.setDataValidade(LocalDate.now());
        produto2.setPrecoCompra(850.00);
        produto2.setStatus(Status.ALUGADO);
        produto2.setEstocavel(Boolean.TRUE);
        produtoRepository.save(produto2);



        Servico servico = new Servico();
        servico.setQuantidadeHoras(20.00);
        servico.setDescricao("Instalação Office");
        servico.setEstocavel(Boolean.TRUE);
        servico.setValorUnitario(150.00);
        servico = servicoRepository.save(servico);

        Cliente cliente = new Cliente();
        cliente.setNome("Filipe");
        cliente.setCpf("111222333");
        cliente.setEmail("darude.sandstorm@bing.com");
        cliente.setTelefone("12121212");
        cliente.setEndereco("Rua Agua 2");
        cliente.setRg("9494883939");
        cliente = clienteRepository.save(cliente);

        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setDataVenda(LocalDate.now());
        venda.setObservacao("Teste");
        venda.setFormaPagamento(FormaPagamento.A_VISTA);

        ItemVenda itemVenda = new ItemVenda(produto, 1000.00, 1.0, 10.00);
        ItemVenda itemvenda2 = new ItemVenda(servico, 120.00, 1.0, 10.00);

        venda.addItemVenda(itemVenda);
        venda.addItemVenda(itemvenda2);

        vendaRepository.save(venda);


        return "Comando Executado " + produto.getId() + " " + servico.getId();
    }
}
