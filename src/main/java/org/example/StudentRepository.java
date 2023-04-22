package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * This is a class that contains 4 methods.
 *
 * @param : - List<Student> studentsList;
 */
public class StudentRepository {
    public List<Student> studentsList = new ArrayList<>();

    public void addStudent(Student student)  {
        studentsList.add(student);
        System.out.println("The student has been added to the Repository.");
    }
    public void deleteStudentByCnp(String cnp) throws ValidationException {
        boolean deleted = false;
        for (Iterator<Student> iterator = studentsList.iterator(); iterator.hasNext(); ) {
            Student student = iterator.next();

            if ((cnp==null)|| (cnp=="")){
                    throw  new ValidationException("Please enter a valid cnp.");
                }
            if (student.getCnp().equals(cnp)) {
                iterator.remove();
                System.out.println("The student with cnp: " + cnp + " was deleted.");
                deleted=true;

            }
        }
        if (!deleted){
            System.out.println("Cnp " + cnp + " does not exist in the list.");
        }
    }
    public List<Student> retrieveStudentsAfterAge(Integer age) {
        List<Student> studentsOfACertainAge = new ArrayList<>();

        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getAge() == age) {
                studentsOfACertainAge.add(studentsList.get(i));
            }
        }
        System.out.println("The students of age " + age + " are: ");
        return studentsOfACertainAge;
    }
    public void listStudentAfterLastName() {
        studentsList.sort(new SortByLastName());
        System.out.println("The list of students sort by Last Name is: " + studentsList);
    }
}

