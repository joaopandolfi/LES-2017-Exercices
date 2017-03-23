package model;

/**
 * Created by joao on 23/03/17.
 *
 * This interface is responsible to make contract with observers and observables
 * You must implement this :D
 */
public interface Observer {

    public void update(Observable obs);

    public String getMessages();
    public void flushMessages();
}
