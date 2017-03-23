import controller.monitors.PeopleMonitor;
import controller.monitors.TemperatureMonitor;
import model.sensors.PeopleSensor;
import model.sensors.TemperatureSensor;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by joao on 23/03/17.
 *
 * TDD implemented
 */


public class TDD {

    // === FAKE TEST ===

    @Test
    public void fakeTest() throws Exception {
        Assert.assertEquals(1,1);
    }

    // === SENSORS TESTS ==
    @Test
    public void temperatureSensorTest() throws Exception {
        TemperatureSensor temperatureSensor = new TemperatureSensor();
        temperatureSensor.setTemperature(10);
        Assert.assertEquals(10.0,temperatureSensor.getValue(),0);
    }


    @Test
    public void peopleSensorTest() throws Exception {
        PeopleSensor peopleSensor = new PeopleSensor();
        peopleSensor.addPeoples(3);
        Assert.assertEquals(3,peopleSensor.getValue(),0);
    }

    // ==== MONITORS TESTS =====

    @Test
    public void peopleMonitorTest() throws Exception {
        PeopleSensor peopleSensor = new PeopleSensor();
        PeopleMonitor peopleMonitor = new PeopleMonitor();
        peopleSensor.addObserver(peopleMonitor);
        peopleSensor.addPeoples(3);

        Assert.assertEquals(3,peopleMonitor.getValue(),0);
    }

    @Test
    public void peopleMonitorTest2() throws Exception {
        PeopleSensor peopleSensor = new PeopleSensor();
        PeopleMonitor peopleMonitor = new PeopleMonitor();
        peopleSensor.addObserver(peopleMonitor);
        peopleSensor.setPeoples(1);
        peopleSensor.setPeoples(2);
        peopleSensor.setPeoples(3);

        Assert.assertEquals(2,peopleMonitor.getValue(),0);
    }


    @Test
    public void peopleMonitorTest3() throws Exception {
        PeopleSensor peopleSensor = new PeopleSensor();
        PeopleMonitor peopleMonitor = new PeopleMonitor();
        peopleSensor.addObserver(peopleMonitor);
        peopleSensor.setPeoples(12);
        peopleSensor.setPeoples(8);
        peopleSensor.setPeoples(1);

        Assert.assertEquals(7,peopleMonitor.getValue(),0);
    }


    @Test
    public void temperatureMonitorTest() throws Exception {
        TemperatureSensor temperatureSensor = new TemperatureSensor();
        TemperatureMonitor temperatureMonitor = new TemperatureMonitor();
        temperatureSensor.addObserver(temperatureMonitor);
        temperatureSensor.setTemperature(10);

        Assert.assertEquals(10.0,temperatureMonitor.getValue(),0);
    }

    @Test
    public void temperatureMonitorTest2() throws Exception {
        TemperatureSensor temperatureSensor = new TemperatureSensor();
        TemperatureMonitor temperatureMonitor = new TemperatureMonitor();
        temperatureSensor.addObserver(temperatureMonitor);
        temperatureSensor.setTemperature(10);
        temperatureSensor.setTemperature(10);

        Assert.assertEquals(10.0,temperatureMonitor.getValue(),0);
    }

    @Test
    public void temperatureMonitorTest3() throws Exception {
        TemperatureSensor temperatureSensor = new TemperatureSensor();
        TemperatureMonitor temperatureMonitor = new TemperatureMonitor();
        temperatureSensor.addObserver(temperatureMonitor);
        temperatureSensor.setTemperature(1);
        temperatureSensor.setTemperature(2);
        temperatureSensor.setTemperature(3);

        Assert.assertEquals(2.0,temperatureMonitor.getValue(),0);
    }


    // === MULTIPLE TESTS

    @Test
    public void temperatureMonitorMultiSensorsTest() throws Exception {
        TemperatureSensor temperatureSensor1 = new TemperatureSensor();
        TemperatureSensor temperatureSensor2 = new TemperatureSensor();
        TemperatureSensor temperatureSensor3 = new TemperatureSensor();
        TemperatureMonitor temperatureMonitor = new TemperatureMonitor();
        temperatureSensor1.addObserver(temperatureMonitor);
        temperatureSensor2.addObserver(temperatureMonitor);
        temperatureSensor3.addObserver(temperatureMonitor);
        temperatureSensor1.setTemperature(1);
        temperatureSensor2.setTemperature(2);
        temperatureSensor3.setTemperature(3);

        Assert.assertEquals(2.0,temperatureMonitor.getValue(),0);
    }


    @Test
    public void peopleMonitorMultiSensorsTest() throws Exception {
        PeopleSensor peopleSensor1 = new PeopleSensor();
        PeopleSensor peopleSensor2 = new PeopleSensor();
        PeopleSensor peopleSensor3 = new PeopleSensor();
        PeopleMonitor peopleMonitor = new PeopleMonitor();
        peopleSensor1.addObserver(peopleMonitor);
        peopleSensor2.addObserver(peopleMonitor);
        peopleSensor3.addObserver(peopleMonitor);
        peopleSensor1.setPeoples(12);
        peopleSensor2.setPeoples(8);
        peopleSensor3.setPeoples(1);

        Assert.assertEquals(7,peopleMonitor.getValue(),0);
    }

}
