import model.CarrinhoDeCompras;
import org.junit.Test;
import service.EditarCarrinho;
import service.EscolherBebida;
import service.EscolherLanche;

import java.util.Scanner;

public class MenuTest {


    @Test
    static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        System.out.println("||--Bem-vindo ao totem de autoatendimento!--||");


        int opcao = 0;

        do {
            System.out.println("||--------------Menu Inicial: -------------||");
            System.out.println("||----------------1. Lanche----------------||");
            System.out.println("||----------------2. Bebida----------------||");
            System.out.println("||----------------3. Editar Pedido---------||");
            System.out.println("||----------------3. Finalizar Pedido------||");
            System.out.println("||--------------Escolha uma opção: --------||");
            String input = scanner.nextLine();

            if (input.matches("\\d+")) {
                opcao = Integer.parseInt(input);

                switch (opcao) {
                    case 1:
                        EscolherLanche.escolherLanche(scanner, carrinho);
                        break;
                    case 2:
                        EscolherBebida.escolherBebida(scanner, carrinho);
                        break;

                    case 3:
                        EditarCarrinho.editarCarrinho(scanner, carrinho);
                        break;
                    case 4:

                        break;
                    case 5:
                        opcao = 0; // Encerrar o loop
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente.");
                }
            } else {
                System.out.println("Formato inválido, para escolher o item, você deve informar o número dele.");
            }
        } while (opcao != 0);

        scanner.close();
    }


}
