package br.com.alura.screenmatch.desafio.conversaoMoeda_7;

public class Main {
    public static void main(String[] args) {
        System.out.println(Moeda.DOLAR.converterPara(100)); // 19.60 (aproximado)
        System.out.println(Moeda.EURO.converterPara(100)); // 18.18 (aproximado)
        System.out.println(Moeda.REAL.converterPara(100));
    }
}
