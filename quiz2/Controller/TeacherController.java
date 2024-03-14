package com.example.quiz2.Controller;

import com.example.quiz2.ApiResponse.APIResponse;
import com.example.quiz2.Model.Teacher;
import com.example.quiz2.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;//injection

    @GetMapping("/get-all-teacher")
    public ResponseEntity getall(){
        if(teacherService.getTeachers().isEmpty())
            return ResponseEntity.status(400).body(new APIResponse("Empty"));
    return ResponseEntity.status(HttpStatus.OK).body(teacherService.getTeachers());}

  @PostMapping("/add-teacher")
    public ResponseEntity add(@RequestBody @Valid Teacher teacher, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        teacherService.addTeachers(teacher);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Added successfully"));


    }
    @PutMapping("/update/{id}")
public ResponseEntity update(@PathVariable String id,@RequestBody @Valid Teacher teacher,Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        if(teacherService.update(id,teacher)){
            return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Teacher ID"+id+"Updated successfully"));
        }return ResponseEntity.status(400).body(new APIResponse("Not found teacher with ID"+id));
    }
@DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id){
        if (teacherService.delete(id)){
            return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Teacher ID"+id+"delete successfully"));

        }return ResponseEntity.status(400).body(new APIResponse("Not found teacher with ID"+id));
}
//----------------------------------------
    @GetMapping("/get-teacher/{id}")
public ResponseEntity getTeacher(@PathVariable String id){
        if (teacherService.getTeacher(id)==null){
            return ResponseEntity.status(400).body(new APIResponse("Not found teacher with ID"+id));
        }
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getTeacher(id));
    }
@GetMapping("/get-teachers/{salary}")
    public ResponseEntity getTeacherSalary(@PathVariable double salary){
        if (teacherService.getSalary(salary).isEmpty()){
            return ResponseEntity.status(400).body(new APIResponse("No teachers with salary "+salary));
        }return ResponseEntity.status(HttpStatus.OK).body(teacherService.getSalary(salary));
}

}
