package model.sensors;


/**
 * Created by joao on 23/03/17.
 *
 * Class responsible to read Temperature
 */
public class TemperatureSensor extends Sensor {

    public void generateTemperature(){
        generateValue();
    }

    public void setTemperature(double temperature){
        setValue(temperature);
    }

    public double getTemperature(){
        return getValue();
    }
}
