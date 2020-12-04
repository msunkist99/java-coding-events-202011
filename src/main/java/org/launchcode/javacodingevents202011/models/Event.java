package org.launchcode.javacodingevents202011.models;

import javax.validation.constraints.*;
import java.util.Objects;

public class Event {
    @NotBlank(message="Name is required")
    @Size(min=3, max=50, message="Name must be between 3 and 50 characters")
    private String name;

    @Size(max=500, message="Description too long, must be 500 characters or less!")
    private String description;

    @NotBlank(message="Contact email is required")
    @Email(message="Invalid email, try again")
    private String contactEmail;

    @NotBlank(message="Location is required")
    private String location;

    @AssertTrue(message = "Registration must be TRUE")
    private boolean registration;

    @Min(value=1, message = "Attendee count must be more than 0")
    private int attendeeCount;

    @Max(value = 5, message = "enter a rating of 1 - 5")
    private int rating;

    private int id;
    private static int nextId = 0;

    //noArg constructor
    public Event(){}

    //constructor
    public Event(String name,
                 String description,
                 String contactEmail,
                 String location,
                 boolean registration,
                 int attendeeCount,
                 int rating) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.registration = registration;
        this.attendeeCount = attendeeCount;
        this.rating = rating;

        this.id = ++nextId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean getRegistration() {
        return registration;
    }

    public void setRegistration(boolean registration) {
        this.registration = registration;
    }

    public int getAttendeeCount() {
        return attendeeCount;
    }

    public void setAttendeeCount(int attendeeCount) {
        this.attendeeCount = attendeeCount;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Event.nextId = nextId;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
