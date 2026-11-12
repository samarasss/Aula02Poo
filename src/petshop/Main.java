package petshop;

import java.util.HashSet;

public class Main {
    static void main() {
//        String palavraA = "casa";
//        String palavraB = "casa";
//
//        if(palavraA.equals(palavraB)){
//            System.out.println("Palavras iguais");
//        }else{
//            System.out.println("Palavras diferentes");
//        }

        HashSet<Produto> produtos = new HashSet<>();

        Produto prodA = new Produto(5, "Produto", 85, 8);
        Produto prodB = new Produto(5, "Produto", 85, 8);

        produtos.add(prodA);
        produtos.add(prodB);

        for(Produto prod: produtos){
            System.out.println(prod);
        }
        if(prodA.equals(prodB)){
            System.out.println("produtos iguais");
        }else{
            System.out.println("produtos diferentes");
        }

    }
}
