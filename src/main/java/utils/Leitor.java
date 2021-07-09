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

    public String lerPedido() {
        Scanner scanNome = new Scanner(System.in);
        Impressora.imprimirMensagemNome();
        String nome = scanNome.next();

        return nome;
    }

    public String lerContinuacao() {
        Scanner scanContinuacao = new Scanner(System.in);
        Impressora.imprimirMensagemContinuacao();
        String continuacao = scanContinuacao.next();

        if (!continuacao.equalsIgnoreCase("S") && !continuacao.equalsIgnoreCase("N")) {
            throw new IllegalArgumentException("Digitar somente 'S' ou 'N'");
        }

        return continuacao;
    }

    public String lerBebida() {
        Scanner scanBebida = new Scanner(System.in);
        Impressora.imprimirMensagemBebida();
        String nome = scanBebida.next();

        return nome;
    }

    public String lerDesejoBebida() {
        Scanner scanDesejoBebida = new Scanner(System.in);
        Impressora.imprimirMensagemDesejoBebida();
        String desejoBebida = scanDesejoBebida.next();

        if (!desejoBebida.equalsIgnoreCase("S") && !desejoBebida.equalsIgnoreCase("N")) {
            throw new IllegalArgumentException("Digitar somente 'S' ou 'N'");
        }

        return desejoBebida;
    }

    public String lerContinuacaoBebida() {
        Scanner scanContinuacaoBebida = new Scanner(System.in);
        Impressora.imprimirMensagemContinuacaoBebida();
        String continuacaoBebida = scanContinuacaoBebida.next();

        if (!continuacaoBebida.equalsIgnoreCase("S") && !continuacaoBebida.equalsIgnoreCase("N")) {
            throw new IllegalArgumentException("Digitar somente 'S' ou 'N'");
        }

        return continuacaoBebida;
    }
}
