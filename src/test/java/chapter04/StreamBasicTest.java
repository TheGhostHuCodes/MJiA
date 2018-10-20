package chapter04;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static chapter04.StreamBasic.*;
import static org.junit.Assert.*;

public class StreamBasicTest {

    @Test
    public void testGetLowCaloricDishesNamesInJava7GeneratesCorrectList() {
        List<String> expected = Arrays.asList("season fruit", "rice");

        assertEquals(expected, getLowCaloricDishesNamesInJava7(Dish.menu));
    }

    @Test
    public void testGetLowCaloricDishesNamesInJava8GeneratesCorrectList() {
        List<String> expected = Arrays.asList("season fruit", "rice");
        assertEquals(expected, getLowCaloricDishesNamesInJava8(Dish.menu));
    }
}