//6 - Crie um enum Mes que represente os meses do ano.
// Adicione um método que retorna o número de dias de cada mês, considerando anos não bissextos

package br.com.alura.screenmatch.desafio.enumMes_6;

public class Main {
    public static void main(String[] args) {
        System.out.println(Mes.FEVEREIRO.getNumeroDeDias());
        System.out.println(Mes.JULHO.getNumeroDeDias());
        System.out.println(Mes.JUNHO.getNumeroDeDias());
    }
}
