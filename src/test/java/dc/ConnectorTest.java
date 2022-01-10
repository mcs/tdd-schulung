package dc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectorTest {

    @Test
    void shouldInitializeVoltage() {
        int voltage = 1;

        Connector connector = new Connector(voltage, 1, voltage);

        assertEquals(voltage, connector.getVoltageInV());
    }

    @Test
    void shouldThrowExceptionOnZeroVoltage() {
        int voltage = 0;

        assertThrows(IllegalArgumentException.class, () -> new Connector(voltage, 1, voltage));
    }

    @Test
    void shouldThrowExceptionOn1001Voltage() {
        int voltage = 1001;

        assertThrows(IllegalArgumentException.class, () -> new Connector(voltage, 1, voltage));
    }

    @Test
    void shouldAcceptVoltage1000() {
        int voltage = 1000;

        Connector connector = new Connector(voltage, 1, voltage);

        assertEquals(1000, connector.getVoltageInV());
    }

    @Test
    void shouldAcceptPower1() {
        int voltage = 1;
        int power = 1;

        Connector connector = new Connector(voltage, power, 1);

        assertEquals(power, connector.getPowerInKW());
    }

    @Test
    void shouldThrowExceptionOnPower0() {
        int voltage = 1;
        int power = 0;

        assertThrows(IllegalArgumentException.class, () -> new Connector(voltage, power, 1));
    }

    @Test
    void shouldThrowExceptionOnPower1001() {
        int voltage = 1;
        int power = 1001;

        assertThrows(IllegalArgumentException.class, () -> new Connector(voltage, power, 1));
    }

    @Test
    void shouldAcceptAndReturnPower1000() {
        int voltage = 1;
        int power = 1000;

        Connector connector = new Connector(voltage, power, 1);
        assertEquals(power, connector.getPowerInKW());
    }

    @Test
    void shouldInitializeWithCurrent() {
        int voltage = 1;
        int power = 1000;
        int current = 1;

        Connector connector = new Connector(voltage, power, current);

        assertEquals(voltage, connector.getCurrentInA());

    }

    @Test
    void shouldThrowExceptionOnCurrent0() {
        int voltage = 1;
        int power = 1000;
        int current = 0;

        assertThrows(IllegalArgumentException.class, () -> new Connector(voltage, power, current));
    }

    @Test
    void shouldThrowExceptionOnCurrentNull(){
        int voltage = 1;
        int power = 1000;
        Integer current = null;

        assertThrows(IllegalArgumentException.class, () -> new Connector(voltage, power, current));
    }

    @Test
    void shouldBeValid(){
        int voltage = 1000;
        int power = 1;
        int current = 1;

        Connector connector = new Connector(voltage, power, current);

        assertTrue(connector.isValid());
    }

    @Test
    void shouldBeInValid(){
        int voltage = 1;
        int power = 1;
        int current = 2;

        Connector connector = new Connector(voltage, power, current);

        assertFalse(connector.isValid());
    }




}
