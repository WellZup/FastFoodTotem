package service;


import model.CarrinhoDeCompras;

import java.util.Scanner;



public class EscolherLanche {


    public static int escolherLanche(Scanner scanner, CarrinhoDeCompras carrinho) {
        System.out.println("||--------------Escolha um lanche:---------||");
        System.out.println("||---------------1. X-burger---------------||");
        System.out.println("||---------------2. X-salada---------------||");

        int opcao = 0;
        String input = scanner.nextLine();

        if (input.matches("\\d+")) {
            opcao = Integer.parseInt(input);

            switch (opcao) {
                case 1:
                    System.out.print("Quantidade: ");
                    int quantidade = Integer.parseInt(scanner.nextLine());
                    carrinho.adicionarItem("X-burger", quantidade);
                    break;
                case 2:
                    System.out.print("Quantidade: ");
                    quantidade = Integer.parseInt(scanner.nextLine());
                    carrinho.adicionarItem("X-salada", quantidade);
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
                    //inserirItemNoBancoDeDados(carrinhoId,opcao, quantidade);
        }

        return opcao;
    }


}