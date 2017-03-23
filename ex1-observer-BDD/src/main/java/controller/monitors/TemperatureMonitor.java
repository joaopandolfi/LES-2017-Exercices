package controller.monitors;

import model.Observable;
import model.TypeMonitor;
import model.sensors.TemperatureSensor;

/**
 * Created by joao on 23/03/17.
 *
 * Class responsible to control temperature
 */
public class TemperatureMonitor extends Monitor{

    private double temperature;
    private int totalChanges;

    public TemperatureMonitor(){
        this.temperature = 0;
        this.totalChanges = 0;
        this.messages = "";
    }

    public void update(Observable obs){
        TemperatureSensor tempSensor = (TemperatureSensor) obs;

        totalChanges +=1;
        temperature += tempSensor.getValue();

        addMessage("Temp readed: "+tempSensor.getValue());
        setChanged();
        notifyObservers();
    }

    public double getValue(){
        return temperature/totalChanges;
    }

    public TypeMonitor getTypeMonitor(){
        return TypeMonitor.TEMPERATURE;
    }
}
