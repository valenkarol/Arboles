package co.edu.uniquindio.poo;

public class NodoArbol<T> {
    private T elemento;
    private NodoArbol<T> izquierda;
    private NodoArbol<T> derecha;

    public NodoArbol(T elemento) {
        this.elemento = elemento;
        this.izquierda = null;
        this.derecha = null;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NodoArbol<T> getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoArbol<T> izquierda) {
        this.izquierda = izquierda;
    }

    public NodoArbol<T> getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoArbol<T> derecha) {
        this.derecha = derecha;
    }
}
