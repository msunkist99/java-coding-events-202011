package org.launchcode.javacodingevents202011.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class EventController {

    HashMap<String, String> events = new HashMap<>();

    @GetMapping
    //handles GET requests to /events
    @RequestMapping("events")
    public String displayAllEvents(Model model){
        events.put("Code With Pride", "Code with Pride is an affinity group, hosted by LaunchCode and 1904labs, that aims to help underrepresented groups succeed in the tech industry.");
        events.put("Strange Loop", "Meet us in St. Louis to make connections with the creators and users of the languages, libraries, tools, and techniques at the forefront of the industry.");
        events.put("Apple WWDC", "Join us for a WWDC like never before — with a jam-packed, all-online experience coming to you from Apple Park. Watch the videos.");
        events.put("SpringOne Platform", "Watch SpringOne Main Stage sessions below. If you missed any of the live action, Breakout Sessions and Self-Paced Workshops are now available.");
        model.addAttribute("events", events);

        return "events/index";
    }
}
