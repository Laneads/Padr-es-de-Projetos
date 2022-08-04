package PadroesdeProjeto.src.Facade;

import PadroesdeProjeto.src.SubSistcep.CepAPI;
import PadroesdeProjeto.src.SubSistcrm.Serviço;

public class Facade {

     public void migrarCliente (String nome, String cep){
        String cidade = CepAPI.getInstancia().pegarCidade(cep);
        String estado = CepAPI.getInstancia().pegarEstado(cep);

        Serviço.gravarCliente(nome, cep, cidade, estado);
     }
}
