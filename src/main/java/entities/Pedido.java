package entities;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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
        AtomicReference<Double> valorTotal = new AtomicReference<>((double) 0);
        this.valorTotal = 0.0d;

//      itens.forEach((itemRefeicao) ->
//              valorTotal.updateAndGet(v -> (double) (v + itemRefeicao.getPreco())));

//      return valorTotal.get();

        for (int i = 0; i < itens.size(); i++) { this.valorTotal += itens.get(i).getPreco(); }

        return this.valorTotal;
    }
}
