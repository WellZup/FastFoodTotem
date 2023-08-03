import model.CarrinhoDeCompras;
import org.junit.Test;

import java.util.Scanner;

public class EscolherBebidaTest {
    @Test
    public static void escolherBebida(Scanner scanner, CarrinhoDeCompras carrinho) {


        System.out.println("||--------------Bebidas disponíveis: --------------||");
        System.out.println("||--------------1. Refrigerante - R$8.00 ----------||");
        System.out.println("||--------------2. Suco - R$6.00 ------------------||");
        System.out.println("||--------------Escolha uma bebida:  --------------||");

        int opcao = Integer.parseInt(scanner.nextLine());

        switch (opcao) {
            case 1:
                System.out.print("Quantidade: ");
                int quantidade = Integer.parseInt(scanner.nextLine());
                carrinho.adicionarItem("Refrigerante", quantidade);
                break;
            case 2:
                System.out.print("Quantidade: ");
                quantidade = Integer.parseInt(scanner.nextLine());
                carrinho.adicionarItem("Suco", quantidade);
                break;
            default:
                System.out.println("Opção inválida, tente novamente.");
        }
    }
}
