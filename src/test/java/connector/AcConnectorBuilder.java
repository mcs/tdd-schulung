package connector;

class AcConnectorBuilder {

    private int voltage = 230;
    private int current = 11;
    private int power = 3700;
    private int phases = 1;

    public AcConnectorBuilder withVoltage(int voltage) {
        this.voltage = voltage;
        return this;
    }

    public AcConnectorBuilder withCurrent(int current) {
        this.current = current;
        return this;
    }

    public AcConnectorBuilder withPower(int power) {
        this.power = power;
        return this;
    }

    public AcConnectorBuilder withPhases(int phases) {
        this.phases = phases;
        return this;
    }

    public AcConnector build() {
        return new AcConnector(voltage, current, power, phases);
    }

}
