package org.launchcode.javacodingevents202011.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EventController {

    @GetMapping
    //handles GET requests to /events
    @RequestMapping("events")
    public String displayAllEvents(Model model){
        List<String> events = new ArrayList<>();
        events.add("Code With Pride");
        events.add("Strange Loop");
        events.add("Apple WWDC");
        events.add("SpringOne Platform");

        model.addAttribute("events", events);
        return "events/index";
    }
}
