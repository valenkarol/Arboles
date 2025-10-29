package co.edu.uniquindio.poo;
import java.util.LinkedList;
import java.util.Queue;

public class Arbol<T extends Comparable<T>> {
    private NodoArbol<T> raiz;

    public Arbol() {
        this.raiz = null;
    }

    public NodoArbol<T> getRaiz() {
        return raiz;
    }

    // ✅ Inserción recursiva
    public void insertar(T elemento) {
        raiz = insertarRecursivo(raiz, elemento);
    }

    private NodoArbol<T> insertarRecursivo(NodoArbol<T> actual, T elemento) {
        if (actual == null) {
            return new NodoArbol<>(elemento);
        }

        int comparacion = elemento.compareTo(actual.getElemento());

        if (comparacion < 0) {
            actual.setIzquierda(insertarRecursivo(actual.getIzquierda(), elemento));
        } else if (comparacion > 0) {
            actual.setDerecha(insertarRecursivo(actual.getDerecha(), elemento));
        }
        // Si es igual, no se inserta (no duplicados)
        return actual;
    }

    // ✅ Búsqueda recursiva
    public boolean buscar(T elemento) {
        return buscarRecursivo(raiz, elemento);
    }

    private boolean buscarRecursivo(NodoArbol<T> actual, T elemento) {
        if (actual == null) return false;

        int comparacion = elemento.compareTo(actual.getElemento());
        if (comparacion == 0) return true;
        else if (comparacion < 0) return buscarRecursivo(actual.getIzquierda(), elemento);
        else return buscarRecursivo(actual.getDerecha(), elemento);
    }

    // ✅ Eliminar un elemento
    public void eliminar(T elemento) {
        raiz = eliminarRecursivo(raiz, elemento);
    }

    private NodoArbol<T> eliminarRecursivo(NodoArbol<T> actual, T elemento) {
        if (actual == null) return null;

        int comparacion = elemento.compareTo(actual.getElemento());
        if (comparacion < 0) {
            actual.setIzquierda(eliminarRecursivo(actual.getIzquierda(), elemento));
        } else if (comparacion > 0) {
            actual.setDerecha(eliminarRecursivo(actual.getDerecha(), elemento));
        } else {
            // Caso 1: sin hijos
            if (actual.getIzquierda() == null && actual.getDerecha() == null) {
                return null;
            }
            // Caso 2: un solo hijo
            else if (actual.getIzquierda() == null) {
                return actual.getDerecha();
            } else if (actual.getDerecha() == null) {
                return actual.getIzquierda();
            }
            // Caso 3: dos hijos
            T valorMinimo = encontrarMinimo(actual.getDerecha());
            actual.setElemento(valorMinimo);
            actual.setDerecha(eliminarRecursivo(actual.getDerecha(), valorMinimo));
        }
        return actual;
    }

    private T encontrarMinimo(NodoArbol<T> nodo) {
        while (nodo.getIzquierda() != null) {
            nodo = nodo.getIzquierda();
        }
        return nodo.getElemento();
    }

    // ✅ Recorridos
    public void recorrerInorden() {
        recorrerInorden(raiz);
        System.out.println();
    }

    private void recorrerInorden(NodoArbol<T> nodo) {
        if (nodo != null) {
            recorrerInorden(nodo.getIzquierda());
            System.out.print(nodo.getElemento() + " ");
            recorrerInorden(nodo.getDerecha());
        }
    }

    public void recorrerPreorden() {
        recorrerPreorden(raiz);
        System.out.println();
    }

    private void recorrerPreorden(NodoArbol<T> nodo) {
        if (nodo != null) {
            System.out.print(nodo.getElemento() + " ");
            recorrerPreorden(nodo.getIzquierda());
            recorrerPreorden(nodo.getDerecha());
        }
    }

    public void recorrerPostorden() {
        recorrerPostorden(raiz);
        System.out.println();
    }

    private void recorrerPostorden(NodoArbol<T> nodo) {
        if (nodo != null) {
            recorrerPostorden(nodo.getIzquierda());
            recorrerPostorden(nodo.getDerecha());
            System.out.print(nodo.getElemento() + " ");
        }
    }

    // ✅ Recorrido por amplitud (nivel a nivel)
    public void recorrerPorAmplitud() {
        if (raiz == null) return;
        Queue<NodoArbol<T>> cola = new LinkedList<>();
        cola.add(raiz);
        while (!cola.isEmpty()) {
            NodoArbol<T> actual = cola.poll();
            System.out.print(actual.getElemento() + " ");
            if (actual.getIzquierda() != null) cola.add(actual.getIzquierda());
            if (actual.getDerecha() != null) cola.add(actual.getDerecha());
        }
        System.out.println();
    }

    // ✅ Peso del árbol (cantidad de nodos)
    public int obtenerPeso() {
        return contarNodos(raiz);
    }

    private int contarNodos(NodoArbol<T> nodo) {
        if (nodo == null) return 0;
        return 1 + contarNodos(nodo.getIzquierda()) + contarNodos(nodo.getDerecha());
    }

    // ✅ Altura del árbol
    public int obtenerAltura() {
        return calcularAltura(raiz);
    }

    private int calcularAltura(NodoArbol<T> nodo) {
        if (nodo == null) return 0;
        int izquierda = calcularAltura(nodo.getIzquierda());
        int derecha = calcularAltura(nodo.getDerecha());
        return 1 + Math.max(izquierda, derecha);
    }
}

