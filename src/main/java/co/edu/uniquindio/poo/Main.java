package co.edu.uniquindio.poo;

public class Main {
    public static void main(String[] args) {
        Arbol<Integer> arbol = new Arbol<>();

        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);

        System.out.println("Inorden:");
        arbol.recorrerInorden();

        System.out.println("Preorden:");
        arbol.recorrerPreorden();

        System.out.println("Postorden:");
        arbol.recorrerPostorden();

        System.out.println("Por amplitud:");
        arbol.recorrerPorAmplitud();

        System.out.println("Altura: " + arbol.obtenerAltura());
        System.out.println("Peso: " + arbol.obtenerPeso());
        System.out.println("Buscar 40: " + arbol.buscar(40));

        arbol.eliminar(70);
        System.out.println("Después de eliminar 70:");
        arbol.recorrerInorden();
    }
}
