package petshop;

import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    private ArrayList<Produto> produtos;
    private int codigo = 0;

    public Sistema() {
        this.produtos = new ArrayList<>();
    }

    public void cadastrarProduto(Scanner scanner) throws PrecoInvalidoException{
        this.codigo +=1;
        System.out.println("Digite o nome do produto?");
        String nome = scanner.nextLine();

        System.out.println("Digite o preço do produto?");
        double preco = scanner.nextDouble();

        if(preco <= 0){
            throw new PrecoInvalidoException("O preço precisa ser maior que 0");
        }

        System.out.println("Digite a quantidade do produto?");
        int quantidade = scanner.nextInt();

        System.out.println("Qual produto você quer cadastrar? \n1.Ração \n2.Acessorio");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if(opcao == 1){
           cadastrarRacao(scanner, nome, preco, quantidade);
        } else if (opcao == 2) {
           cadastrarAcessorio(scanner, nome, preco, quantidade);
        } else{
            System.out.println("Opção Inválida");
        }
    }

    private void cadastrarRacao(Scanner scanner,String nome, double preco, int quantidade){
        System.out.println("Qual o tipo de Ração");
        System.out.println("1. Gato");
        System.out.println("2. Cachorro");
        System.out.println("3. Outro");
        TipoRacao tipoRacao = null;
        int opcaoRacao = scanner.nextInt();
        if(opcaoRacao == 1){
            tipoRacao = TipoRacao.GATO;
        } else if (opcaoRacao == 2) {
            tipoRacao = TipoRacao.CACHORRO;
        }else if (opcaoRacao == 3) {
            tipoRacao = TipoRacao.OUTRO;
        }
        Racao racao = new Racao(codigo,nome, preco, quantidade, tipoRacao);
        produtos.add(racao);
        System.out.println("Produto cadastrado!");
    }

    private void cadastrarAcessorio(Scanner scanner,String nome, double preco, int quantidade){
        System.out.println("Qual o tamanho do acessório? ");
        String tamanho = scanner.nextLine();
        Acessorio acessorio = new Acessorio(codigo,nome, preco, quantidade, tamanho);
        produtos.add(acessorio);
        System.out.println("Produto cadastrado!");
    }

    public void listar(){
        if(produtos.isEmpty()){
            System.out.println("Não há produtos cadastrados");
        }else{
            for (Produto prod: produtos){
                System.out.println(prod);
                System.out.println("_____________");
            }
        }
    }

    public void buscar(Scanner scanner){
        System.out.println("1. Buscar por código");
        System.out.println("2. Buscar por Nome");
        int opcaoBusca = scanner.nextInt();
        scanner.nextLine();

        if(opcaoBusca == 1){
            buscarCodigo(scanner);
        } else if (opcaoBusca == 2) {
            buscarPorNome(scanner);
        } else{
            System.out.println("Opção Inválida!");
        }
    }

    public Produto buscarCodigo(Scanner scanner){
        System.out.println("Digite o código do produto:");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        for(Produto produto: produtos){
            if(produto.getCodigo() == codigo){
                System.out.println("Produto Encontrado");
                System.out.println(produto);
                return produto;
            }
        }
        System.out.println("Produto não encontrado!");
        return null;

    }

    public void buscarPorNome(Scanner scanner){
        System.out.println("Qual o nome do produto procurado?");
        String nome = scanner.nextLine();
        int elementos = 0;
        for (Produto prod: produtos){
            if(prod.getNome().equalsIgnoreCase(nome)){
                elementos +=1;
                System.out.println(prod);
            }
        }
        if(elementos == 0){
            System.out.println("Não foi localizado elementos com esse nome");
        }
    }

    // PARA CASA: Atualizar preço e Atualizar quantidade
    public void atualizarNome(Scanner scanner){
        Produto produto = buscarCodigo(scanner);

        if(produto == null){
            System.out.println("Impossível atualizar");
        }else{
            System.out.println("Digite o novo nome:");
            String novoNome = scanner.nextLine();
            produto.setNome(novoNome);
            System.out.println("Produto Atualizado!");
        }
    }

    //PARA CASA: Remover todos os produtos que contenha o mesmo nome
    public void removerProdutoCodigo(Scanner scanner){
        Produto produto = buscarCodigo(scanner);

        if(produto == null){
            System.out.println("Impossível remover");
        }else{
            produtos.remove(produto);
            System.out.println("Produto Removido");
        }
    }

    // trocar para usar o buscar por Nome
    public void removerProdutoNome(Scanner scanner){
        //Saber o nome de quem vai ser removido
        //Procuro os elementos
            //for
                //if
                    // remover o elemento que contenha o mesmo nome

        System.out.println("Digite o nome do produto procurado: ");
        String nomeProcurado = scanner.nextLine();

        for(Produto prod:produtos){
            if(prod.getNome().equalsIgnoreCase(nomeProcurado)){
                produtos.remove(prod);
            }
        }
    }

    public void aplicarPromocao(Scanner scanner){
        System.out.println("Qual a porcentagem de desconto?");
        double porcentagemDesconto = scanner.nextDouble();
        scanner.nextLine();

        for(Produto prod: produtos){
            if(prod instanceof Promocionavel){
                ((Promocionavel)prod).aplicarDesconto(porcentagemDesconto);
            }
        }
    }
}
