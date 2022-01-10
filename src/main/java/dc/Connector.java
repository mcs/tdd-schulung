package dc;

public class Connector {

    private final Integer currentInA;
    private final int voltageInV;
    private final int powerInKW;

    public Connector(int voltageInV, int powerInKW, Integer currentInA) {
        if (voltageInV < 1 || voltageInV > 1000) {
            throw new IllegalArgumentException();
        }
        if (powerInKW < 1 || powerInKW > 1000) {
            throw new IllegalArgumentException();
        }
        if (currentInA == null || currentInA < 1) {
            throw new IllegalArgumentException();
        }
        this.powerInKW = powerInKW;
        this.voltageInV = voltageInV;
        this.currentInA = currentInA;
    }

    public int getVoltageInV() {
        return voltageInV;
    }

    public int getPowerInKW() {
        return powerInKW;
    }

    public Integer getCurrentInA() {
        return currentInA;
    }


    public boolean isValid() {
        return (powerInKW * 1000 == voltageInV * currentInA);
    }
}
