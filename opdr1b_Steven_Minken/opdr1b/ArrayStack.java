package opdr1b;

import opdr1b.Stack;

import opdr1b.EmptyStackException;
import opdr1b.StackFullException;

/**
 * Implementatie van de interface Stack mbv een array
 * met vaste lengte. Er wordt een StackFullException opgegooid bij aanroep van push
 * als de grootte van de stack gelijk is aan CAPACITY
 * @author Steven Minken
 * @param <E>
 */

public class ArrayStack<E> implements Stack<E> {
/**
 * Standaard lengte van de array
 */
  public static final int CAPACITY = 1000;
  private E[] s = null;
  private int top = -1;
  
  public ArrayStack() {
    s = (E[]) new Object[CAPACITY];
  }
  @Override
  public int size() {
    return top + 1;
  }

  @Override
  public boolean isEmpty() {
    return top < 0;
  }

  @Override
  public E top() throws EmptyStackException {
    if(isEmpty()) {
      throw new EmptyStackException("Stack is leeg");
    }
    return s[top];
    
  }

  @Override
  public E pop() throws EmptyStackException {
    E elem;
    if (isEmpty()) {
      throw new EmptyStackException("Stack is leeg");
    }
    elem = s[top];
    top--;
    return elem;
  }

  @Override
  public void push(E element) throws StackFullException {
    if (size() == CAPACITY) {
      throw new StackFullException("Stack is vol");
    }
    top ++;
    s[top] = element;
    
  }

}
