package com.example.quiz2.Controller;

import com.example.quiz2.ApiResponse.APIResponse;
import com.example.quiz2.Model.Student;
import com.example.quiz2.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;//injection


    @GetMapping("/get-all-students")
    public ResponseEntity getAll() {
        if (studentService.getStudents().isEmpty()) {
            return ResponseEntity.status(400).body(new APIResponse("Array Empty"));

        }
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudents());
    }

    @PostMapping("/add-student")
    public ResponseEntity addStudent(@RequestBody @Valid Student student, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        studentService.addStudents(student);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Student " + student.getName() + " Added successfully"));


    }

    //---------------------------
    @PutMapping("/upadte-student/{id}")
    public ResponseEntity update(@PathVariable String id, @RequestBody @Valid Student student, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        if (studentService.update(id, student)) {
            return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Student" + student.getName() + "updated successfully"));
        }
        return ResponseEntity.status(400).body(new APIResponse("Student ID " + id + "not found "));
    }

    //---------------------------
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        if (studentService.delete(id)) {
            return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Delete Student ID " + id + " Successfully"));
        }
        return ResponseEntity.status(400).body(new APIResponse("Student ID " + id + " not found"));

    }

@GetMapping("/get-student/{name}")
    public ResponseEntity getStudent(@PathVariable String name){
        if (studentService.getstudentname(name)==null){
            return ResponseEntity.status(400).body(new APIResponse("Student with "+name+" not found"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getstudentname(name));
}

@GetMapping("/get-students-major/{major}")
    public ResponseEntity getStudentMajor(@PathVariable String major){
        if (studentService.majorList(major).isEmpty()){
            return ResponseEntity.status(400).body(new APIResponse("No Students with major"+major));
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentService.majorList(major));

}






}

