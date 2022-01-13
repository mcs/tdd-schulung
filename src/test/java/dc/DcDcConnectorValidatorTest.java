package dc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DcDcConnectorValidatorTest {

    private final DcConnectorValidator dcConnectorValidator = new DcConnectorValidator();

    @Test
    void shouldHaveValidEnergySettings() {

        DcConnector dcConnector = new DcConnector(1000, 1, 1);

        boolean valid = dcConnectorValidator.validate(dcConnector);

        assertTrue(valid);
    }
}
