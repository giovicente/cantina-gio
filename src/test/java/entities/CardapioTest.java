package entities;

import enums.TipoRefeicaoEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CardapioTest {

    private List<Refeicao> itensCardapio;
    private Cardapio cardapio;

    @BeforeEach
    public void setUp() {
        cardapio = new Cardapio();
        itensCardapio = Arrays.asList(
                new Refeicao(TipoRefeicaoEnum.COMIDA, "Pasta", 30.0),
                new Refeicao(TipoRefeicaoEnum.COMIDA, "Lasanha", 70.0),
                new Refeicao(TipoRefeicaoEnum.COMIDA, "Polpetone", 50.0),

                new Refeicao(TipoRefeicaoEnum.LANCHE, "Burguer", 30.0),
                new Refeicao(TipoRefeicaoEnum.LANCHE, "Pizza", 45.0),
                new Refeicao(TipoRefeicaoEnum.LANCHE, "Fogazza", 20.0),

                new Refeicao(TipoRefeicaoEnum.BEBIDA, "Refrigerante", 5.0),
                new Refeicao(TipoRefeicaoEnum.BEBIDA, "Agua", 5.0),
                new Refeicao(TipoRefeicaoEnum.BEBIDA, "Suco", 5.0),
                new Refeicao(TipoRefeicaoEnum.BEBIDA, "H2O", 5.0)
        );
        cardapio.setRefeicoes(itensCardapio);
    }

    @Test
    public void adicionarRefeicao() {
        Cardapio cardapioAssert = new Cardapio();
        TipoRefeicaoEnum tipoRefeicaoEnum = TipoRefeicaoEnum.valueOf("COMIDA");
        Refeicao refeicao = new Refeicao(tipoRefeicaoEnum, "Pasta", 30);

        Refeicao refeicaoResponse = cardapioAssert.inserirRefeicao(refeicao);
        Assertions.assertEquals(refeicao, refeicaoResponse);
    }

    @Test
    public void consultarRefeicaoSucesso() {
        Refeicao refeicaoExpected = new Refeicao(TipoRefeicaoEnum.LANCHE, "Fogazza", 20.0);

        String nome = "Fogazza";
        Refeicao refeicaoResponse = cardapio.obterRefeicao(nome);

        Assertions.assertEquals(refeicaoExpected, refeicaoResponse);
    }

    @Test
    public void consultarRefeicaoFalha() {
        String nome = "Arroz";
        Refeicao refeicaoResponse = cardapio.obterRefeicao(nome);

        Assertions.assertEquals(null, refeicaoResponse);
    }

    @Test
    public void consultarBebidaSucesso() {
        Refeicao refeicaoExpected = new Refeicao(TipoRefeicaoEnum.BEBIDA, "Refrigerante", 5.0);

        String nome = "Refrigerante";
        Refeicao refeicaoResponse = cardapio.obterBebida(nome);

        Assertions.assertEquals(refeicaoExpected, refeicaoResponse);
    }

    @Test
    public void consultarBebidaFalha() {
        String nome = "Whisky";
        Refeicao refeicaoResponse = cardapio.obterBebida(nome);

        Assertions.assertEquals(null, refeicaoResponse);
    }

}
