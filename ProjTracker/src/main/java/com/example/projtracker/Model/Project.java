package com.example.projtracker.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Project {
 private String id,title,description,companyName;
 private boolean status;

}
