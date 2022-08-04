package PadroesdeProjeto.src.SubSistcep;

public class CepAPI {

    private static CepAPI instancia = new CepAPI();

    private CepAPI (){
        super();
    }

    public static CepAPI getInstancia() {
        return instancia;
    }

    public String pegarCidade(String cep) {
        return "Salvador";
    }

    public String pegarEstado(String cep){
        return "BA";
    }

    
}