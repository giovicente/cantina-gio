package utils;

import entities.Refeicao;
import enums.TipoRefeicaoEnum;

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

    public String lerRefeicao(TipoRefeicaoEnum tipoRefeicaoEnum) {
        Scanner scanRefeicao = new Scanner(System.in);

        if (tipoRefeicaoEnum.equals(TipoRefeicaoEnum.ENTRADA)) {
            Impressora.imprimirMensagemEntrada();
        } else if (tipoRefeicaoEnum.equals(TipoRefeicaoEnum.COMIDA) || tipoRefeicaoEnum.equals(TipoRefeicaoEnum.LANCHE)) {
            Impressora.imprimirMensagemNome();
        } else if (tipoRefeicaoEnum.equals(TipoRefeicaoEnum.BEBIDA)) {
            Impressora.imprimirMensagemBebida();
        } else {
            Impressora.imprimirMensagemSobremesa();
        }

        String nome = scanRefeicao.next();
        return nome;
    }

    public String lerContinuacao() {
        Scanner scanContinuacao = new Scanner(System.in);
        String continuacao = "";

        while (!validarInputCondicionais(continuacao)) {
            Impressora.imprimirMensagemContinuacao();
            continuacao = scanContinuacao.next();
        }

        return continuacao;
    }

    public String lerDesejo(TipoRefeicaoEnum tipoRefeicaoEnum) {
        Scanner scanDesejo = new Scanner(System.in);
        String desejo = "";

        while (!validarInputCondicionais(desejo)) {
            if (tipoRefeicaoEnum.equals(TipoRefeicaoEnum.ENTRADA)) {
                Impressora.imprimirMensagemDesejoEntrada();
            } else if (tipoRefeicaoEnum.equals(TipoRefeicaoEnum.BEBIDA)) {
                Impressora.imprimirMensagemDesejoBebida();
            } else {
                Impressora.imprimirMensagemDesejoSobremesa();
            }

            desejo = scanDesejo.next();
        }

        return desejo;
    }

    public boolean validarInputCondicionais(String opcaoDigitada) {

        return opcaoDigitada.equalsIgnoreCase("S") || opcaoDigitada.equalsIgnoreCase("N");
    }
}
