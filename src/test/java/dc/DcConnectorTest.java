package dc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DcConnectorTest {

    @Test
    void shouldInitializeVoltage() {
        int voltage = 1;

        DcConnector dcConnector = new DcConnector(voltage, 1, voltage);

        assertEquals(voltage, dcConnector.getVoltageInV());
    }

    @Test
    void shouldThrowExceptionOnZeroVoltage() {
        int voltage = 0;

        assertThrows(IllegalArgumentException.class, () -> new DcConnector(voltage, 1, voltage));
    }

    @Test
    void shouldThrowExceptionOn1001Voltage() {
        int voltage = 1001;

        assertThrows(IllegalArgumentException.class, () -> new DcConnector(voltage, 1, voltage));
    }

    @Test
    void shouldAcceptVoltage1000() {
        int voltage = 1000;

        DcConnector dcConnector = new DcConnector(voltage, 1, voltage);

        assertEquals(1000, dcConnector.getVoltageInV());
    }

    @Test
    void shouldAcceptPower1() {
        int voltage = 1;
        int power = 1;

        DcConnector dcConnector = new DcConnector(voltage, power, 1);

        assertEquals(power, dcConnector.getPowerInKW());
    }

    @Test
    void shouldThrowExceptionOnPower0() {
        int voltage = 1;
        int power = 0;

        assertThrows(IllegalArgumentException.class, () -> new DcConnector(voltage, power, 1));
    }

    @Test
    void shouldThrowExceptionOnPower1001() {
        int voltage = 1;
        int power = 1001;

        assertThrows(IllegalArgumentException.class, () -> new DcConnector(voltage, power, 1));
    }

    @Test
    void shouldAcceptAndReturnPower1000() {
        int voltage = 1;
        int power = 1000;

        DcConnector dcConnector = new DcConnector(voltage, power, 1);
        assertEquals(power, dcConnector.getPowerInKW());
    }

    @Test
    void shouldInitializeWithCurrent() {
        int voltage = 1;
        int power = 1000;
        int current = 1;

        DcConnector dcConnector = new DcConnector(voltage, power, current);

        assertEquals(voltage, dcConnector.getCurrentInA());

    }

    @Test
    void shouldThrowExceptionOnCurrent0() {
        int voltage = 1;
        int power = 1000;
        int current = 0;

        assertThrows(IllegalArgumentException.class, () -> new DcConnector(voltage, power, current));
    }

    @Test
    void shouldThrowExceptionOnCurrentNull(){
        int voltage = 1;
        int power = 1000;
        Integer current = null;

        assertThrows(IllegalArgumentException.class, () -> new DcConnector(voltage, power, current));
    }

    @Test
    void shouldBeValid(){
        int voltage = 1000;
        int power = 1;
        int current = 1;

        DcConnector dcConnector = new DcConnector(voltage, power, current);

        assertTrue(dcConnector.isValid());
    }

    @Test
    void shouldBeInValid(){
        int voltage = 1;
        int power = 1;
        int current = 2;

        DcConnector dcConnector = new DcConnector(voltage, power, current);

        assertFalse(dcConnector.isValid());
    }




}
