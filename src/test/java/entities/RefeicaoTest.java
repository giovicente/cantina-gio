package entities;

import entities.Refeicao;
import enums.TipoRefeicaoEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RefeicaoTest {

    @Test
    public void testarTipoRefeicaoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TipoRefeicaoEnum tipoRefeicaoEnum = TipoRefeicaoEnum.valueOf("GUARNICAO");
        });
    }
}
