package br.com.cantaruttim.produtos_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.cantaruttim.produtos_api.model.Produto;
import java.util.List;


public interface ProdutoRepository extends JpaRepository <Produto, String> {

    List<Produto> findByNome(String nome);
    
}
