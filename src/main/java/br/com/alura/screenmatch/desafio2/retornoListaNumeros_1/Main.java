package br.com.alura.screenmatch.desafio2.retornoListaNumeros_1;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("10", "abc", "20", "30x");

        var listaSoNumero = input.stream()
                .map(n -> {
                    try {
                        return Optional.of(Integer.parseInt(n));
                    } catch (NumberFormatException e) {
                        return Optional.empty();
                    }
                })
                .filter(Optional::isPresent).map(Optional::get).toList();
        System.out.println(listaSoNumero);
    }
}

