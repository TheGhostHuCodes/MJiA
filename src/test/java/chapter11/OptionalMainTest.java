package chapter11;

import org.junit.Test;

import java.util.*;

import static chapter11.OptionalMain.*;
import static java.util.Optional.of;
import static java.util.Optional.empty;
import static org.junit.Assert.*;

public class OptionalMainTest {

    @Test
    public void testGetCarInsuranceNameNullSafeV1ReturnsInsuranceName() {
        Insurance insurance = new Insurance("myInsurance");
        CarV1 carWithInsurance = new CarV1();
        carWithInsurance.setInsurance(insurance);
        PersonV1 personWithCarWithInsurance = new PersonV1();
        personWithCarWithInsurance.setCar(carWithInsurance);

        assertEquals("myInsurance", getCarInsuranceNameNullSafeV1(personWithCarWithInsurance));
    }

    @Test
    public void testGetCarInsuranceNameNullSafeV1ReturnsUnknownWhenEncounteringNullProperty() {
        PersonV1 nullPerson = null;
        CarV1 nullCar = null;
        Insurance nullInsurance = null;

        PersonV1 personWithNullCar = new PersonV1();
        personWithNullCar.setCar(nullCar);

        PersonV1 personWithCarWithNullInsurance = new PersonV1();
        CarV1 carWithNullInsurance = new CarV1();
        carWithNullInsurance.setInsurance(nullInsurance);
        personWithCarWithNullInsurance.setCar(carWithNullInsurance);

        assertEquals("Unknown", getCarInsuranceNameNullSafeV1(nullPerson));
        assertEquals("Unknown", getCarInsuranceNameNullSafeV1(personWithNullCar));
        assertEquals("Unknown", getCarInsuranceNameNullSafeV1(personWithCarWithNullInsurance));
    }

    @Test
    public void testGetCarInsuranceNullSafeV2ReturnsInsuranceName() {
        Insurance insurance = new Insurance("myInsurance");
        CarV1 carWithInsurance = new CarV1();
        carWithInsurance.setInsurance(insurance);
        PersonV1 personWithCarWithInsurance = new PersonV1();
        personWithCarWithInsurance.setCar(carWithInsurance);

        assertEquals("myInsurance", getCarInsuranceNameNullSafeV2(personWithCarWithInsurance));
    }

    @Test
    public void testGetCarInsuranceNameNullSafeV2ReturnsUnknownWhenEncounteringNullProperty() {
        PersonV1 nullPerson = null;
        CarV1 nullCar = null;
        Insurance nullInsurance = null;

        PersonV1 personWithNullCar = new PersonV1();
        personWithNullCar.setCar(nullCar);

        PersonV1 personWithCarWithNullInsurance = new PersonV1();
        CarV1 carWithNullInsurance = new CarV1();
        carWithNullInsurance.setInsurance(nullInsurance);
        personWithCarWithNullInsurance.setCar(carWithNullInsurance);

        assertEquals("Unknown", getCarInsuranceNameNullSafeV2(nullPerson));
        assertEquals("Unknown", getCarInsuranceNameNullSafeV2(personWithNullCar));
        assertEquals("Unknown", getCarInsuranceNameNullSafeV2(personWithCarWithNullInsurance));
    }

    @Test
    public void testGetCarInsuranceNameReturnsInsuranceName() {
        Insurance insurance = new Insurance("myInsurance");
        Car carWithInsurance = new Car();
        carWithInsurance.setInsurance(of(insurance));
        Person personWithCarWithInsurance = new Person();
        personWithCarWithInsurance.setCar(of(carWithInsurance));

        assertEquals("myInsurance", getCarInsuranceName(of(personWithCarWithInsurance)));
    }

    @Test
    public void testGetCarInsuranceNameReturnsUnknownWhenEncounteringEmptyProperty() {
        Optional<Person> emptyPerson = empty();
        Optional<Car> emptyCar = empty();
        Optional<Insurance> emptyInsurance = empty();

        Person personWithEmptyCar = new Person();
        personWithEmptyCar.setCar(emptyCar);

        Person personWithCarWithEmptyInsurance = new Person();
        Car carWithEmptyInsurance = new Car();
        carWithEmptyInsurance.setInsurance(emptyInsurance);
        personWithCarWithEmptyInsurance.setCar(of(carWithEmptyInsurance));

        assertEquals("Unknown", getCarInsuranceName(emptyPerson));
        assertEquals("Unknown", getCarInsuranceName(of(personWithEmptyCar)));
        assertEquals("Unknown", getCarInsuranceName(of(personWithCarWithEmptyInsurance)));
    }

