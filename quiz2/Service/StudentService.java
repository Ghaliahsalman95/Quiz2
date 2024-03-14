package com.example.quiz2.Service;

import com.example.quiz2.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    ArrayList<Student>students=new ArrayList<>();

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudents(Student student) {
        students.add(student);
    }

    public boolean update(String id,Student student) {
        for (int i=0;i<students.size();i++){
            if(students.get(i).getID().equalsIgnoreCase(id)){
                students.set(i,student);
                return true;
            }
        }return false;
    }
    //----------------------
    public boolean delete(String id){
        for (Student student:students){
            if (student.getID().equalsIgnoreCase(id)){
                students.remove(student);
                return true;
            }
        }return false;
    }
    //------------------------------

    public Student getstudentname(String name){
        for (Student student:students){
            if (student.getName().equalsIgnoreCase(name)){
                return student;
            }
        }return null;
    }

    public ArrayList<Student> majorList(String major){
        ArrayList<Student> studentsMajor=new ArrayList<>();
        for (Student student:students){
            if (student.getMajor().equalsIgnoreCase(major)){
                studentsMajor.add(student);
            }
        }return studentsMajor;
    }
}
