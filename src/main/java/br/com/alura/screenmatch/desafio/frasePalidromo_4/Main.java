//4 - Implemente um método que verifica se uma frase é um palíndromo.
//Um palíndromo é uma palavra/frase que, quando lida de trás pra frente, é igual à leitura normal. Um exemplo:

package br.com.alura.screenmatch.desafio.frasePalidromo_4;

public class Main {
    public static void main(String[] args) {
        System.out.println(ehPalindromo("socorram me subi no onibus em marrocos")); // Saída: true
        System.out.println(ehPalindromo("java")); //false
        System.out.println(ehPalindromo("socorram marrocos"));
    }
    public static boolean ehPalindromo(String palavra) {
        String semEspacos = palavra.replace(" ","").toLowerCase();
        return new StringBuilder(semEspacos).reverse().toString().equalsIgnoreCase(semEspacos);
    }
}
