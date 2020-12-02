package org.launchcode.javacodingevents202011.data;

import org.launchcode.javacodingevents202011.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {
    // need a place to put events
    // code to the Map interface type
    // final - events cannot change once created but the data inside events can change
    private static final Map<Integer, Event> events = new HashMap<>();

    // get all events
    // Collection is an interface
    public static Collection<Event> getAll(){
        // returns only the values from the events HashMap, not the keys
        return events.values();
    }

    // get single event
    public static Event getById(int id) {
        return events.get(id);
    }

    // add an event
    public static void add(Event event){
        events.put(event.getId(), event);
    }

    // remove an event
    public static void remove(int id){
        events.remove(id);
    }

}
