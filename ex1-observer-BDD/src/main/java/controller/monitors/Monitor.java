package controller.monitors;

import model.Observable;
import model.Observer;
import model.TypeMonitor;

/**
 * Created by joao on 23/03/17.
 *
 * Abstract Monitor of sensors
 */
public abstract class Monitor extends Observable implements Observer {

    public abstract TypeMonitor getTypeMonitor();
    protected String messages = "";
    private double value = 0;
    private double quantReadeds = 0;

    public void addMessage(String message){
        messages += message+"\n";
    }

    public void setValue(double value){
        this.value += value;
        this.quantReadeds +=1;
    }

    public double getValue(){
        return this.value/this.quantReadeds;
    }

    public String getMessages() {
        return messages;
    }

    public void flushMessages() {
        messages = "";
    }
}
