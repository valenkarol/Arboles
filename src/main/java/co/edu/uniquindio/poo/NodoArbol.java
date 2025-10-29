package co.edu.uniquindio.poo;

public class NodoArbol <T > {
    private T elemento;
    private NodoArbol<T> derecha;
    private NodoArbol<T> izquierda;

    public NodoArbol(T elemento) {
        this.elemento = elemento;
        derecha = null;
        izquierda = null;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NodoArbol<T> getDerecha() {
        return derecha;
    }

    public void setProximo(NodoArbol<T> proximo) {
        this.derecha = proximo;
    }

    public NodoArbol<T> getAnterior() {
        return izquierda;
    }

    public void setAnterior(NodoArbol<T> anterior) {
        this.izquierda = anterior;
    }
}

