package utils;

import entities.Cardapio;
import entities.Pedido;
import entities.Refeicao;

import java.util.ArrayList;
import java.util.List;

public class MenuPrincipal {

    public static void montarMenuPrincipal() {
        Cardapio cardapio = new Cardapio();
        Leitor leitor = new Leitor();
        Pedido pedido = new Pedido();
        List<Refeicao> itensPedidos = new ArrayList<>();
        int opcao = -1;

        while (true) {
            Impressora.imprimirMenuPrincipal();
            opcao = leitor.inserirOpcaoMenu();

            switch (opcao) {
                case 0:
                    Refeicao refeicao = leitor.lerDadosRefeicao();
                    cardapio.inserirRefeicao(refeicao);
                    break;
                case 1:
                    for (int i = 0; i < cardapio.getRefeicoes().size(); i++) {
                        Impressora.imprimirCardapio(cardapio.getRefeicoes().get(i));
                    }
                    break;
                case 2:
                    String continuacao =  "S";

                    while (pedido.continuarPedido(continuacao)) {
                        String nome = leitor.lerPedido();
                        Refeicao refeicaoPedido = cardapio.obterRefeicao(nome);
                        itensPedidos.add(refeicaoPedido);

                        continuacao = leitor.lerContinuacao();
                    }

                    pedido.setPedido(itensPedidos);
                    pedido.setValorTotal(pedido.calculaValorTotal(pedido.getPedido()));
                    Impressora.imprimirMensagemConclusaoPedido(pedido);
                    break;
                case 9:
                    System.exit(0);
            }
        }
    }
}
