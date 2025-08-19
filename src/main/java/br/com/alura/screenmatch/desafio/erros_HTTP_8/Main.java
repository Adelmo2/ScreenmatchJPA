
//8 - Crie um enum CodigoErro com valores de erros HTTP, como NOT_FOUND, BAD_REQUEST, INTERNAL_SERVER_ERROR.
// Cada valor deve ter um código numérico e uma descrição associados. Adicione métodos para acessar o código
// e a descrição. Dica: consulte o site https://http.cat/ para conhecer os vários erros HTTP e conseguir descrevê-los melhor.


package br.com.alura.screenmatch.desafio.erros_HTTP_8;

public class Main {
    public static void main(String[] args) {
        System.out.println(CodigoErro.NOT_FOUND.getCodigo()); // 404
        System.out.println(CodigoErro.BAD_REQUEST.getDescricao()); // Requisição inválida
        System.out.println(CodigoErro.INTERNAL_SERVER_ERROR.getCodigo()); // 404
        System.out.println(CodigoErro.INTERNAL_SERVER_ERROR.getDescricao());
    }
}
