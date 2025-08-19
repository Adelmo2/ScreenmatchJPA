//3 - Implemente um método que recebe uma String representando um nome completo separado por espaços.
//O método deve retornar o primeiro e o último nome após remover os espaços desnecessários.

package br.com.alura.screenmatch.desafio.primeiroEUltimoNome_3;

public class main {
    public static void main(String[] args) {
        System.out.println(obterPrimeiraoEUltimoNome(" Joao Carlos Silva "));
        System.out.println(obterPrimeiraoEUltimoNome("Maria "));
    }

    public static String obterPrimeiraoEUltimoNome(String nomeCompleto) {
        String[] nomes = nomeCompleto.trim().split("\\s+");

        if (nomes.length == 1) {
            return nomes[0]; //Apenas um nome
        }
        return nomes[0] + " " + nomes[nomes.length - 1]; //Primeiro e ultimo nome
    }

}
