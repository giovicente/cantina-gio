package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
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
