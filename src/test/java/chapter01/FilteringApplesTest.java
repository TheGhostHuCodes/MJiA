package chapter01;

import org.junit.Test;
import chapter01.FilteringApples.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static chapter01.FilteringApples.*;

public class FilteringApplesTest {

    @Test
    public void testAppleColorAndWeightCanBeSet() {
        Apple a = new Apple(80, "green");
        a.setWeight(42);
        a.setColor("blue");

        assertEquals(42, a.getWeight());
        assertEquals("blue", a.getColor());
    }

    @Test
    public void testIsGreenAppleReturnsTrueForGreenApples() {
        Apple a = new Apple(80, "green");

        assertTrue(isGreenApple(a));
    }

    @Test
    public void testIsGreenAppleReturnsFalseForNonGreenApples() {
        Apple a = new Apple(80, "red");

        assertFalse(isGreenApple(a));
    }

    @Test
    public void testIsHeavyAppleReturnsTrueForApplesHeavierThan150() {
        Apple a = new Apple(151, "green");

        assertTrue(isHeavyApple(a));
    }

    @Test
    public void testIsHeavyAppleReturnsFalseForApples150AndLighter() {
        Apple a = new Apple(150, "green");
        Apple b = new Apple(80, "green");

        assertFalse(isHeavyApple(a));
        assertFalse(isHeavyApple(b));
    }

    @Test
    public void testFilterApplesReturnsAllApplesWhenPredicateIsTrue() {
        List<Apple> apples = Arrays.asList(new Apple(150, "green"), new Apple(80, "green"));
        assertEquals(apples, filterApples(apples, (Apple a) -> true));
    }

    @Test
    public void testFilterApplesReturnsEmptyListWhenPredicateIsFalse() {
        List<Apple> apples = Arrays.asList(new Apple(150, "green"), new Apple(80, "green"));
        assertEquals(Collections.emptyList(), filterApples(apples, (Apple a) -> false));
    }
}