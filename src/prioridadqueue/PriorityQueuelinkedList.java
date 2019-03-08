package prioridadqueue;

import Excepciones.isEmptyException;
import Excepciones.isFullException;
import Queue.*;
import java.util.ArrayList;
import java.util.Iterator;


public class PriorityQueuelinkedList<T extends Comparable<T>> {
    
    ArrayList<QueuelinkedList<T>> priority;
    
    enum prioridad {
        Muy_alta, Alta, Media, Baja, Muy_baja
    };
    
    private int  []    size;
    private int  []    front;
    private int  []    back;
    private int  []    count;
  
    
    public PriorityQueuelinkedList (int size){
       
        priority = new ArrayList<>(prioridad.values().length);
        
        this.size = new int[prioridad.values().length];
        this.count = new int[prioridad.values().length];
        this.front = new int[prioridad.values().length];
        this.back = new int[prioridad.values().length];
        
        for (int i = 0; i < prioridad.values().length; i++) {
            this.size[i] = size;
            this.count[i] = 0;
            this.front[i] = -1;
            this.back[i] = 0;
            priority.add(new QueuelinkedList(size));
            
        }
    }
    
    
    public boolean enqueue(int pos, T value) throws isFullException {
        try{
            isfull(pos);
            count[pos]++; 
            priority.get(pos).enqueue(value);
            return true;
        }catch(isFullException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    
    public T dequeue() throws isEmptyException {
        for (int i = 0; i < size[0]; i++) {
            try{
                isempty(i);
                count[i]--;
                return priority.get(i).dequeue();
        
            }catch(isEmptyException e){
            System.out.println(e.getMessage());
            }
        }
      return null; 
    }


    public boolean removeAll() throws isEmptyException {
        for (int j = 0; j < prioridad.values().length; j++) {
            for (int i = 0; i < size[0]; i++) {
                priority.get(j).removeAll();
            }
                front[j] = -1;
                back[j]  =  0;
                count[j] =  0;
        }
              return true;
    }

    
    public boolean isfull(int pos) throws isFullException {
        if (count[pos] == size[pos])
            throw new isFullException("Full Queue | La cola esta llena: " + prioridad.values()[pos]);
        else
            return false;
    }

    
    public boolean isempty(int pos) throws isEmptyException {
        if (count[pos] == 0)
            throw new isEmptyException("Empty Queue | La cola esta vacia: " + prioridad.values()[pos]);
        else return false;
    }

    
    public T front() throws isEmptyException{
        for (int i = 0; i < prioridad.values().length; i++) {
            try {
                if (!isempty(i))
                    return priority.get(i).front();
            } catch (isEmptyException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    
    public T last() throws isEmptyException {
        for (int i = prioridad.values().length - 1; i >= 0; i--) {
            try {
                if (!isempty(i))
                    return priority.get(i).last();
            } catch (isEmptyException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

 
    
}
