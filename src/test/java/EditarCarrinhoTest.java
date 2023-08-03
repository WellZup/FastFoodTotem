import model.CarrinhoDeCompras;
import org.junit.Test;

import java.util.Scanner;

public class EditarCarrinhoTest {
    @Test
    public static void editarCarrinho(Scanner scanner, CarrinhoDeCompras carrinho) {
        System.out.println("Opções de edição do carrinho:");
        System.out.println("1. Adicionar item");
        System.out.println("2. Remover item");
        System.out.println("3. Editar quantidade de um item");
        System.out.println("0. Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");
        int opcao = Integer.parseInt(scanner.nextLine());

        switch (opcao) {
            case 1:
                adicionarItemCarrinho(scanner, carrinho);
                break;
            case 2:
                removerItemCarrinho(scanner, carrinho);
                break;
            case 3:
                editarQuantidadeItemCarrinho(scanner, carrinho);
                break;
            case 0:

                break;
            default:
                System.out.println("Opção inválida, tente novamente.");
                editarCarrinho(scanner, carrinho); // Chama novamente a função para escolher outra opção válida
        }
    }

    private static void adicionarItemCarrinho(Scanner scanner, CarrinhoDeCompras carrinho) {
        System.out.println("Lanches e bebidas disponíveis:");
        System.out.println("1. X-burger - R$10.00");
        System.out.println("2. X-salada - R$12.00");
        System.out.println("3. Refrigerante - R$8.00");
        System.out.println("4. Suco - R$6.00");
        System.out.print("Escolha um item: ");
        int opcao = Integer.parseInt(scanner.nextLine());

        String item;
        switch (opcao) {
            case 1:
                item = "X-burger";
                break;
            case 2:
                item = "X-salada";
                break;
            case 3:
                item = "Refrigerante";
                break;
            case 4:
                item = "Suco";
                break;
            default:
                System.out.println("Opção inválida, tente novamente.");
                return;
        }

        System.out.print("Quantidade: ");
        int quantidade = Integer.parseInt(scanner.nextLine());

        carrinho.adicionarItem(item, quantidade);
        System.out.println("Item adicionado ao carrinho.");
    }

    private static void removerItemCarrinho(Scanner scanner, CarrinhoDeCompras carrinho) {
        System.out.print("Digite o nome do item que deseja remover: ");
        String item = scanner.nextLine();

        if (carrinho.getItens().containsKey(item)) {
            carrinho.removerItem(item);
            System.out.println("Item removido do carrinho.");
        } else {
            System.out.println("Item não encontrado no carrinho.");
        }
    }

    private static void editarQuantidadeItemCarrinho(Scanner scanner, CarrinhoDeCompras carrinho) {
        System.out.print("Digite o nome do item que deseja editar a quantidade: ");
        String item = scanner.nextLine();

        if (carrinho.getItens().containsKey(item)) {
            System.out.print("Nova quantidade: ");
            int novaQuantidade = Integer.parseInt(scanner.nextLine());
            carrinho.getItens().put(item, novaQuantidade);
            System.out.println("Quantidade do item atualizada no carrinho.");
        } else {
            System.out.println("Item não encontrado no carrinho.");
        }
    }

}
