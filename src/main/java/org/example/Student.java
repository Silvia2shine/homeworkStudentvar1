package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
/**
 * This is a class that creates a Student. It throws exceptions when the data is not valid..
 *
 * @param : firstName;
 * @param : lastName;
 * @param : dateOfBirth;
 * @param : gender;
 * @param : cnp;
 */
public class Student {

    String firstName;
    String lastName;
    LocalDate dateOfBirth;
    Gender gender;
    String cnp;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, Gender gender, String cnp) throws ValidationException {
        if (firstName == null || firstName == "") {
            throw new ValidationException("Student first name can't be null.");
        }
        this.firstName = firstName;

        if (lastName == null || lastName == "") {
            throw new ValidationException("Student last name can't be null.");
        }
        this.lastName = lastName;

        if (dateOfBirth == null) {
            throw new ValidationException("Student date of birth can't be null.");
        }
        if (LocalDate.now().getYear() - dateOfBirth.getYear() <= 18) {
            throw new ValidationException("The student is not yet 18 years");
        }
        this.dateOfBirth = dateOfBirth;

        if (gender == null || gender.equals("")) {
            throw new ValidationException("Student gender can't be null.");
        }
        if ((gender != Gender.MALE) && (gender != Gender.FEMALE)) {
            throw new ValidationException("Gender must be either male or female.");
        }
        this.gender = gender;

        if (cnp == null || cnp == "") {
            throw new ValidationException("Student cnp can't be null.");
        }
        if ((cnp.toCharArray().length != 13)) {
            throw new ValidationException("cnp must be of length 13. ");
        }
        if (!cnp.matches("[0-9]+")) {
            throw new ValidationException("The cnp doesn't contains only numbers.");
        }
        this.cnp = cnp;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", cnp='" + cnp + '\'' +
                '}';
    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public LocalDate getDateOfBirth() {
//        return dateOfBirth;
//    }

    public String getCnp() {
        return cnp;
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dateOfBirth, currentDate);
        return period.getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Student student = (Student) o;

        if (!Objects.equals(cnp, student.cnp)) {
            return false;
        }

        return Objects.equals(cnp, student.cnp);
    }

}
