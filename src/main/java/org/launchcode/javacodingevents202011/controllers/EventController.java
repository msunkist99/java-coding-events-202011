package org.launchcode.javacodingevents202011.controllers;

import org.launchcode.javacodingevents202011.data.EventData;
import org.launchcode.javacodingevents202011.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class EventController {


    //handles GET requests to /events
    @GetMapping("events")
    public String displayAllEvents(Model model){
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    //handles GET requests to /events/create
    @GetMapping("events/create")
    public String renderCreateEventForm(Model model){
        model.addAttribute("title", "Create Event");
        // pass in an empty Event class
        model.addAttribute(new Event());
        return "events/create";
    }

//    //handles POST requests to /events/create
//    @PostMapping("/events/create")
//    public String processCreateEventForm(@RequestParam String eventName,
//                              @RequestParam String eventDescription){
//        EventData.add(new Event(eventName, eventDescription));
//
//        // the following redirects to /events
//        return "redirect:";
//    }

    //handles POST requests to /events/create
    //@ModelAttribute - Spring creates the Event model - newEvent
    @PostMapping("/events/create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent,
                                         Errors errors, Model model) {
        if(errors.hasErrors()){
            model.addAttribute("title", "CreateEvent");
            model.addAttribute("errorMsg", "Bad Data!");
            return "events/create";
        }
        EventData.add(newEvent);

        // the following redirects to /events
        return "redirect:";
    }

    @GetMapping("/events/remove")
    public String displayRemoveEventForm(Model model){
        model.addAttribute("title", "Remove Events");
        model.addAttribute("events", EventData.getAll());
        return "events/remove";
    }

    @PostMapping("events/remove")
    //@RequestParam(required = false) -- allows a null eventsId array to be passed
    //handles situation when nothing is selected to be removed
    public String processRemoveEventForm(@RequestParam(required = false) int[] eventIds){
        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
        // the following redirects to /events
        return "redirect:";
    }

    @GetMapping("/events/edit/{eventId}")
    public String displayEditEventForm(Model model, @PathVariable int eventId){
        Event eventData = EventData.getById(eventId);

        model.addAttribute("title", "Edit Event " + eventData.getName() + " (id=" + eventData.getId() + ")");
        model.addAttribute("event", EventData.getById(eventId));
        return "events/edit";
    }

    @PostMapping("/events/edit")
    public String processEditEventForm(int eventId, String name, String description){
        Event eventData = EventData.getById(eventId);

        eventData.setName(name);
        eventData.setDescription(description);

        // the following redirects to /events
        return "redirect:";
    }
}
