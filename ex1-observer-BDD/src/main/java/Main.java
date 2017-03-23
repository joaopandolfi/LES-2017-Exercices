import controller.AirConditionairControl;
import controller.monitors.PeopleMonitor;
import controller.monitors.TemperatureMonitor;
import model.sensors.PeopleSensor;
import model.sensors.TemperatureSensor;
import view.View;

import java.util.ArrayList;

/**
 * Created by joao on 23/03/17.
 *
 * That is fucking main class bro
 */
public class Main {

    public static void main(String[] args){

        // == CREATING AC - I WILL NOT CREATE A FACTORY >:(

        //Controller
        AirConditionairControl airConditionairControl = new AirConditionairControl();

        //Monitors
        PeopleMonitor peopleMonitor = new PeopleMonitor();
        TemperatureMonitor temperatureMonitor = new TemperatureMonitor();

        //Sensors
        ArrayList<PeopleSensor> peopleSensors = new ArrayList<PeopleSensor>();
        ArrayList<TemperatureSensor> temperatureSensors = new ArrayList<TemperatureSensor>();

        //Adding Sensors
        for(int i = 0; i< 3;i++){
            PeopleSensor peopleSensor = new PeopleSensor();
            peopleSensor.addObserver(peopleMonitor);
            peopleSensors.add(peopleSensor);

            TemperatureSensor temperatureSensor = new TemperatureSensor();
            temperatureSensor.addObserver(temperatureMonitor);
            temperatureSensors.add(temperatureSensor);
        }

        //Adding Monitors on AC controller
        peopleMonitor.addObserver(airConditionairControl);
        temperatureMonitor.addObserver(airConditionairControl);

        // == USING

        //adding values on People Sensors
        int gap = 10;
        for(PeopleSensor peopleSensor : peopleSensors){
            peopleSensor.setPeoples(gap);
            gap += 10;
        }

        gap = 27;
        //adding values on Temperature Sensors
        for(TemperatureSensor temperatureSensor : temperatureSensors){
            temperatureSensor.setTemperature(gap);
            gap += 1;
        }

        View.showMessage("== MONITOR LOGS ==");
        View.showMessage(temperatureMonitor.getMessages());
        View.showMessage(peopleMonitor.getMessages());

        View.showMessage("== AC LOGS ==");
        View.showMessage(airConditionairControl.getMessages());
    }
}
