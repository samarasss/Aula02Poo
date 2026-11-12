package petshop;

public class Acessorio extends Produto{

    private String tamanho;

    public Acessorio(int codigo, String nome, double preco, int quantidade, String tamanho) {
        super(codigo, nome, preco, quantidade);
        this.tamanho = tamanho;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
}
