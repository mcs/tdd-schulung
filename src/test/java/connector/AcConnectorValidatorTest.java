package connector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AcConnectorValidatorTest {

    private final AcConnectorValidator sut = new AcConnectorValidator();

    private AcConnectorBuilder acConnectorBuilder;

    @BeforeEach
    void setup() {
        acConnectorBuilder = new AcConnectorBuilder();
    }

    @Test
    void shouldReturnTrueWhenConnectorIsValid() {
        AcConnector connector = acConnectorBuilder.build();

        boolean result = sut.validate(connector);

        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenVoltageIsBelow230V() {
        AcConnector connector = acConnectorBuilder.withVoltage(229).build();

        boolean result = sut.validate(connector);

        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhenVoltageIsAbove230V() {
        AcConnector connector = acConnectorBuilder.withVoltage(231).build();

        boolean result = sut.validate(connector);

        assertFalse(result);
    }

    @Test
    void shouldReturnFalseForInvalidPower3699() {
        AcConnector connector = acConnectorBuilder.withPower(3699).build();

        boolean result = sut.validate(connector);

        assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {3700, 11000})
    void shouldReturnTrueForValidPowers(int power) {
        AcConnector connector = acConnectorBuilder.withPower(power).build();

        boolean result = sut.validate(connector);

        assertTrue(result);
    }

}