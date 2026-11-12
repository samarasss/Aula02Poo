package petshop;


import java.util.ArrayList;
import java.util.List;

public class SistemaAuxiliar {

    private List<Produto> produtos = new ArrayList<>();

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public SistemaAuxiliar() {
        this.produtos = new ArrayList<>();
    }

    public void cadastrar(Produto produto){
        produtos.add(produto);
    }


}
