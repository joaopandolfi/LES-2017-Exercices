package model;

import java.util.ArrayList;

/**
 * Created by joao on 23/03/17.
 *
 * Base class to Observable itens
 * You need extend this and implement your routine
 */
public class Observable {
    private ArrayList<Observer> observers = new ArrayList<Observer>();;
    private boolean changed = false;


    public void notifyObservers(){
        if(!changed)
            return;

        for(Observer observer: observers){
            observer.update(this);
        }

        changed = false;
    }

    public void setChanged(){
        changed = true;
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
}
