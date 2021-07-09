package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    private List<Refeicao> pedido;
    private double valorTotal;

    public boolean continuarPedido(String continuacao) {
        if (continuacao.equalsIgnoreCase("S")) return true;

        return false;
    }

    public double calculaValorTotal(List<Refeicao> pedido) {
        double valorTotal = 0;

        for (int i =0; i < pedido.size(); i++) {
            valorTotal += pedido.get(i).getPreco();
        }

        return valorTotal;
    }
}
