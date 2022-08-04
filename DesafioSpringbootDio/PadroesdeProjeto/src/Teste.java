package PadroesdeProjeto.src;
import PadroesdeProjeto.src.Facade.Facade;
import PadroesdeProjeto.src.Singleton.SingletonEager;
import PadroesdeProjeto.src.Singleton.SingletonLazy;
import PadroesdeProjeto.src.Singleton.SingletonLazyHolder;
import PadroesdeProjeto.src.Strategy.Comportamento;
import PadroesdeProjeto.src.Strategy.ComportamentoAgressivo;
import PadroesdeProjeto.src.Strategy.ComportamentoDefensivo;
import PadroesdeProjeto.src.Strategy.ComportamentoNormal;
import PadroesdeProjeto.src.Strategy.Robo;

public class Teste {

    public static void main(String[] args) {
        
        //Testes Singleton: Padrão Criacional
        SingletonLazy lento = SingletonLazy.getInstancia();
        System.out.println(lento);
        lento = SingletonLazy.getInstancia();
        System.out.println(lento);

        SingletonEager rapido = SingletonEager.getInstancia();
        System.out.println(rapido);
        rapido = SingletonEager.getInstancia();
        System.out.println(rapido);

        SingletonLazyHolder encapsulado = SingletonLazyHolder.getInstancia();
        System.out.println(encapsulado);
        encapsulado = SingletonLazyHolder.getInstancia();
        System.out.println(encapsulado);

        System.out.println("________________________________\n");

        //Testes Strategy: Padrão Comportamental
        Comportamento normal = new ComportamentoNormal();
        Comportamento defensivo = new ComportamentoDefensivo();
        Comportamento agressivo = new ComportamentoAgressivo();

        Robo robo = new Robo ();
        robo.setComportamento(defensivo);
        
        robo.mover();
        robo.mover();

        robo.setComportamento(normal);
        robo.mover();

        robo.setComportamento(agressivo);
        robo.mover();

        System.out.println("________________________________\n");

        //Testes Facade: Padrão Estrutural
        Facade facade = new Facade();
        facade.migrarCliente("Liz", "54256 154");
    }
           
}
