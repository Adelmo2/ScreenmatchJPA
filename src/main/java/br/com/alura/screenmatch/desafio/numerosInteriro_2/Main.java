//2 - Implemente um método que recebe um número inteiro dentro de um Optional.
 //   Se o número estiver presente e for positivo, calcule seu quadrado. Caso contrário, retorne Optional.empty.

package br.com.alura.screenmatch.desafio.numerosInteriro_2;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println(processaNumero(Optional.of(5))); // Saída: Optional[25]
        System.out.println(processaNumero(Optional.of(-3))); // Saída: Optional.empty
        System.out.println(processaNumero(Optional.empty())); // Saída: Optional.empty


    }

    public static Optional<Integer> processaNumero(Optional<Integer> numero) {
        // Implementar aqui
        return numero.filter(n -> n > 0).map(n -> n * n);
    }
}