    private static Person makePersonWithCarAndInsurance(String insuranceName) {
        Insurance insurance = new Insurance(insuranceName);
        Car carWithInsurance = new Car();
        carWithInsurance.setInsurance(of(insurance));
        Person personWithCarWithInsurance = new Person();
        personWithCarWithInsurance.setCar(of(carWithInsurance));
        return personWithCarWithInsurance;
    }

    private static Person makePersonWithCarAndInsurance(int age, String insuranceName) {
        Insurance insurance = new Insurance(insuranceName);
        Car carWithInsurance = new Car();
        carWithInsurance.setInsurance(of(insurance));
        Person personWithCarWithInsurance = new Person();
        personWithCarWithInsurance.setAge(age);
        personWithCarWithInsurance.setCar(of(carWithInsurance));
        return personWithCarWithInsurance;
    }

    @Test
    public void testGetCarInsuranceNamesReturnsSetOfInsuranceNames() {
        List<Person> people = Arrays.asList(
                makePersonWithCarAndInsurance("InsuranceCo1"),
                makePersonWithCarAndInsurance("InsuranceCo2"),
                makePersonWithCarAndInsurance("InsuranceCo3")
        );
        Set<String> expected = new HashSet<>(Arrays.asList("InsuranceCo1", "InsuranceCo2", "InsuranceCo3"));

        assertEquals(expected, getCarInsuranceNames(people));
    }

    @Test
    public void testNullSafeCheapestInsuranceReturnsEmptyWhenEitherParameterIsEmpty() {
        Person p = new Person();
        Car c = new Car();

        assertEquals(empty(), nullSafeFindCheapestInsurance(empty(), empty()));
        assertEquals(empty(), nullSafeFindCheapestInsurance(of(p), empty()));
        assertEquals(empty(), nullSafeFindCheapestInsurance(empty(), of(c)));
    }

    @Test
    public void testNullSafeCheapestInsuranceReturnsCheapCoWhenBothParametersExist() {
        Person p = new Person();
        Car c = new Car();

        String actual = nullSafeFindCheapestInsurance(of(p), of(c))
                .map(Insurance::getName)
                .orElseThrow(RuntimeException::new);

        assertEquals("CheapCo", actual);
    }

    @Test
    public void testNullSafeCheapestInsuranceQuizReturnsEmptyWhenEitherParameterIsEmpty() {
        Person p = new Person();
        Car c = new Car();

        assertEquals(empty(), nullSafeFindCheapestInsuranceQuiz(empty(), empty()));
        assertEquals(empty(), nullSafeFindCheapestInsuranceQuiz(of(p), empty()));
        assertEquals(empty(), nullSafeFindCheapestInsuranceQuiz(empty(), of(c)));
    }

    @Test
    public void testNullSafeCheapestInsuranceQuizReturnsCheapCoWhenBothParametersExist() {
        Person p = new Person();
        Car c = new Car();

        String actual = nullSafeFindCheapestInsuranceQuiz(of(p), of(c))
                .map(Insurance::getName)
                .orElseThrow(RuntimeException::new);

        assertEquals("CheapCo", actual);
    }

    @Test
    public void testGetCarInsuranceNameFiltersOnAgeBeforeReturningInsuranceName() {
        Person a = makePersonWithCarAndInsurance(18, "InsuranceCo1");
        Person b = makePersonWithCarAndInsurance(20, "InsuranceCo2");
        Person c = makePersonWithCarAndInsurance(42, "InsuranceCo3");

        assertEquals("Unknown", getCarInsuranceName(empty(), 20));
        assertEquals("Unknown", getCarInsuranceName(of(a), 20));
        assertEquals("InsuranceCo2", getCarInsuranceName(of(b), 20));
        assertEquals("InsuranceCo3", getCarInsuranceName(of(c), 20));
    }

}