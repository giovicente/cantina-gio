package utils;

import enums.TipoRefeicaoEnum;
import entities.Refeicao;

import java.util.Scanner;

public class Leitor {

    public Refeicao lerDadosRefeicao() {
        Scanner scanTipo = new Scanner(System.in);
        Scanner scanNome = new Scanner(System.in);
        Scanner scanPreco = new Scanner(System.in);

        Impressora.imprimirMensagemTipoRefeicao();
        String tipoRefeicao = scanTipo.next();
        TipoRefeicaoEnum tipoRefeicaoEnum = TipoRefeicaoEnum.valueOf(tipoRefeicao);

        Impressora.imprimirMensagemNome();
        String nome = scanNome.next();

        Impressora.imprimirMensagemValor();
        double preco = scanPreco.nextDouble();

        Refeicao refeicaoRetorno = new Refeicao(tipoRefeicaoEnum, nome, preco);

        return refeicaoRetorno;
    }

    public int inserirOpcaoMenu() {
        Scanner scanOpcao = new Scanner(System.in);
        int opcao = scanOpcao.nextInt();

        return opcao;
    }
}
