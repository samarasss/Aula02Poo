package petshop;

public class Racao extends Produto implements Promocionavel{

    private TipoRacao tipo;

    public Racao(int codigo, String nome, double preco, int quantidade, TipoRacao tipo) {
        super(codigo, nome, preco, quantidade);
        this.tipo = tipo;
    }

    public TipoRacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoRacao tipo) {
        this.tipo = tipo;
    }

    @Override
    public void aplicarDesconto(double percentual) {
        double valorDesconto = percentual/100 * this.getPreco();
        double novoPreco = this.getPreco() - valorDesconto;
        System.out.println("Novo preço: R$ " + novoPreco);
    }
}
