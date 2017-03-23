package controller;

import controller.monitors.Monitor;
import model.Observable;
import model.Observer;

/**
 * Created by joao on 23/03/17.
 */
public class AirConditionairControl implements Observer {

    public static double IDEAL_TEMPERATURE = 25.0;

    private double temperature;
    private double peoples;

    private double calculatedTemperature;

    private String messages;


    public AirConditionairControl(){
        this.temperature = 0;
        this.messages = "";
    }

    public void update(Observable obs) {
        Monitor monitor = (Monitor) obs;
        switch (monitor.getTypeMonitor()){
            case TEMPERATURE:
                this.temperature = monitor.getValue();
            break;

            case PEPOPLE:
                this.peoples = monitor.getValue();
            break;
        }

        calculatedTemperature = temperature + peoples;
        messages += "CALCULATED TEMPERATURE: "+this.calculatedTemperature+"\n";

        if(calculatedTemperature > IDEAL_TEMPERATURE){
            messages  += ">> NOT IDEAL TEMPERATURE - THAT SHIT IS SO FUCKING HOT \n";
        }
        else if(calculatedTemperature < IDEAL_TEMPERATURE){
            messages  += ">> NOT IDEAL TEMPERATURE - I'M FREEZING BITCH \n";
        }
        else
            messages  += "++ IDEAL TEMPERATURE ++ - I'M REALLY HAPPY DUDE \n";
    }

    public double getTemperature(){
        return calculatedTemperature;
    }

    public String getMessages() {
        return messages;
    }

    public void flushMessages() {
        messages = "";
    }
}
