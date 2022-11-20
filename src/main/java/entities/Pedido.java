package entities;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    private List<Refeicao> itens;
    private double valorTotal;

    public boolean continuarPedido(String continuacao) {
        return continuacao.equalsIgnoreCase("S");
    }

    public double calculaValorTotal(List<Refeicao> itens) {
        double valorTotal = 0;

        for (int i = 0; i < itens.size(); i++) {
            valorTotal += itens.get(i).getPreco();
        }

        return valorTotal;
    }
}
