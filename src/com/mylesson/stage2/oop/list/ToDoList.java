package com.mylesson.stage2.oop.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class ToDoList {

    private LinkedList<String> toDoList = new LinkedList<>();

    public void addToList(String task){
//        toDoList.addFirst(task);
//        toDoList.addLast(task);
//        toDoList.add(task);
        addInAlphabeticalOrder(task);
    }

    private boolean addInAlphabeticalOrder(String task){
        ListIterator<String> iterator = toDoList.listIterator();
        while (iterator.hasNext()){
            int compared = iterator.next().compareTo(task);
            if (compared == 0){
                System.out.println("Task already existing in the list");
                return true;
            } else if (compared > 0){
                iterator.previous();
                iterator.add(task);
                return true;
            }
        }
        toDoList.add(task);
        return true;
    }

    public void addToListAtPosition(String task, int position){
        toDoList.add(position, task);
    }

    public void printToDoList(){

//        for (int i = 0; i < toDoList.size(); i++) {
//            System.out.println("index: " + i + " - " + toDoList.get(i));
//        };
        Iterator<String> iterator = toDoList.iterator();
        while(iterator.hasNext()){
            System.out.println("Element " + iterator.next());
        }
    }

    public void changeTask(int index, String task){

        toDoList.set(index, task);

    }

    public void removeTask(String task){

        toDoList.remove(task);
    }
    public void removeTaskByIndex(int index){

        toDoList.remove(index);
    }
    public int getTaskPriority(String task){
        return toDoList.indexOf(task);
    }

}
