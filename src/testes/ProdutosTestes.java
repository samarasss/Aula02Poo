package testes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import petshop.Produto;
import petshop.SistemaAuxiliar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProdutosTestes {

    SistemaAuxiliar sistema;

    @BeforeEach
    public void setup(){
        sistema = new SistemaAuxiliar();
    }

    @Test
    public void testarCadastro(){
        Produto produtoA = new Produto(8, "Produto A", 85, 8);
        sistema.cadastrar(produtoA);

        assertEquals(1, sistema.getProdutos().size());
       assertEquals("Produto A", sistema.getProdutos().getFirst().getNome());

    }
    @Test
    public void testarCadastrdo(){
        Produto produtoA = new Produto(8, "Produto A", 85, 8);
        sistema.cadastrar(produtoA);

        assertEquals(1, sistema.getProdutos().size());
        assertEquals("Produto A", sistema.getProdutos().getFirst().getNome());

    }
    @Test
    public void listar(){

    }
}
