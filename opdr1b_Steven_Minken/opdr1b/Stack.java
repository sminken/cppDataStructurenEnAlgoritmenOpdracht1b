package opdr1b;

import opdr1b.EmptyStackException;
import opdr1b.StackFullException;

/**
   * Interface voor een stack: een verzameling elementen
   * die volgens het LIFO principe toegevoegd en 
   * verwijderd worden
   * @author Steven Minken
   *
   */
  public interface Stack<E> {
    
    /**
     * Lever het aantal elementen in de stack
     */
    public int size();
    
    /**
     * Levert true als de stack leeg is, anders false
     */
    public boolean isEmpty();

    /**
     * @return het element aan te top van de stack
     * @throws EmptyStackException als de stack leeg is
     */
    public E top() throws EmptyStackException;
    
    /**
     * Voegt een element aan de top van de stack toe
     * @param element het element dat toegevoegd moet worden
     * @throws StackFullException als de stack vol is
     */
    public void push(E element) throws StackFullException;
    
    /**
     * Verwijdert het element aan de top van de stack
     * @return het verwijderde element
     * @throws EmptyStackException als de stack leeg is
     */
    public E pop() throws EmptyStackException;

}
