package controller.monitors;

import model.Observable;
import model.TypeMonitor;
import model.sensors.PeopleSensor;

/**
 * Created by joao on 23/03/17.
 *
 * Class responsible to control quantity of peoples on Room
 */
public class PeopleMonitor extends Monitor {
    private int peoples;

    public PeopleMonitor(){
        this.peoples = 0;
    }

    public void update(Observable obs) {
        PeopleSensor peopleSensor = (PeopleSensor) obs;
        peoples = peopleSensor.getPeoples();

        addMessage("Current Peoples: "+ peoples);
        setValue(peoples);

        setChanged();
        notifyObservers();
    }

    public TypeMonitor getTypeMonitor(){
        return TypeMonitor.PEPOPLE;
    }
}
