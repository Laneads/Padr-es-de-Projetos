package PadroesdeProjeto.src.SubSistcrm;

public class Serviço {
    
    private Serviço (){
        super();
    }

    public static void gravarCliente(String nome, String cep, String cidade, String estado){
        System.out.println("Cliente salvo com sucesso no sistema!!");
        
        System.out.println(nome);
        System.out.println(cep);
        System.out.println(cidade);
        System.out.println(estado);
    } 
}
