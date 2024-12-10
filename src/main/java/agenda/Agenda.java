package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {

    ArrayList<Event> events = new ArrayList<>();
    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */

    public void addEvent(Event e) {
        events.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return a list of events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        ArrayList<Event> Events = new ArrayList<Event>();
        for (Event e : events) {
            if (e.isInDay(day)) {
                Events.add(e);
            }
        }
        return Events;
    }
}