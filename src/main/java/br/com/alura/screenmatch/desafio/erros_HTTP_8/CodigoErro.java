package br.com.alura.screenmatch.desafio.erros_HTTP_8;
//**--ASR
//public enum CodigoErro {
//    NOT_FOUND(404),
//    BAD_REQUEST(501),
//    INTERNAL_SERVER_ERROR(505);
//
//    public int Codigo;
//    public String Descricao;
//
//    CodigoErro(int iCodigo) {
//        this.Codigo = iCodigo;
//    }
//
//    public int getCodigo() {
//        return Codigo;
//    }
//
//    public String getDescricao() {
//        if (Descricao == null) {
//            return "Requisição inválida";
//        } else {
//            return Descricao;
//        }
//    }
//}

//**INSTRUTOR
public enum CodigoErro {
    NOT_FOUND(404, "Recurso não encontrado"),
    BAD_REQUEST(400, "Requisição inválida"),
    INTERNAL_SERVER_ERROR(500, "Erro interno do servidor");

    private final int codigo;
    private final String descricao;

    CodigoErro(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}


