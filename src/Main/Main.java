package Main;

import Excepciones.isEmptyException;
import Excepciones.isFullException;
import Queue.*;
import prioridadqueue.*;

public class Main {

    //public static QueuelinkedList<Double> numeritos;
    

    public static void main(String[] args) throws isFullException, isEmptyException {
        
       
        PriorityQueuelinkedList<Double> numeritos = new PriorityQueuelinkedList(5);

        
        //agregando numeros en la cola
        

        numeritos.enqueue(0, 4d);
        numeritos.enqueue(1, 15d);
        numeritos.enqueue(2, 21d);
        numeritos.enqueue(3, 14d);
        numeritos.enqueue(4, 16d);
        
        System.out.println("El ultimo numero de la cola es: " + numeritos.last());
        System.out.println("El numero en front es: " + numeritos.front());
        System.out.println("");
        
        
        numeritos.enqueue(0, 8d);
        numeritos.enqueue(1, 13d);
        numeritos.enqueue(2, 24d);
        numeritos.enqueue(3, 19d);
        numeritos.enqueue(4, 32d);
        
        numeritos.dequeue();
       
        System.out.println("El ultimo numero de la cola es: " + numeritos.last());
        System.out.println("El numero en front es: " + numeritos.front());
        
     
        
      

        
        
        //probando removeAll
        numeritos.removeAll();
        System.out.println("Todo ha sido borrado");
        /*for (Double numerito : numeritos) {
            System.out.println(numerito);
        }
        
        */
        //Probando isempty
        System.out.println("El ultimo numero de la cola es: " + numeritos.last());
        System.out.println("El numero en front es: " + numeritos.front());
        
     
        
    }

}
