package entities;

import enums.TipoRefeicaoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.Impressora;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cardapio {

    private List<Refeicao> refeicoes = new ArrayList<>();

    public Refeicao inserirRefeicao(Refeicao refeicao) {
        refeicoes.add(refeicao);
        return refeicao;
    }

    public Refeicao obterRefeicao(String nome) {
        final String TIPO_REFEICAO_COMIDA = "COMIDA";
        final String TIPO_REFEICAO_LANCHE = "LANCHE";

        for (int i = 0; i < refeicoes.size(); i++) {
            if (refeicoes.get(i).getNome().equals(nome) &&
                    (refeicoes.get(i).getTipoRefeicao().toString().equals(TIPO_REFEICAO_COMIDA) ||
                            refeicoes.get(i).getTipoRefeicao().toString().equals(TIPO_REFEICAO_LANCHE))) {
                return refeicoes.get(i);
            }
        }

        Impressora.imprimirMensagemItemNaoEncontradoCardapio();
        return null;
    }

    public Refeicao obterBebida(String nome) {
        for (int i = 0; i < refeicoes.size(); i++) {
            if (refeicoes.get(i).getNome().equals(nome) && refeicoes.get(i).getTipoRefeicao().toString().equals("BEBIDA")) {
                return refeicoes.get(i);
            }
        }

        Impressora.imprimirMensagemTipoInvalidoBebida();
        return null;
    }

    public Refeicao obterEntrada(String nome) {
        for (int i = 0; i < refeicoes.size(); i++) {
            if (refeicoes.get(i).getNome().equals(nome) && refeicoes.get(i).getTipoRefeicao().toString().equals("ENTRADA")) {
                return refeicoes.get(i);
            }
        }

        Impressora.imprimirMensagemTipoInvalidoEntrada();
        return null;
    }

    public Refeicao obterSobremesa(String nome) {
        for (int i = 0; i < refeicoes.size(); i++) {
            if (refeicoes.get(i).getNome().equals(nome) && refeicoes.get(i).getTipoRefeicao().toString().equals("SOBREMESA")) {
                return refeicoes.get(i);
            }
        }

        Impressora.imprimirMensagemTipoInvalidoSobremesa();
        return null;
    }

    public static List<Refeicao> montaCardapio() {
        return Arrays.asList(
                new Refeicao(TipoRefeicaoEnum.ENTRADA, "Carpaccio", 35.0),
                new Refeicao(TipoRefeicaoEnum.ENTRADA, "Bruschetta", 25.0),
                new Refeicao(TipoRefeicaoEnum.ENTRADA, "Antepasto", 20.0),

                new Refeicao(TipoRefeicaoEnum.COMIDA, "Pasta", 30.0),
                new Refeicao(TipoRefeicaoEnum.COMIDA, "Lasanha", 70.0),
                new Refeicao(TipoRefeicaoEnum.COMIDA, "Polpetone", 50.0),

                new Refeicao(TipoRefeicaoEnum.LANCHE, "Burguer", 30.0),
                new Refeicao(TipoRefeicaoEnum.LANCHE, "Pizza", 45.0),
                new Refeicao(TipoRefeicaoEnum.LANCHE, "Fogazza", 20.0),

                new Refeicao(TipoRefeicaoEnum.BEBIDA, "Refrigerante", 5.0),
                new Refeicao(TipoRefeicaoEnum.BEBIDA, "Agua", 5.0),
                new Refeicao(TipoRefeicaoEnum.BEBIDA, "Suco", 5.0),
                new Refeicao(TipoRefeicaoEnum.BEBIDA, "H2O", 5.0),

                new Refeicao(TipoRefeicaoEnum.SOBREMESA, "Cannoli", 25.0),
                new Refeicao(TipoRefeicaoEnum.SOBREMESA, "Sorvete", 15.0),
                new Refeicao(TipoRefeicaoEnum.SOBREMESA, "Tiramisu", 30.0)
        );
    }
}
