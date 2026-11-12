package petshop;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    static void main() {
        try{
            Scanner scanner = new Scanner(System.in);
            Sistema sistema = new Sistema();

            int opcao =0;

            while(opcao !=6){

                System.out.println("Menu");
                System.out.println("1 - Cadastrar Produto");
                System.out.println("2 - Listar Produtos");
                System.out.println("3 - Buscar Produto");
                System.out.println("4 - Atualizar Produto");
                System.out.println("5 - Remover Produto");
                System.out.println("6 - Sair");
                System.out.println("Digite sua opção: ");

                try{
                    opcao = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Entrada Inválida");
                }


                scanner.nextLine();

                switch (opcao){
                    case 1:
                        try {
                            sistema.cadastrarProduto(scanner);
                        } catch (PrecoInvalidoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        sistema.listar();
                        break;
                    case 3:
                        sistema.buscar(scanner);
                        break;
                    case 4:
                        sistema.atualizarNome(scanner);
                        break;
                    case 5:
                        //sistema.removerProduto(scanner);
                        break;
                    case 6:
                        System.out.println("Saindo ...");
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada Inválida");
        }
    }
}
