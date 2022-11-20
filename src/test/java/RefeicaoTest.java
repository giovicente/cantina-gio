import enums.TipoRefeicaoEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RefeicaoTest {

    @Test
    public void testarTipoRefeicaoValido() {
        TipoRefeicaoEnum tipoRefeicaoExpected = TipoRefeicaoEnum.ENTRADA;
        String tipoRefeicao = TipoRefeicaoEnum.ENTRADA.toString();

        Assertions.assertEquals(tipoRefeicaoExpected.toString(), tipoRefeicao);
    }

    @Test
    public void testarTipoRefeicaoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TipoRefeicaoEnum tipoRefeicaoEnum = TipoRefeicaoEnum.valueOf("GUARNICAO");
        });
    }
}
