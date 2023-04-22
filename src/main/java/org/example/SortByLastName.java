package org.example;

import java.util.Comparator;

/**
 * This is a class that implements the Comparator class.
 * It will compare after LastName of the Student class.
 */
public class SortByLastName implements Comparator<Student> {
    /**
     * This is a method that override the compare method.
     */
    @Override
    public int compare (Student e1, Student e2) {

        return (e1.lastName).compareTo(e2.lastName);
    }

}
