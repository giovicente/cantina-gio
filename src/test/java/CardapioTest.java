import entities.Cardapio;
import entities.Refeicao;
import enums.TipoRefeicaoEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardapioTest {

    @Test
    public void adicionarRefeicao() {
        Cardapio cardapio = new Cardapio();
        TipoRefeicaoEnum tipoRefeicaoEnum = TipoRefeicaoEnum.valueOf("COMIDA");
        Refeicao refeicao = new Refeicao(tipoRefeicaoEnum, "Pasta", 30);

        Refeicao refeicaoResponse = cardapio.inserirRefeicao(refeicao);
        Assertions.assertEquals(refeicao, refeicaoResponse);
    }

}
