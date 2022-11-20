package entities;

import enums.TipoRefeicaoEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Refeicao {

    private TipoRefeicaoEnum tipoRefeicao;
    private String nome;
    private double preco;

}
