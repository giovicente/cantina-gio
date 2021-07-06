package utils;

import entities.Refeicao;

public class Impressora {

    public static void imprimirMensagemTipoRefeicao() { System.out.println("Insira o tipo de Refeição - COMIDA ou LANCHE: ");}

    public static void imprimirMensagemNome() { System.out.println("Insira o nome do prato: "); }

    public static void imprimirMensagemValor() { System.out.println("Insira o valor do prato: "); }

    public static void imprimirCardapio(Refeicao refeicao) {
        System.out.println(refeicao.getTipoRefeicao());
        System.out.println(refeicao.getNome());
        System.out.println(refeicao.getPreco());
        System.out.println("=======================");
    }

    public static void escreverMenuPrincipal() {
        System.out.println("**** Seja bem-vindo ao Gio's Cantina ****");
        System.out.println("Selecione a opção desejada:");
        System.out.println("0 - Cadastrar Refeição");
        System.out.println("1 - Consultar Cardápio");
        System.out.println("9 - Sair");
    }
}
