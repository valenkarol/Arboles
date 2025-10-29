package co.edu.uniquindio.poo;

public class Arbol<T extends Comparable<T>> {
    private NodoArbol<T> raiz;

    public Arbol(NodoArbol<T> raiz) {
        this.raiz = raiz;
    }

    public void insertarRecursivo(NodoArbol<T> actual, T elemento) {
        NodoArbol<T> nuevo = new NodoArbol<>(elemento);
        if(actual==null){
            return ;//agregar
        }
        int comparacion = actual.getElemento().compareTo(elemento);
        if(comparacion<0){
            if(actual.getIzquierodo)
        }
    }

    public String insertar(T elemento) {
        NodoArbol<T> newNodo = new NodoArbol<>(elemento);

        if(raiz == null){
            raiz = newNodo;
            return "se creo el arbol";
        }else if(raiz.getElemento()==elemento){
            return "el elemento ya existe";
        }
        insertarRecursivo(raiz, elemento);
        return "elemento insertado correctamente";
    }


}
