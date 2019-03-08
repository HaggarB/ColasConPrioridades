package prioridadqueue;

import Excepciones.isEmptyException;
import Excepciones.isFullException;
import Queue.QueueArray;


public class PrioridadQueue<T extends QueueArray> {

    static QueueArray<Double>[] dobles = new QueueArray[5];

    enum prioridad {
        Muy_alta, Alta, Media, Baja, Muy_baja
    };



    public static void insert(int prioridad, double dato) {
        try {
            dobles[prioridad].enqueue(dato);
        } catch (isFullException e) {
            System.err.println("Full Queue | Cola llena");
        }

    }
    
    public static void remove(int priority) {
            try {
                dobles[priority].isempty();
                System.out.println(dobles[priority].dequeue());
            } catch (isEmptyException e) {
                System.err.println("Empty Queue | Cola vacia");
            }
        }

    public static void print() {
        for (QueueArray<Double> queue : dobles) {
            try {
                queue.isempty();
                for (Double a : queue) {
                    System.out.print(a + "\t");
                }
                System.out.println();
            } catch (isEmptyException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static void _init_ () {
        for (int i = 0; i < dobles.length; i++) {
            dobles[i] = new QueueArray<>(Double.class, 5);
        }
    }
     

//    public static void main(String[] args) {
//        
//       _init_();
//        System.out.println("Insertando numeros");
//       insert(prioridad.Muy_alta.ordinal(), 21d);
//       insert(prioridad.Muy_alta.ordinal(), 22d);
//       insert(prioridad.Muy_alta.ordinal(), 23d);
//       insert(prioridad.Muy_alta.ordinal(), 24d);
//       insert(prioridad.Muy_alta.ordinal(), 25d);
//       insert(prioridad.Muy_alta.ordinal(), 26d); //Probando Full Queue | Cola Llena, este no se va a imprimir
//       insert(prioridad.Alta.ordinal(), 31d);
//       insert(prioridad.Media.ordinal(), 42d);
//       insert(prioridad.Media.ordinal(), 53d);
//       insert(prioridad.Baja.ordinal(), 18d);
//       insert(prioridad.Muy_baja.ordinal(), 16d);
//       insert(prioridad.Muy_baja.ordinal(), 116d);
//       insert(prioridad.Alta.ordinal(), 777d);
//       
//       System.out.println("");
//       System.out.println("Imprimiendo numeros");
//       print(); 
//       System.out.println("");
//       
//       System.out.println("Eliminando los numeros");
//       remove(0);
//       remove(0);
//       remove(2);
//       remove(3); //Probando Empty Queue | Cola vacia
//       
//       System.out.println("");
//       System.out.println("Imprimiendo numeros");
//       
//       print();
//
//    }
}

