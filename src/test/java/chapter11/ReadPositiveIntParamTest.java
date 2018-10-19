package chapter11;

import java.util.Properties;

import org.junit.Test;

import static chapter11.ReadPositiveIntParam.*;
import static org.junit.Assert.*;

public class ReadPositiveIntParamTest {

    @Test
    public void testReadPositiveIntParamWorksCorrectly() {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

        assertEquals(5, readDurationImperative(props, "a"));
        assertEquals(0, readDurationImperative(props, "b"));
        assertEquals(0, readDurationImperative(props, "c"));
        assertEquals(0, readDurationImperative(props, "d"));

        assertEquals(5, readDurationWithOptional(props, "a"));
        assertEquals(0, readDurationWithOptional(props, "b"));
        assertEquals(0, readDurationWithOptional(props, "c"));
        assertEquals(0, readDurationWithOptional(props, "d"));
    }

}