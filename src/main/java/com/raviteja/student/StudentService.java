package com.raviteja.student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> students = new ArrayList<>();
    private int nextId = 1;

    public Student addStudent(String name, int age, String course) {
        Student s = new Student(nextId++, name, age, course);
        students.add(s);
        return s;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student findById(int id) throws StudentNotFoundException {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found!"));
    }

    public boolean deleteById(int id) throws StudentNotFoundException {
        Student s = findById(id);
        return students.remove(s);
    }

    public int getTotalCount() {
        return students.size();
    }
}