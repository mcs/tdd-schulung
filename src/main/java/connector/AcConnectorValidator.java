package connector;

import java.util.Set;

public class AcConnectorValidator {

    private static final Set<Integer> VALID_POWERS = Set.of(3700, 11000);

    public boolean validate(AcConnector acConnector) {
        return checkVoltage(acConnector)
                && checkPower(acConnector);
    }

    private boolean checkPower(AcConnector connector) {
        int power = connector.getPower();
        return VALID_POWERS.contains(power);
    }

    private boolean checkVoltage(AcConnector connector) {
        return connector.getVoltage() == 230;
    }
}
