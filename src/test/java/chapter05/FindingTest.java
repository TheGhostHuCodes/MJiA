package chapter05;

import org.junit.Test;

import static chapter05.Finding.*;
import static org.junit.Assert.*;

public class FindingTest {

    @Test
    public void testIsVegetarianFriendlyMenuReturnsTrue() {
        assertTrue(isVegetarianFriendlyMenu());
    }

    @Test
    public void testIsHealthyMenuTrue() {
        assertTrue(isHealthyMenu());
    }

    @Test
    public void testIsHealthyMenu2ReturnsTrue() {
        assertTrue(isHealthyMenu2());
    }

}