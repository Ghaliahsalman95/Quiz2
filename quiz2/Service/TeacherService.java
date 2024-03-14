package com.example.quiz2.Service;

import com.example.quiz2.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {

    ArrayList<Teacher>teachers=new ArrayList<>();

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeachers(Teacher teacher) {
        teachers.add(teacher);
    }

    public boolean update(String id, Teacher teacher){
        for (int i=0;i<teachers.size();i++){
            if (teachers.get(i).getID().equalsIgnoreCase(id)){
                teachers.set(i,teacher);
                return true;
            }
        }return false;
    }

    public boolean delete(String id){
        for (Teacher teacher:teachers){
            if (teacher.getID().equalsIgnoreCase(id)){
                teachers.remove(teacher);
                return true;
            }
        }return false;
    }
    //----------------------------
    public Teacher getTeacher(String id){
        for (Teacher teacher:teachers){
            if (teacher.getID().equalsIgnoreCase(id)){
                return teacher;
            }
    }return null;


}
 public ArrayList<Teacher> getSalary(double salary){
        ArrayList<Teacher> teachersSalary=new ArrayList<>();
        for (Teacher teacher:teachers){
            if (teacher.getSalary()>=salary){
                teachersSalary.add(teacher);
            }
        }return teachersSalary;

    }


}


