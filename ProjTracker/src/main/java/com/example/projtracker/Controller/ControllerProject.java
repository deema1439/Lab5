package com.example.projtracker.Controller;

import com.example.projtracker.apiResponse.ApiRespones;
import com.example.projtracker.Model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/project")
public class ControllerProject {
  ArrayList<Project> projects=new ArrayList<>();
  //Read=Get
    //Creat=post
    //Update=put
    //Delete=delete

    @GetMapping("/get")
    public ArrayList<Project> getProjects(){
        return projects;
    }

    @PostMapping("/add")
    public ApiRespones addProject(@RequestBody Project project){
        projects.add(project);
        return new ApiRespones("project has been added ");
    }


    @PutMapping("/update/{index}")
    public ApiRespones updateProject(@PathVariable int index,@RequestBody Project project){
        projects.set(index,project);
        return new ApiRespones("project has been updated ");
    }

    @DeleteMapping("/delete/{index}")
    public ApiRespones deleteProject(@PathVariable int index){
        projects.remove(index);
        return new ApiRespones("project has been removed");
    }

    @PutMapping("/changeStatus/{id}/{status}")
    public ApiRespones changeStatus(@PathVariable boolean status,@PathVariable String id) {
        for (Project p : projects) {
            if (p.getId().equals(id)) {
                p.setStatus(status);
                if (status) {
                    return new ApiRespones("done");
                } else {
                    return new ApiRespones("not done");

                }
            }

        }
        return new ApiRespones("project not found. ");
    }

    @GetMapping("/gettitle/{title}")
    public Project Searchproject(@PathVariable String title){
        for(Project p:projects){
            if(p.getTitle().equals(title)){
                return p;
            }
        }
        return null;
    }

    @GetMapping("/getcompneyName/{companyName}")
    public ArrayList<Project>getCompnyNameProgects(@PathVariable String companyName){
        ArrayList<Project>result=new ArrayList<>();
        for(Project p:projects){
            if(p.getCompanyName().equals(companyName)){
               result.add(p);
            }
        }
        return result;
    }


























}
