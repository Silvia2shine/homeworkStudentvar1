package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This is a test class for the StudentRepository.
 *
 */
class StudentRepositoryTest {

    @Test
    void addValidStudent() throws ValidationException {
        Student student = new Student("Morarul", "Alexandru",
                LocalDate.of(1985, 2, 20), Gender.MALE, "1234567890987");
        StudentRepository repository = new StudentRepository();
        repository.addStudent(student);
        assertTrue(repository.studentsList.contains(student));
    }
    @Test
    void deleteStudentByCnp() throws ValidationException {
        Student student1 = new Student("Morarul", "Alexandru",
                LocalDate.of(1985, 2, 20), Gender.MALE, "1234567890987");
        Student student2 = new Student("Morarul", "Bogdan",
                LocalDate.of(1987, 2, 20), Gender.MALE, "1234853109879");
        StudentRepository repository = new StudentRepository();
        repository.addStudent(student1);
        repository.addStudent(student2);
        List<Student> studentsList = repository.studentsList;
        repository.deleteStudentByCnp("1234853109879");
        assertFalse(studentsList.contains(student2));
        assertTrue(studentsList.contains(student1));
    }
    @Test
    void deleteStudentByCnpInvalid() throws ValidationException {
        Student student = new Student("Morarul", "Alexandru",
                LocalDate.of(1985, 2, 20), Gender.MALE, "1234567890987");

        StudentRepository repository = new StudentRepository();
        repository.addStudent(student);

        List<Student> studentsList = repository.studentsList;
        repository.deleteStudentByCnp("12348hgjm9");
        assertTrue(studentsList.contains(student));

    }
    @Test
    void retrieveStudentsAfterAge() throws ValidationException {
        Student student1 = new Student("Morarul", "Alexandru",
                LocalDate.of(1985, 2, 20), Gender.MALE, "1234567890987");
        Student student2 = new Student("Morarul", "Bogdan",
                LocalDate.of(2003, 2, 20), Gender.MALE, "1234853109879");
        StudentRepository repository = new StudentRepository();
        repository.addStudent(student1);
        repository.addStudent(student2);
        List<Student> studentsOfAge20 = repository.retrieveStudentsAfterAge(20);

        assertTrue(studentsOfAge20.contains(student2));
        assertFalse(studentsOfAge20.contains(student1));
    }
    @Test
    void listStudentAfterLastName() throws ValidationException {
        Student student1 = new Student("Morarul", "Alexandru",
                LocalDate.of(1985, 2, 20), Gender.MALE, "1234567890987");
        Student student2 = new Student("Morarul", "Bogdan",
                LocalDate.of(2003, 2, 20), Gender.MALE, "1234853109879");
        StudentRepository repository = new StudentRepository();
        repository.addStudent(student1);
        repository.addStudent(student2);
        repository.listStudentAfterLastName();

        assertEquals(student1, repository.studentsList.get(0));
        assertEquals(student2, repository.studentsList.get(1));
    }
}