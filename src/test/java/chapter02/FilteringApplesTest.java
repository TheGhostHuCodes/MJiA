package chapter02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import chapter02.FilteringApples.*;

import static org.junit.Assert.*;
import static chapter02.FilteringApples.*;

public class FilteringApplesTest {

    @Test
    public void testAppleColorAndWeightCanBeSet() {
        Apple a = new Apple(80, Color.GREEN);
        a.setWeight(42);
        a.setColor(Color.RED);

        assertEquals(42, a.getWeight());
        assertEquals(Color.RED, a.getColor());
    }

    @Test
    public void testFilterGreenApplesFiltersGreenApples() {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        );
        List<Apple> expected = new ArrayList<>(Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN)
        ));

        assertEquals(expected, filterGreenApples(inventory));
    }

    @Test
    public void testFilterApplesByColorFiltersRedApples() {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        );
        List<Apple> expected = new ArrayList<>(Arrays.asList(
                new Apple(120, Color.RED)
        ));

        assertEquals(expected, filterApplesByColor(inventory, Color.RED));
    }

    @Test
    public void testFilterApplesByWeightFiltersHeavyApples() {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        );
        List<Apple> expected = new ArrayList<>(Arrays.asList(
                new Apple(155, Color.GREEN)
        ));

        assertEquals(expected, filterApplesByWeight(inventory, 150));
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
    public void testAppleColorPredicateReturnsTrueWhenColorIsGreen() {
        ApplePredicate p= new AppleColorPredicate();
        Apple a = new Apple(80, Color.GREEN);

        assertTrue(p.test(a));
    }

    @Test
    public void testAppleColorPredicateReturnsTrueWhenColorIsNotGreen() {
        ApplePredicate p= new AppleColorPredicate();
        Apple a = new Apple(80, Color.RED);

        assertFalse(p.test(a));
    }

    @Test
    public void testAppleWeightPredicateReturnsTrueWhenHeavy() {
        ApplePredicate p = new AppleWeightPredicate();
        Apple a = new Apple(200, Color.GREEN);

        assertTrue(p.test(a));
    }

    @Test
    public void testAppleWeightPredicateReturnsFalseWhenNotHeavy() {
        ApplePredicate p = new AppleWeightPredicate();
        Apple a = new Apple(150, Color.GREEN);
        Apple b = new Apple(80, Color.RED);

        assertFalse(p.test(a));
        assertFalse(p.test(b));
    }

    @Test
    public void testAppleRedAndHeavyPredicateReturnsTrueWhenRedAndHeavy() {
        ApplePredicate p = new AppleRedAndHeavyPredicate();
        Apple a = new Apple(151, Color.RED);

        assertTrue(p.test(a));
    }

    @Test
    public void testAppleRedAndHeavyPredicateReturnsFalseWhenNotRedOrHeavy() {
        ApplePredicate p = new AppleRedAndHeavyPredicate();
        Apple a = new Apple(80, Color.RED);
        Apple b = new Apple(151, Color.GREEN);
        Apple c = new Apple(80, Color.GREEN);

        assertFalse(p.test(a));
        assertFalse(p.test(b));
        assertFalse(p.test(c));
    }
}