package connector;

public class AcConnector {
    private final int voltage;
    private final int current;
    private final int power;
    private final int phases;

    public AcConnector(int voltage, int current, int power, int phases) {
        this.voltage = voltage;
        this.current = current;
        this.power = power;
        this.phases = phases;
    }

    public int getVoltage() {
        return voltage;
    }

    public int getCurrent() {
        return current;
    }

    public int getPower() {
        return power;
    }

    public int getPhases() {
        return phases;
    }

}
