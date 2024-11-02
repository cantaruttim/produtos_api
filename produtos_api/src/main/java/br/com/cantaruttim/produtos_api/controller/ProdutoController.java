package br.com.cantaruttim.produtos_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cantaruttim.produtos_api.model.Produto;
import br.com.cantaruttim.produtos_api.repository.ProdutoRepository;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("produtos")
public class ProdutoController {
    

    private ProdutoRepository produtoRepositoy;

    public ProdutoController(ProdutoRepository produtoRepositoy) {
        this.produtoRepositoy = produtoRepositoy;
    }


    @GetMapping
    public List<Produto> buscar(@RequestParam String nome) {
        return produtoRepositoy.findByNome(nome);
    }
    

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") String id){
        produtoRepositoy.deleteById(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable String id, @RequestBody Produto produto) {        
        produto.setId(id);
        produtoRepositoy.save(produto);
    }


    @GetMapping("/{id}")
    public Produto obterProduto(@PathVariable("id") String id){
        // busca por Id
        return produtoRepositoy.findById(id).orElse(null);
    }


    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        System.out.println("Produto recebido: " + produto);
        var id =  UUID.randomUUID().toString();
        produto.setId(id);
        produtoRepositoy.save(produto);   
        return produto;
    }
    


}
