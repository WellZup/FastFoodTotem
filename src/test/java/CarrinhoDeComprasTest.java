

import model.CarrinhoDeCompras;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarrinhoDeComprasTest {
    private CarrinhoDeCompras carrinho;

    @BeforeEach
    public void setup() {
        carrinho = new CarrinhoDeCompras();
    }

    @Test
    public void testAdicionarItem() {
        carrinho.adicionarItem("X-burger", 2);
        carrinho.adicionarItem("Refrigerante", 3);

        Assertions.assertEquals(2, carrinho.getItens().get("X-burger"));
        Assertions.assertEquals(3, carrinho.getItens().get("Refrigerante"));
    }

    @Test
    public void testRemoverItem() {
        carrinho.adicionarItem("X-burger", 2);
        carrinho.adicionarItem("Refrigerante", 3);

        carrinho.removerItem("X-burger");

        Assertions.assertNull(carrinho.getItens().get("X-burger"));
        Assertions.assertEquals(3, carrinho.getItens().get("Refrigerante"));
    }

    @Test
    public void testEditarQuantidadeItem() {
        carrinho.adicionarItem("X-burger", 2);

        carrinho.getItens().put("X-burger", 5);

        Assertions.assertEquals(5, carrinho.getItens().get("X-burger"));
    }

    @Test
    public void testCalcularTotal() {
        carrinho.adicionarItem("X-burger", 2);
        carrinho.adicionarItem("Refrigerante", 3);

        double totalEsperado = 2 * 10.0 + 3 * 8.0;
        Assertions.assertEquals(totalEsperado, carrinho.calcularTotal());
    }
}

