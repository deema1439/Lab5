package com.example.studenproject.Controller;

import com.example.studenproject.ApiResponse.ApiResponse;
import com.example.studenproject.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    ArrayList<Student>students=new ArrayList<>();
    //Read-Get
    //Creat-post
    //update-put
    //delete-delete


    @GetMapping("/get")
    public ArrayList<Student>Getstudents(){
        return students;
    }

    @PostMapping("/add")
    public ApiResponse AddStudent(@RequestBody Student student){
        students.add(student);
        return new ApiResponse("student added");
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateStudent(@PathVariable int index,@RequestBody Student student){
        students.set(index,student);
        return new ApiResponse("student updated");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteStudent(@PathVariable int index){
        students.remove(index);
        return new ApiResponse("student has been removed");
    }

    @GetMapping("/gethoner/{id}")
    public ApiResponse classify(@PathVariable String id){
        for(Student s:students){
            if(s.getId().equals(id)){
                if(s.getGPA()>=3.75&&s.getGPA()<=4.00){
                    return new ApiResponse("first honor");
                }else if(s.getGPA()>=3.50&&s.getGPA()<=3.74){
                    return new ApiResponse("Second Honor");
                }else{
                    return new ApiResponse("no honor");
                }
            }
        }
        return new ApiResponse("no student id Availble");
    }

    @GetMapping("/getgreaterGpa")
    public ArrayList<Student> getGroupofStudent(){
        ArrayList<Student>result=new ArrayList<>();
        double avrage=0;
        double sum=0;
        for(Student s:students){
            sum+=s.getGPA();
        }
        avrage=sum/students.size();
        for(Student s:students){
            if(s.getGPA()>avrage){
                result.add(s);
            }
        }
        return result;
    }























}
