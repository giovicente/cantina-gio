package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.Impressora;

import java.util.ArrayList;
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
        for (int i = 0; i < refeicoes.size(); i++) {
            if (refeicoes.get(i).getNome().equals(nome) &&
                    (refeicoes.get(i).getTipoRefeicao().toString().equals("COMIDA") ||
                            refeicoes.get(i).getTipoRefeicao().toString().equals("LANCHE"))) {
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
}
