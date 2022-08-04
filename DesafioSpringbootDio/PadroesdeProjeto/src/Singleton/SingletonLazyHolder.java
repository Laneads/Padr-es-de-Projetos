package PadroesdeProjeto.src.Singleton;

public class SingletonLazyHolder {
    
    private static class InstaciaHolder {
        public static SingletonLazyHolder instancia = new SingletonLazyHolder();
    }

    private SingletonLazyHolder(){
        super();
    }

    public static SingletonLazyHolder getInstancia (){
        return InstaciaHolder.instancia;
    }
}
