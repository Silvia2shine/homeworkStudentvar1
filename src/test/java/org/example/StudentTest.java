package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This is a test class for the Student class.
 *
 */
class StudentTest {
    @Test
    void createStudentValid() {
        assertDoesNotThrow(() -> new Student("Morar", "Adrian",
                LocalDate.of(1982, 2, 06), Gender.MALE, "1234567891234"));
    }
  @Test
    void createStudentWithFirstNameNUll()  {

        assertThrows(ValidationException.class, () -> {
           new Student("","Silvia",
                   LocalDate.of(2001,02,01),Gender.FEMALE, "1234567890987");
    });
    }
    @Test
    void createStudentWithLastNameNUll()  {

        assertThrows(ValidationException.class, () -> {
            new Student("Silvia","",
                    LocalDate.of(2001,02,01),Gender.FEMALE, "1234567890987");
        });
    }
    @Test
    void createStudentWithDateOfBirthNUll()  {

        assertThrows(ValidationException.class, () -> {
            new Student("Padurean","Silvia",
                    null,Gender.FEMALE, "1234567890987");
        });
    }
    @Test
    void createStudentWithDateOfBirthSmallerThan18()  {

        assertThrows(ValidationException.class, () -> {
            new Student("Padurean","Silvia",
                    LocalDate.of(2020,02,02),Gender.FEMALE, "1234567890987");
        });
    }
    @Test
    void createStudentWithGenderNUll()  {

        assertThrows(ValidationException.class, () -> {
            new Student("","Silvia",
                    LocalDate.of(2001,02,01),null, "1234567890987");
        });
    }
    @Test
    void createStudentWithCnpNUll()  {

        assertThrows(ValidationException.class, () -> {
            new Student("Padurean","Silvia",
                    LocalDate.of(2001,02,01),Gender.FEMALE, "");
        });
    }
    @Test

    void createStudentWithCnpInvalidBiggerThan13Chars()  {

        assertThrows(ValidationException.class, () -> {
            new Student("Padurean","Silvia",
                    LocalDate.of(2001,02,01),Gender.FEMALE, "12312312312312");
        });
    }
    @Test
    void createStudentWithCnpContainingOthersChars()  {

        assertThrows(ValidationException.class, () -> {
            new Student("Padurean","Silvia",
                    LocalDate.of(2001,02,01),Gender.FEMALE, "12jbffvb");
        });
    }


}


