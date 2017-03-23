package model.sensors;

import model.Observable;

/**
 * Created by joao on 23/03/17.
 */
public class Sensor extends Observable {
    private double value;

    Sensor(){
        this.value = 0.0;
    }

    public void generateValue(){
        this.value = 25;
    }

    public void setValue(double value){
        this.value = value;
        setChanged();
        notifyObservers();
    }

    public double getValue(){
        return value;
    }
}
