package chapter03;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static chapter03.Lambdas.*;
import static chapter03.Sorting.*;
import static org.junit.Assert.*;

public class AppleTest {

    @Test
    public void testGetWeightReturnsAppleWeight() {
        Apple a = new Apple(42, Color.GREEN);

        assertEquals(42, a.getWeight());
    }

    @Test
    public void testSetWeightSetsAppleWeight() {
        Apple a = new Apple(42, Color.GREEN);
        a.setWeight(10);

        assertEquals(10, a.getWeight());
    }

    @Test
    public void testGetColorReturnsAppleColor() {
        Apple a = new Apple(42, Color.GREEN);

        assertEquals(Color.GREEN, a.getColor());
    }

    @Test
    public void testSetColorSetsAppleColor() {
        Apple a = new Apple(42, Color.GREEN);
        a.setColor(Color.RED);

        assertEquals(Color.RED, a.getColor());
    }

    @Test
    public void testFilterReturnsAllApplesWhenPredicateIsTrue() {
        List<Apple> apples = Arrays.asList(new Apple(150, Color.GREEN), new Apple(80, Color.GREEN));

        assertEquals(apples, filter(apples, (Apple a) -> true));
    }

    @Test
    public void testFilterReturnsEmptyListWhenPredicateIsFalse() {
        List<Apple> apples = Arrays.asList(new Apple(150, Color.GREEN), new Apple(80, Color.GREEN));

        assertEquals(Collections.emptyList(), filter(apples, (Apple a) -> false));
    }

    @Test
    public void testAppleComparatorComparesApplesByWeight() {
        List<Apple> apples = new ArrayList<>(Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        ));
        List<Apple> expected = new ArrayList<>(Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(120, Color.RED),
                new Apple(155, Color.GREEN)
        ));

        apples.sort(new AppleComparator());

        assertEquals(expected, apples);
    }

}