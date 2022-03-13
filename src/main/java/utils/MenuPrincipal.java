package utils;

import entities.Cardapio;
import entities.Pedido;
import entities.Refeicao;
import enums.TipoRefeicaoEnum;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class MenuPrincipal {

    public static void montarMenuPrincipal() {
        Cardapio cardapio = new Cardapio();
        Leitor leitor = new Leitor();
        Pedido pedido = new Pedido();

        final int STATUS_CODE_CONCLUIDO_COM_SUCESSO = 0;

        List<Refeicao> itensCardapio = Cardapio.montaCardapio();
        cardapio.setRefeicoes(itensCardapio);

        List<Refeicao> itensPedidos = new ArrayList<>();
        int opcao = -1;

        while (true) {
            Impressora.imprimirMenuPrincipal();

            try {
                opcao = leitor.inserirOpcaoMenu();
            } catch (InputMismatchException e) {
                Impressora.imprimirMensagemValorInvalidoMenu();
                MenuPrincipal.montarMenuPrincipal();
            }

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
                    int tentativas;

                    String continuacaoEntrada = leitor.lerDesejo(TipoRefeicaoEnum.ENTRADA);
                    while (pedido.continuarPedido(continuacaoEntrada)) {
                        Refeicao refeicaoPedido;
                        tentativas = 0;

                        do {
                            String nome = leitor.lerRefeicao(TipoRefeicaoEnum.ENTRADA);
                            refeicaoPedido = cardapio.obterEntrada(nome);
                            if (refeicaoPedido == null) tentativas++;

                            verificaTentativas(tentativas);
                        } while (refeicaoPedido == null);

                        itensPedidos.add(refeicaoPedido);
                        continuacaoEntrada = leitor.lerContinuacao();
                    }

                    while (pedido.continuarPedido(continuacao)) {
                        Refeicao refeicaoPedido;
                        tentativas = 0;

                        do {
                            String nome = leitor.lerRefeicao(TipoRefeicaoEnum.COMIDA);
                            refeicaoPedido = cardapio.obterRefeicao(nome);
                            if (refeicaoPedido == null) tentativas++;

                            verificaTentativas(tentativas);
                        } while (refeicaoPedido == null);

                        itensPedidos.add(refeicaoPedido);
                        continuacao = leitor.lerContinuacao();
                    }

                    String continuacaoBebida = leitor.lerDesejo(TipoRefeicaoEnum.BEBIDA);
                    while (pedido.continuarPedido(continuacaoBebida)) {
                        Refeicao bebidaRefeicao;
                        tentativas = 0;

                        do {
                            String nome = leitor.lerRefeicao(TipoRefeicaoEnum.BEBIDA);
                            bebidaRefeicao = cardapio.obterBebida(nome);
                            if (bebidaRefeicao == null) tentativas++;

                            verificaTentativas(tentativas);
                        } while (bebidaRefeicao == null);

                        itensPedidos.add(bebidaRefeicao);
                        continuacaoBebida = leitor.lerContinuacao();
                    }

                    String continuacaoSobremesa = leitor.lerDesejo(TipoRefeicaoEnum.SOBREMESA);
                    while (pedido.continuarPedido(continuacaoSobremesa)) {
                        Refeicao sobremesaRefeicao;
                        tentativas = 0;

                        do {
                            String nome = leitor.lerRefeicao(TipoRefeicaoEnum.SOBREMESA);
                            sobremesaRefeicao = cardapio.obterSobremesa(nome);
                            if (sobremesaRefeicao == null) tentativas++;

                            verificaTentativas(tentativas);
                        } while (sobremesaRefeicao == null);

                        itensPedidos.add(sobremesaRefeicao);
                        continuacaoSobremesa = leitor.lerContinuacao();
                    }

                    pedido.setItens(itensPedidos);
                    pedido.setValorTotal(pedido.calculaValorTotal(pedido.getItens()));
                    Impressora.imprimirMensagemConclusaoPedido(pedido);
                    break;
                case 9:
                    System.exit(STATUS_CODE_CONCLUIDO_COM_SUCESSO);
                default:
                    Impressora.imprimirMensagemValorInvalidoMenu();
            }
        }
    }

    private static void verificaTentativas(int tentativas) {
        final int NUMERO_ALERTA_ULTIMA_TENTATIVA = 2;
        final int NUMERO_MAXIMO_TENTATIVAS = 3;

        if (tentativas == NUMERO_ALERTA_ULTIMA_TENTATIVA) {
            Impressora.imprimirMensagemUltimaTentativaPedido();
        } else if (tentativas == NUMERO_MAXIMO_TENTATIVAS) {
            Impressora.imprimirMensagemPedidoExpirado();
            montarMenuPrincipal();
        }
    }
}
