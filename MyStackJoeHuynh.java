// Class: CS3305 Data Structures Section 03
// Term: Spring 2022
// Name: Joe Huynh
// Program Number: #1 of Assignment 3
// IDE: Intellij Community Edition 2021.2.2, azul-13 version 15.01(JDK)

import java.util.*;

public class MyStackJoeHuynh <E> {
  ArrayList<E> list = new ArrayList<E>();

   public boolean isEmpty(){
        if(list.size()==0){
            return true;
        }else{
            return false;
        }
    }

    public int size(){
       return list.size();
    }

    public E peek(){
    return list.get(list.size()-1);
    }

    public E pop(){
       E data = list.get(list.size()-1); //assigns the data to a variable
       list.remove(size()-1); //remove from the stack
       return data;
    }
    public void push(E data){
       list.add(data);
    }

    @Override
    public String toString() {
        return "Current list:" + list;
    }
}
