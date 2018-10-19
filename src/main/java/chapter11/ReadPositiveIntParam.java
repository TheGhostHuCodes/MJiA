package chapter11;

import java.util.Optional;
import java.util.Properties;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

public class ReadPositiveIntParam {

    public static int readDurationImperative(Properties props, String name) {
        String value = props.getProperty(name);
        if (value != null) {
            try {
                int i = Integer.parseInt(value);
                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException nfe) {
            }
        }
        return 0;
    }

    public static int readDurationWithOptional(Properties props, String name) {
        return ofNullable(props.getProperty(name))
                .flatMap(ReadPositiveIntParam::stringToOptionalInt)
                .filter(i -> i > 0)
                .orElse(0);
    }

    public static Optional<Integer> stringToOptionalInt(String s) {
        try {
            return of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return empty();
        }
    }

}
