package com.example.eventsystem.Controller;

import com.example.eventsystem.Api.ApiResponse;
import com.example.eventsystem.Model.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event")
public class EventSystemController {
ArrayList<Event> events=new ArrayList<>();

@GetMapping("/get")
public ArrayList<Event>getEvents(){
    return events;
}

@PostMapping("/add")
public ApiResponse addevent(@RequestBody Event event){
    events.add(event);
    return new ApiResponse("event has added ");
}

@PutMapping("/update/{index}")
public ApiResponse updateEvent(@PathVariable int index,@RequestBody Event event){
    events.set(index,event);
    return new ApiResponse("event has updated");
}
@DeleteMapping("/delete/{index}")
public ApiResponse deleteEvent(@PathVariable int index){
    events.remove(index);
    return new ApiResponse("event has removed");
}

@PutMapping("/changeCapacity/{id}/{capacity}")
public ApiResponse changeCapacity(@PathVariable int capacity,@PathVariable String id){
    for(Event e:events){
        if(e.getId().equals(id)){
            e.setCapacity(capacity);
            return new ApiResponse("Capasity has changed");
        }
    }
    return new ApiResponse("Event not found ");
}


@GetMapping("/getevent/{id}")
public Event getEvent(@PathVariable String id){
    for(Event e:events){
        if(e.getId().equals(id)){
            return e;
        }
    }
    return null;
}




































}
