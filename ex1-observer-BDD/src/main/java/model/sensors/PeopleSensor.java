package model.sensors;

/**
 * Created by joao on 23/03/17.
 *
 * Class responsible to count peoples on room
 */
public class PeopleSensor extends Sensor {

    private int peoples;

    public PeopleSensor(){
        this.peoples = 0;
    }

    //Change to Random
    public void countPeople(){
        setValue(33);
    }

    public void setPeoples(int peoples){
        this.peoples = peoples;
        setValue(peoples);
    }

    public void addPeoples(int peoples){
        this.peoples += peoples;
        setValue(peoples);
    }

    public void removePeoples(int peoples){
        this.peoples -= peoples;
        setValue(peoples);
    }

    public int getPeoples(){
        return peoples;
    }
}
