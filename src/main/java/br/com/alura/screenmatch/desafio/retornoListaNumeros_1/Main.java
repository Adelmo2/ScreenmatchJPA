//1 - Imagine que você tem uma lista de strings. Algumas das strings são números, mas outras não.
//        Queremos converter a lista de strings para uma lista de números. Se a conversão falhar,
//        você deve ignorar o valor. Por exemplo, na lista a seguir, a saída deve ser [10, 20]:

package br.com.alura.screenmatch.desafio.retornoListaNumeros_1;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("10", "abc", "20", "30x");

        //cd. instrutor - var listaSoNumero = input.stream() .map(str -> { try { return Optional.of(Integer.parseInt(str)); } catch (NumberFormatException e) { return Optional.<Integer>empty(); } }) .filter(Optional::isPresent) .map(Optional::get) .toList();
        //ou
        var listaSoNumero = input.stream()
                .map(str -> {
                    try {
                        return Optional.of(Integer.parseInt(str));
                    } catch (NumberFormatException e) {
                        return Optional.<Integer>empty();
                    }
                })
                .filter(Optional::isPresent).map(Optional::get).toList();

        System.out.println(listaSoNumero);
    }
}