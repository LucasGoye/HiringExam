package com.goyeneche.services;

import com.goyeneche.models.Student;
import com.goyeneche.models.Subject;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentService {


    public List<Student> getStudents() {
        Student a = new Student("Robert", "Alder");
        Student b = new Student("Paul", "Alder");
        Student c = new Student("Harry", "Bates");
        Student d = new Student("Susan", "Bones");
        Student e = new Student("Patricia", "Halls");
        Student f = new Student("Claire", "Jonhson");
        Student g = new Student("Paul", "Keys");
        Student h = new Student("Sabrina", "Mullen");
        Student i = new Student("George", "Sharman");
        Student j = new Student("Jonh", "Smith");

        return Arrays.asList(a, b, c, d, e, f ,g ,h ,i ,j);
    }

    public Map<Character, List<Student>> studentGroupByLastName(List<Student> persons) {
        return persons.stream().collect(Collectors.groupingBy(p ->
                p.getLastName().charAt(0)
        ));
    }

    public List<Student> getbySubject(Subject subject) {
            return subject.getStudents();
    }
}
