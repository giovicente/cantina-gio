import entities.Pedido;
import entities.Refeicao;
import enums.TipoRefeicaoEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PedidoTest {

    private List<Refeicao> itensPedidos;
    private Pedido pedido;

    @BeforeEach
    public void setUp() {
        itensPedidos = Arrays.asList(
            new Refeicao(TipoRefeicaoEnum.COMIDA, "Pasta", 30.0),
            new Refeicao(TipoRefeicaoEnum.COMIDA, "Lasanha", 70.0),
            new Refeicao(TipoRefeicaoEnum.COMIDA, "Polpetone", 50.0)
        );

        pedido = new Pedido();
    }

    @Test
    public void testarCalculoValorTotal() {
        final double VALOR_TOTAL_ESPERADO = 150.0d;
        double valorTotal = pedido.calculaValorTotal(itensPedidos);
        Assertions.assertEquals(VALOR_TOTAL_ESPERADO, valorTotal);
    }

}
