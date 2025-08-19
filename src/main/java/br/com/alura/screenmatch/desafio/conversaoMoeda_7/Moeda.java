//7 - Crie um enum Moeda com valores como DOLAR, EURO, REAL.
// Cada moeda deve ter uma taxa de conversão para reais.
// Adicione um método que recebe um valor em reais e retorna o valor convertido para a moeda.

package br.com.alura.screenmatch.desafio.conversaoMoeda_7;

public enum Moeda {
    DOLAR(5.10),
    EURO(5.50),
    REAL(1);

    private double taxa;

    Moeda(double taxa) {
        this.taxa = taxa;
    }

    public double converterPara(double valorEmReais) {
        return valorEmReais / taxa;
        // Implementar aqui
    }
}
