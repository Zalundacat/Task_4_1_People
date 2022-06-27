import org.junit.jupiter.api.*;

import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonBuilderTest {

    @Test
    public void setNameTest() {
        String testName = "Вася";
        Person testPerson = new PersonBuilder()
                .setName("Анна")
                .setName(testName)
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        String name = testPerson.getName();
        Assertions.assertEquals(testName, name);
    }

    @Test
    public void setSurnameTest() {
        String testSurname = "Пупкин";
        Person testPerson = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setSurname(testSurname)
                .setAge(31)
                .setAddress("Сидней")
                .build();
        String surname = testPerson.getSurname();
        Assertions.assertEquals(testSurname, surname);
    }

    @Test
    public void setAgeTest() {
        int testAge = 50;
        Person testPerson = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAge(testAge)
                .setAddress("Сидней")
                .build();
        OptionalInt age = testPerson.getAge();
        Assertions.assertEquals(testAge, age.getAsInt());
    }

    @Test
    public void itShouldThrowIllegalStateException() {
        assertThrows(IllegalStateException.class,
                new PersonBuilder()
                        .setName("Вася")
                        .setAge(50)
                        .setAddress("Сидней")::build);
    }

    @Test
    public void itShouldAgeThrowIllegalStateException() {
        assertThrows(IllegalStateException.class,
                () -> new PersonBuilder()
                        .setName("Вася")
                        .setAge(-139)
                        .build());
    }
}