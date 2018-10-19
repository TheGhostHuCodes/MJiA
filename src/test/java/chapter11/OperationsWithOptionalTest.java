package chapter11;

import org.junit.Test;

import static chapter11.OperationsWithOptional.max;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.Assert.*;

public class OperationsWithOptionalTest {

    @Test
    public void testMaxReturnsEmptyWhenOneOrBothParametersAreEmpty() {
        assertEquals(empty(), max(empty(), of(42)));
        assertEquals(empty(), max(empty(), empty()));
    }

    @Test
    public void testMaxReturnsMaximumWhenBothParametersAreInts() {
        assertEquals(of(42), max(of(3), of(42)));
    }

}