package utils;

import entities.Cardapio;
import entities.Pedido;
import entities.Refeicao;
import enums.TipoRefeicaoEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuPrincipal {

    public static void montarMenuPrincipal() {
        Cardapio cardapio = new Cardapio();
        Leitor leitor = new Leitor();
        Pedido pedido = new Pedido();

        /*
        * Instanciando os itens do cardápio hardcoded para acelerar sua criação
        * Desta forma não é preciso ficar carregando o cardápio a cada execução via opção 0
        */
        List<Refeicao> itensCardapio = Arrays.asList(
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
                new Refeicao(TipoRefeicaoEnum.ENTRADA, "Sorvete", 15.0),
                new Refeicao(TipoRefeicaoEnum.ENTRADA, "Tiramisu", 30.0)
        );
        cardapio.setRefeicoes(itensCardapio);

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
                    String continuacao = "S";

                    String continuacaoEntrada = leitor.lerDesejo(TipoRefeicaoEnum.ENTRADA);
                    while (pedido.continuarPedido(continuacaoEntrada)) {
                        String nome = leitor.lerRefeicao(TipoRefeicaoEnum.ENTRADA);
                        Refeicao refeicaoPedido = cardapio.obterEntrada(nome);
                        itensPedidos.add(refeicaoPedido);

                        continuacaoEntrada = leitor.lerContinuacao();
                    }

                    while (pedido.continuarPedido(continuacao)) {
                        String nome = leitor.lerRefeicao(TipoRefeicaoEnum.COMIDA);
                        Refeicao refeicaoPedido = cardapio.obterRefeicao(nome);
                        itensPedidos.add(refeicaoPedido);

                        continuacao = leitor.lerContinuacao();
                    }

                    String continuacaoBebida = leitor.lerDesejo(TipoRefeicaoEnum.BEBIDA);
                    while (pedido.continuarPedido(continuacaoBebida)) {
                        String nome = leitor.lerRefeicao(TipoRefeicaoEnum.BEBIDA);
                        Refeicao bebidaRefeicao = cardapio.obterBebida(nome);
                        itensPedidos.add(bebidaRefeicao);

                        continuacaoBebida = leitor.lerContinuacao();
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
