package entities;

import enums.TipoRefeicaoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Refeicao {

    private TipoRefeicaoEnum tipoRefeicao;
    private String nome;
    private double preco;

}
