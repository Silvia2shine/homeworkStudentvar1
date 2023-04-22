package org.example;

import java.time.LocalDate;

/**
 * The class App. It contains the main method.
 * There are created 3 Students, which are added to the StudentRepository.
 * The Students are listed. One student is deleted. There are listed all Students with age 38.
 *
 * @author : Silvia Padurean
 */
public class App {
    public static void main(String[] args)  {
Student student1 = null;
        try {
          student1 = new Student("Silvia", "silvia",
                    LocalDate.of(1980, 3, 06),
                  Gender.FEMALE, "2345678909876");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());

        }
        Student student2 = null;
        try {
             student2 = new Student("Silvia", "Adrian",
                    LocalDate.of(1982, 2, 06), Gender.MALE, "1234567890987");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());

        }
        Student student3 = null;
        try {
            student3 = new Student("Morar", "Alexandru",
                    LocalDate.of(1985, 2, 20), Gender.MALE, "7654321234567");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }


        StudentRepository studentRepository = new StudentRepository();

        studentRepository.addStudent(student1);
        studentRepository.addStudent(student2);
        studentRepository.addStudent(student3);

        studentRepository.listStudentAfterLastName();


        try {
            studentRepository.deleteStudentByCnp("");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

        studentRepository.listStudentAfterLastName();

        System.out.println(studentRepository.retrieveStudentsAfterAge(38));
    }
}
