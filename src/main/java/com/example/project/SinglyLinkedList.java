package com.example.project;

public class SinglyLinkedList<T extends Comparable<T>> {
    private Node<T> first; // Primero nodo de la lista
    private int size; // Tamano de la lista

    // Constructor (crea lista vacia)
    SinglyLinkedList() {
        first = null;
        size = 0;
    }

    // Retorna el tamano de la lista
    public int size() {
        return size;
    }

    // Devuelve true si la lista esta vazia o false caso contrario
    public boolean isEmpty() {
        return (size == 0);
    }

    // Adiciona v al inicio de la lista
    public void addFirst(T v) {
        Node<T> newNode = new Node<T>(v, first);
        first = newNode;
        size++;
    }

    // Adiciona v al final de la lista
    public void addLast(T v) {
        Node<T> newNode = new Node<T>(v, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            Node<T> cur = first;
            while (cur.getNext() != null)
                cur = cur.getNext();
            cur.setNext(newNode);
        }
        size++;
    }

    // Retorna el primer valor de la lista (o null si la lista esta vacia)
    public T getFirst() {
        if (isEmpty())
            return null;
        return first.getValue();
    }

    // Retorna el ultimo valor de la lista (o null si la lista esta vazia)
    public T getLast() {
        if (isEmpty())
            return null;
        Node<T> cur = first;
        while (cur.getNext() != null)
            cur = cur.getNext();
        return cur.getValue();
    }

    // Elimina el primer elemento de la lista (si esta vacia no hara nada)
    public void removeFirst() {
        if (isEmpty())
            return;
        first = first.getNext();
        size--;
    }

    // Elimina el ultimo elemento de la lista (si esta vacia no hara nada)
    public void removeLast() {
        if (isEmpty())
            return;
        if (size == 1) {
            first = null;
        } else {
            // Ciclo con for y uso de size para mostrar alternativa al while
            Node<T> cur = first;
            for (int i = 0; i < size - 2; i++)
                cur = cur.getNext();
            cur.setNext(cur.getNext().getNext());
        }
        size--;
    }

    // Convierte la lista para um String
    public String toString() {
        String str = "{";
        Node<T> cur = first;
        while (cur != null) {
            str += cur.getValue();
            cur = cur.getNext();
            if (cur != null)
                str += ",";
        }
        str += "}";
        return str;
    }

    // NUEVOS METODOS

    // Elimina aquellos nodos de la lista que esten duplicados
    public void deleteDuplicates() {
        SinglyLinkedList<T> nuevo = new SinglyLinkedList<T>();
    	invertir();//Se invierte los nodos enlazados de first
    	while(first != null) {
    		if(repeticiones(getFirst(), first) <= 1) {//se evalua cantidad de repeticiones
    			nuevo.addLast(first.getValue());//se agrega a la nueva lista los nodos sin repetirse
    		}
    		first = first.getNext();
    	}
    	size = nuevo.size;
    	first = nuevo.first;
    	invertir();
    }

    //Metodo que indica la cantidad de repeticiones por comparacion del caracter con los nodos
    public int repeticiones(T caracter, Node<T> nodo) {
    	int cont = 0;
    	while(nodo != null) {
    		if(caracter.compareTo(nodo.getValue()) == 0) {//comparacion del caracter con el valor del nodo actual
    			cont ++;//aumento de la cantidad de repeticiones
    		}
    		nodo = nodo.getNext();
    	}
    	return cont;
    }
    
    //metodo para invertir la lista
    public void invertir() {
    	SinglyLinkedList<T> nuevo = new SinglyLinkedList<T>();
    	while(first != null) {
    		nuevo.addFirst(first.getValue());//se agrega los nodos siempre al empezar
    		first = first.getNext();
    	}
    	first = nuevo.first;
    }

    // Inserta un nuevo nodo en una posicion especifica de la lista
    public void insertNth(T data, int position) {
        SinglyLinkedList<T> nuevo = new SinglyLinkedList<T>();
    	if(position <= size) {
    		int i = 0;
    		for(int j = 0; j < size+1; j++) {
    			if(position == i) {//comparacion de la posicion del nodo con el contador
        			i++;
        			nuevo.addLast(data);
        		}
    			else {
        			nuevo.addLast(first.getValue());//se agrega los nodos de la lista actual
        			first = first.getNext();
        			i++;
        		}
    		}
    		size = nuevo.size;
    		first = nuevo.first;
    	}
    	else {
    		System.out.println("Fuera de rango.");
    	}
    }

    // Elimina el nodo de una posicion especifica de la lista
    public void deleteNth(int position) {
        SinglyLinkedList<T> nuevo = new SinglyLinkedList<T>();
    	if(position < size) {
    		int i=0;
        	while(first != null) {
        		if(position == i) {
        			i++;
        			first = first.getNext();//se pasa al siguiente nodo sin agregar nada
        		}
        		else {
        			nuevo.addLast(first.getValue());//se agrega el nodo de la lista actual "first.getValue"
        			first = first.getNext();
        			i++;
        		}
        	}
        	first = nuevo.first;
        	size--;
    	}
    	else {
    		System.out.println("Fuera de rango.");
    	}
    }

    public static void main(final String[] args) {

        // testExercicio1();
        // testExercicio2();
        testExercicio3();       

    }

    public static void testExercicio1(){

        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

        list.addLast(47);
        list.addLast(89);
        list.addLast(56);
        list.addLast(89);
        list.addLast(56);

        System.out.println(list);

        list.deleteDuplicates();

        System.out.println(list);
    }

    public static void testExercicio2(){

        SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

        list.addLast('a');
        list.addLast('b');
        list.addLast('d');

        System.out.println(list);

        list.insertNth('c', 2);

        System.out.println(list);
    }

    public static void testExercicio3(){

        SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

        list.addLast('a');
        list.addLast('b');
        list.addLast('d');

        System.out.println(list);

        list.deleteNth(2);

        System.out.println(list);
    }

}