// Virginia Tech Honor Code Pledge:
// Project 3 Spring 2025
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Viren Narayan Agarwal (viren)

package towerofhanoi;

import bag.Node;
import stack.StackInterface;
import java.util.EmptyStackException;

// -------------------------------------------------------------------------
/**
 *  Implementing stack using linked lists 
 *  @param <T>
 *      type of data stored in the linked lists 
 *      
 *  @author viren
 *  @version 24-Mar-2025
 */
public class LinkedStack<T>
    implements StackInterface<T>
{
    private int size; 
    private Node<T> topNode;
    
    /**
     * Implementing Stack Interface using linked list 
     */
    public LinkedStack()
    {
        this.topNode = null; 
        size = 0;
    }
    

    /**
     * Clears the stack 
     */
    @Override
    public void clear()
    {
        topNode = null;
        size = 0;

    }
    
    /**
     * tells you if the stack is empty 
     * 
     * @reutrn
     *      returns true if the stack is empty  
     */
    @Override
    public boolean isEmpty()
    {
        return topNode == null;
    }

    /**
     * returns the data of the top most Node
     * 
     * @return
     *      data of the top most Node 
     */
    @Override
    public T peek()
    {
        if (topNode == null)
        {
            throw new EmptyStackException();
        }
        T data = this.topNode.getData();
        return data;
    }

    /**
     * removes the the top most node and the reduces the size by 1; 
     * 
     * @return 
     *      data of the removed node 
     */
    @Override
    public T pop()
    {
        if (topNode == null)
        {
            throw new EmptyStackException();
        }
        T data = topNode.getData();
        topNode = topNode.getNextNode();
        size--; 
        return data;
    }

    /**
     * adds and element in the Stack
     * 
     * @param data
     *      the data that is to be added
     */
    @Override
    public void push(T data)
    {
        Node<T> newNode = new Node<T>(data);
        newNode.setNextNode(topNode);
        topNode = newNode; 
        size++;

    }
    
    /**
     * This is for the size of the Stack
     * 
     * @return 
     *      the size of the stack
     */
    public int size()
    {
        return size;
    }
    
    /**
     * Creates a representation of the Stack
     * 
     * @return 
     *      representation of the Stack
     */
    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("[");
        Node<T> current = topNode;
        
        while (current != null)
        {
            if (stringbuilder.length() > 1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append(current.getData());
            current = current.getNextNode();
        }
        
        stringbuilder.append("]");
        return stringbuilder.toString();
    }
    
    
    /**
     * Used for storing and managing data in the nodes 
     * 
     * @param <T> 
     *      it is the type of data in the nodes     
     */
    private class Node<T>
    {
        private Node<T> next;
        private T data;
        
        
        public Node(T data) 
        { 
            this.data = data; 
        }
        
        /**
         * gets the next node 
         * 
         * @return 
         *      the next linked node 
         */
        public Node<T> getNextNode()
        {
            return this.next;
        }
        
        /**
         * sets the next node 
         */
        public void setNextNode(Node<T> nextNode)
        {
            this.next = nextNode;
        }
        
        /**
         * gets the data of the node 
         * 
         * @return 
         *      data of the node 
         */
        public T getData()
        {
            return this.data;
        }
    }
}
