package service;

import model.CarrinhoDeCompras;

import java.util.Map;
import java.util.Scanner;



public class FinalizarPedido {
    private static void finalizarPedido(Scanner scanner, CarrinhoDeCompras carrinho) {
        System.out.println("||--------------Itens no Carrinho: --------------||");
        Map<String, Integer> itens = carrinho.getItens();
        for (Map.Entry<String, Integer> entry : itens.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        double total = carrinho.calcularTotal();
        System.out.println("||--------------Valor total: R$" + total+ " ------------||");

        // Criar um carrinho no banco de dados
        int carrinhoId = CarrinhoDeCompras.criarCarrinhoNoBancoDeDados(total);

        // Inserção dos itens do carrinho no banco de dados (após adicionar os itens ao carrinho)
        for (Map.Entry<String, Integer> entry : itens.entrySet()) {
            String item = entry.getKey();
            int opcao = item.equals("X-burger") || item.equals("X-salada") ? 1 : 2;
            int quantidade = entry.getValue();
            CarrinhoDeCompras.inserirItemNoBancoDeDados(carrinhoId, opcao, quantidade);
        }

        System.out.println("||----------Escolha a forma de pagamento: ------------||");
        System.out.println("||--------------1. Cartão de Crédito -----------------||");
        System.out.println("||--------------2. Cartão de Débito  -----------------||");
        System.out.println("||--------------3. Vale Refeição  --------------------||");
        System.out.println("||--------------4. Dinheiro    -----------------------||");

        int opcao = 0;
        do {
            System.out.print("||--------------Escolha uma opção: --------------||");
            String input = scanner.nextLine();

            if (input.matches("\\d+")) {
                opcao = Integer.parseInt(input);

                switch (opcao) {
                    case 1:
                    case 2:
                    case 3:
                        System.out.println("||--------------Compra finalizada com sucesso! Boa refeição.------------||");
                        opcao = 0; // Encerrar o loop
                        break;
                    case 4:
                        System.out.print("||--------------Valor em dinheiro: R$ --------------||");
                        double valorPago = Double.parseDouble(scanner.nextLine());
                        if (valorPago >= total) {
                            double troco = valorPago - total;
                            System.out.println("||--------------Troco: R$" + troco + " --------------||");
                            System.out.println("||--------------Compra finalizada com sucesso! Boa refeição.------------||");
                            opcao = 0; // Encerrar o loop
                        } else {
                            System.out.println("||--------------Valor insuficiente. Insira um valor maior ou igual ao total da compra.--------------||");
                        }
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente.");
                }
            } else {
                System.out.println("Formato inválido, para escolher a opção, você deve informar o número dela.");
            }
        } while (opcao != 0);
    }


}
