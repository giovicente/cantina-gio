package utils;

import entities.Cardapio;
import entities.Refeicao;

public class MenuPrincipal {

    public static void montarMenuPrincipal() {
        Cardapio cardapio = new Cardapio();
        Leitor leitor = new Leitor();
        int opcao = -1;

        while (true) {
            Impressora.escreverMenuPrincipal();
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
                case 9:
                    System.exit(0);
            }
        }
    }
}
