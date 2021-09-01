import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleParameterzTest {
    @Test
    void contextLoads() {
    }

    @ParameterizedTest
    @CsvSource({
            "Jane, Doe, F",
            "John, Doe, M"
    })
    void testWithArgumentsAccessor(ArgumentsAccessor arguments) {
        Person person = new Person(arguments.getString(0),
                arguments.getString(1),
                arguments.get(2, Gender.class));

        if (person.getFirstName().equals("Jane")) {
            assertEquals(Gender.F, person.getGender());
        } else {
            assertEquals(Gender.M, person.getGender());
        }
        assertEquals("Doe", person.getLastName());
    }
}

class Person {
    private String firstName;
    private String lastName;
    private Gender gender;

    public <T> Person(String string, String string1, T t) {
        firstName = string;
        lastName = string1;
        gender = (Gender) t;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Gender getGender() {
        return gender;
    }
}

enum Gender {
    F, M
}
