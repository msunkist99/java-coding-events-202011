package org.launchcode.javacodingevents202011.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EventController {
    private static List<String> events = new ArrayList<>();

    //handles GET requests to /events
    @GetMapping("events")
    public String displayAllEvents(Model model){
        model.addAttribute("events", events);
        return "events/index";
    }

    //handles GET requests to /events/create
    @GetMapping("events/create")
    public String renderCreateEventForm(){
        return "events/create";
    }

    //handles POST requests to /events/create
    @PostMapping("/events/create")
    public String createEvent(@RequestParam String eventName){
        events.add(eventName);
        // the following redirects to /events
        return "redirect:";
    }
}
