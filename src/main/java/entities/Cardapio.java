package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
            if (refeicoes.get(i).getNome().equals(nome)) {
                return refeicoes.get(i);
            }
        }

        return null;
    }
}
